package com.aquamonitor.platform.u202312348.monitoring.interfaces.rest.transform;

import com.aquamonitor.platform.u202312348.monitoring.domain.model.commands.CreateSamplingPlanCommand;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.PlanCode;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.PriorityLevel;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.SampleVolume;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.SamplingWindow;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.StationId;
import com.aquamonitor.platform.u202312348.monitoring.interfaces.rest.resources.CreateSamplingPlanResource;

/** Converts the HTTP request into an application command. @author Yazid Said */
public final class CreateSamplingPlanCommandFromResourceAssembler {
    private CreateSamplingPlanCommandFromResourceAssembler() {
    }

    public static CreateSamplingPlanCommand toCommand(CreateSamplingPlanResource resource) {
        return new CreateSamplingPlanCommand(
            new PlanCode(resource.getPlanCode()),
            new StationId(resource.getStationId()),
            new SamplingWindow(resource.getSamplingWindowStartDate(), resource.getSamplingWindowEndDate()),
            new SampleVolume(resource.getSampleVolumeQuantity(), resource.getSampleVolumeUnit()),
            new PriorityLevel(resource.getPriorityLevel()),
            resource.getStatus(),
            resource.getSamplingNotes());
    }
}
