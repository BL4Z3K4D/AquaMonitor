package com.aquamonitor.platform.u202312348.monitoring.application.internal.commandservices;

import org.springframework.stereotype.Service;
import com.aquamonitor.platform.u202312348.monitoring.application.commandservices.CreateSamplingPlanUseCase;
import com.aquamonitor.platform.u202312348.monitoring.domain.exceptions.DuplicatePlanCodeException;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.aggregates.SamplingPlan;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.commands.CreateSamplingPlanCommand;
import com.aquamonitor.platform.u202312348.monitoring.domain.repositories.SamplingPlanRepository;
import com.aquamonitor.platform.u202312348.shared.application.Result;

/** Executes the sampling-plan creation use case. @author Yazid Said */
@Service
public class CreateSamplingPlanService implements CreateSamplingPlanUseCase {
    private static final String DUPLICATE_CODE_MESSAGE = "sampling-plan.plan-code.duplicate";
    private final SamplingPlanRepository repository;

    public CreateSamplingPlanService(SamplingPlanRepository repository) {
        this.repository = repository;
    }

    /** Checks for an existing code and persists the aggregate; the database constraint handles races.
     * @param command plan registration data @return successful plan or duplicate-code failure */
    @Override
    public Result<SamplingPlan> handle(CreateSamplingPlanCommand command) {
        if (repository.existsByPlanCode(command.planCode())) {
            return new Result.Failure<>(DUPLICATE_CODE_MESSAGE);
        }
        try {
            return new Result.Success<>(repository.save(SamplingPlan.create(command.planCode(), command.stationId(),
                command.samplingWindow(), command.sampleVolume(), command.priorityLevel(), command.status(),
                command.samplingNotes())));
        } catch (DuplicatePlanCodeException exception) {
            return new Result.Failure<>(DUPLICATE_CODE_MESSAGE);
        }
    }
}
