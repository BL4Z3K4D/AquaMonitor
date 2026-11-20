package com.aquamonitor.platform.u202312348.monitoring.domain.model.commands;

import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.PlanCode;

/** Command to register a sampling plan using its business code. @author Yazid Said */
public record CreateSamplingPlanCommand(PlanCode planCode) {
}
