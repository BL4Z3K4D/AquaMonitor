package com.aquamonitor.platform.u202312348.monitoring.interfaces.rest.transform;

import com.aquamonitor.platform.u202312348.monitoring.domain.model.commands.CreateSamplingPlanCommand;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.PlanCode;
import com.aquamonitor.platform.u202312348.monitoring.interfaces.rest.resources.CreateSamplingPlanResource;

/** Converts the HTTP request into an application command. @author Yazid Said */
public final class CreateSamplingPlanCommandFromResourceAssembler {
    private CreateSamplingPlanCommandFromResourceAssembler() {
    }

    public static CreateSamplingPlanCommand toCommand(CreateSamplingPlanResource resource) {
        return new CreateSamplingPlanCommand(new PlanCode(resource.getPlanCode()), resource.getStatus());
    }
}
