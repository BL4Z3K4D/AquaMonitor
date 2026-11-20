package com.aquamonitor.platform.u202312348.monitoring.infrastructure.persistence.jpa.adapters;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import com.aquamonitor.platform.u202312348.monitoring.domain.exceptions.DuplicatePlanCodeException;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.aggregates.SamplingPlan;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.PlanCode;
import com.aquamonitor.platform.u202312348.monitoring.domain.repositories.SamplingPlanRepository;
import com.aquamonitor.platform.u202312348.monitoring.infrastructure.persistence.jpa.entities.SamplingPlanEntity;
import com.aquamonitor.platform.u202312348.monitoring.infrastructure.persistence.jpa.mappers.SamplingPlanPersistenceMapper;
import com.aquamonitor.platform.u202312348.monitoring.infrastructure.persistence.jpa.repositories.SamplingPlanJpaRepository;

/** Adapts the domain persistence port to Spring Data JPA. @author Yazid Said */
@Repository
public class SamplingPlanRepositoryAdapter implements SamplingPlanRepository {
    private final SamplingPlanJpaRepository repository;

    public SamplingPlanRepositoryAdapter(SamplingPlanJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsByPlanCode(PlanCode planCode) {
        return repository.existsByPlanCode(planCode.value());
    }

    @Override
    public SamplingPlan save(SamplingPlan samplingPlan) {
        try {
            var saved = repository.saveAndFlush(SamplingPlanPersistenceMapper.toEntity(samplingPlan));
            return SamplingPlanPersistenceMapper.toDomain(saved);
        } catch (DataIntegrityViolationException exception) {
            if (violatesPlanCodeConstraint(exception)) {
                throw new DuplicatePlanCodeException(exception);
            }
            throw exception;
        }
    }

    private boolean violatesPlanCodeConstraint(DataIntegrityViolationException exception) {
        for (Throwable cause = exception; cause != null; cause = cause.getCause()) {
            if (cause instanceof ConstraintViolationException violation
                && SamplingPlanEntity.PLAN_CODE_UNIQUE_CONSTRAINT.equals(violation.getConstraintName())) {
                return true;
            }
            if (cause instanceof java.sql.SQLException sqlException
                && sqlException.getErrorCode() == 1062
                && sqlException.getMessage() != null
                && sqlException.getMessage().contains(SamplingPlanEntity.PLAN_CODE_UNIQUE_CONSTRAINT)) {
                return true;
            }
        }
        return false;
    }
}
