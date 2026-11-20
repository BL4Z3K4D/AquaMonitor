package com.aquamonitor.platform.u202312348.monitoring.infrastructure.persistence.jpa.mappers;

import com.aquamonitor.platform.u202312348.monitoring.domain.model.aggregates.SamplingPlan;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.PlanCode;
import com.aquamonitor.platform.u202312348.monitoring.infrastructure.persistence.jpa.entities.SamplingPlanEntity;

/** Converts sampling plans between the domain and JPA models. @author Yazid Said */
public final class SamplingPlanPersistenceMapper {
    private SamplingPlanPersistenceMapper() {
    }

    public static SamplingPlanEntity toEntity(SamplingPlan samplingPlan) {
        var entity = new SamplingPlanEntity();
        entity.setId(samplingPlan.getId());
        entity.setPlanCode(samplingPlan.getPlanCode().value());
        return entity;
    }

    public static SamplingPlan toDomain(SamplingPlanEntity entity) {
        return SamplingPlan.rehydrate(entity.getId(), new PlanCode(entity.getPlanCode()));
    }
}
