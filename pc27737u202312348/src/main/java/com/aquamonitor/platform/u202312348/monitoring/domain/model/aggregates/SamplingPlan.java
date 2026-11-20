package com.aquamonitor.platform.u202312348.monitoring.domain.model.aggregates;

import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.PlanCode;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.enums.SamplingPlanStatus;

/** Aggregate root for the sampling-plan registration flow. @author Yazid Said */
public final class SamplingPlan {
    private final Long id;
    private final PlanCode planCode;
    private final SamplingPlanStatus status;

    private SamplingPlan(Long id, PlanCode planCode, SamplingPlanStatus status) {
        if (planCode == null) {
            throw new IllegalArgumentException("Plan code is required.");
        }
        if (status == null) {
            throw new IllegalArgumentException("Sampling plan status is required.");
        }
        this.id = id;
        this.planCode = planCode;
        this.status = status;
    }

    /** Creates a plan before it is persisted. @param planCode unique business code @param status lifecycle status
     * @return new plan */
    public static SamplingPlan create(PlanCode planCode, SamplingPlanStatus status) {
        return new SamplingPlan(null, planCode, status);
    }

    /** Restores a plan from persistence. @param id database identity @param planCode unique business code
     * @param status lifecycle status @return restored plan */
    public static SamplingPlan rehydrate(Long id, PlanCode planCode, SamplingPlanStatus status) {
        return new SamplingPlan(id, planCode, status);
    }

    public Long getId() {
        return id;
    }

    public PlanCode getPlanCode() {
        return planCode;
    }

    public SamplingPlanStatus getStatus() {
        return status;
    }
}
