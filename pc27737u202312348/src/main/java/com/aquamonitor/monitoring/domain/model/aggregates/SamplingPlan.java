package com.aquamonitor.platform.u202312348.monitoring.domain.model.aggregates;

import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.PlanCode;

/** Aggregate root for the sampling-plan registration flow. @author Yazid Said */
public final class SamplingPlan {
    private final Long id;
    private final PlanCode planCode;

    private SamplingPlan(Long id, PlanCode planCode) {
        if (planCode == null) {
            throw new IllegalArgumentException("Plan code is required.");
        }
        this.id = id;
        this.planCode = planCode;
    }

    /** Creates a plan before it is persisted. @param planCode unique business code @return new plan */
    public static SamplingPlan create(PlanCode planCode) {
        return new SamplingPlan(null, planCode);
    }

    /** Restores a plan from persistence. @param id database identity @param planCode unique business code
     * @return restored plan */
    public static SamplingPlan rehydrate(Long id, PlanCode planCode) {
        return new SamplingPlan(id, planCode);
    }

    public Long getId() {
        return id;
    }

    public PlanCode getPlanCode() {
        return planCode;
    }
}
