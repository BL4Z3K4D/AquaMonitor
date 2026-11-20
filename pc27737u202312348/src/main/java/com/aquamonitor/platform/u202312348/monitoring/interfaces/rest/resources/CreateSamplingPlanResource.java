package com.aquamonitor.platform.u202312348.monitoring.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.enums.SamplingPlanStatus;

/** HTTP input for creating a sampling plan. @author Yazid Said */
public class CreateSamplingPlanResource {
    private String planCode;
    private SamplingPlanStatus status = SamplingPlanStatus.PENDING;

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public SamplingPlanStatus getStatus() {
        return status;
    }

    @JsonSetter(value = "status", nulls = Nulls.FAIL)
    public void setStatus(SamplingPlanStatus status) {
        this.status = status;
    }
}
