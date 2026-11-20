package com.aquamonitor.platform.u202312348.monitoring.domain.model.commands;

import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.PlanCode;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.enums.SamplingPlanStatus;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.PriorityLevel;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.SampleVolume;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.SamplingWindow;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.StationId;

/** Command to register a sampling plan using its business code. @author Yazid Said */
public record CreateSamplingPlanCommand(PlanCode planCode, StationId stationId, SamplingWindow samplingWindow,
    SampleVolume sampleVolume, PriorityLevel priorityLevel, SamplingPlanStatus status, String samplingNotes) {
}
