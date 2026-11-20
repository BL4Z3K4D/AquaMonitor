package com.aquamonitor.platform.u202312348.monitoring.domain.repositories;

import com.aquamonitor.platform.u202312348.monitoring.domain.model.aggregates.SamplingPlan;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.PlanCode;

/** Persistence port for sampling-plan aggregates. @author Yazid Said */
public interface SamplingPlanRepository {
    boolean existsByPlanCode(PlanCode planCode);

    SamplingPlan save(SamplingPlan samplingPlan);
}
