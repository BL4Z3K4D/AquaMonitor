package com.aquamonitor.platform.u202312348.monitoring.interfaces.rest.transform;

import com.aquamonitor.platform.u202312348.monitoring.domain.model.aggregates.SamplingPlan;
import com.aquamonitor.platform.u202312348.monitoring.interfaces.rest.resources.SamplingPlanResource;

/** Converts a sampling-plan aggregate into its public HTTP resource. @author Yazid Said */
public final class SamplingPlanResourceFromAggregateAssembler {
    private SamplingPlanResourceFromAggregateAssembler() {
    }

    public static SamplingPlanResource toResource(SamplingPlan samplingPlan) {
        return new SamplingPlanResource(samplingPlan.getId(), samplingPlan.getPlanCode().code(),
            samplingPlan.getStationId().value().toString(),
            samplingPlan.getSamplingWindow().startDate().toString(),
            samplingPlan.getSamplingWindow().endDate().toString(),
            samplingPlan.getSampleVolume().quantity(),
            samplingPlan.getSampleVolume().unit(),
            samplingPlan.getPriorityLevel().value(),
            samplingPlan.getStatus().name(),
            samplingPlan.getSamplingNotes());
    }
}
