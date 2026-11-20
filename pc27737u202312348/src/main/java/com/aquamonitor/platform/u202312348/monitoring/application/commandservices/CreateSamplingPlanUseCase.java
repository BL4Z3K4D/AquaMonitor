package com.aquamonitor.platform.u202312348.monitoring.application.commandservices;

import com.aquamonitor.platform.u202312348.monitoring.domain.model.aggregates.SamplingPlan;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.commands.CreateSamplingPlanCommand;
import com.aquamonitor.platform.u202312348.shared.application.Result;

/** Application port for creating a sampling plan. @author Yazid Said */
public interface CreateSamplingPlanUseCase {
    Result<SamplingPlan> handle(CreateSamplingPlanCommand command);
}
