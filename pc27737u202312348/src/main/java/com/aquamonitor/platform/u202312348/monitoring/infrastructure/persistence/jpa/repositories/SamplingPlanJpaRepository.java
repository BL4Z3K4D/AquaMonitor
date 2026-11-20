package com.aquamonitor.platform.u202312348.monitoring.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aquamonitor.platform.u202312348.monitoring.infrastructure.persistence.jpa.entities.SamplingPlanEntity;

/** Spring Data repository for sampling-plan persistence. @author Yazid Said */
public interface SamplingPlanJpaRepository extends JpaRepository<SamplingPlanEntity, Long> {
    boolean existsByPlanCode(String planCode);
}
