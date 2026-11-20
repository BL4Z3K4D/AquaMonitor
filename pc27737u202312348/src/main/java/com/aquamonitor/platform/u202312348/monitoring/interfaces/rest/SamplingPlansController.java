package com.aquamonitor.platform.u202312348.monitoring.interfaces.rest;

import java.util.Locale;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aquamonitor.platform.u202312348.monitoring.application.commandservices.CreateSamplingPlanUseCase;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.aggregates.SamplingPlan;
import com.aquamonitor.platform.u202312348.monitoring.interfaces.rest.resources.CreateSamplingPlanResource;
import com.aquamonitor.platform.u202312348.monitoring.interfaces.rest.resources.ErrorResource;
import com.aquamonitor.platform.u202312348.monitoring.interfaces.rest.transform.CreateSamplingPlanCommandFromResourceAssembler;
import com.aquamonitor.platform.u202312348.monitoring.interfaces.rest.transform.SamplingPlanResourceFromAggregateAssembler;
import com.aquamonitor.platform.u202312348.shared.application.Result;
import com.aquamonitor.platform.u202312348.shared.interfaces.rest.LocalizedMessages;

/** REST endpoint for registering sampling plans. @author Yazid Said */
@RestController
@RequestMapping("/api/v1/sampling-plans")
public class SamplingPlansController {
    private final CreateSamplingPlanUseCase createSamplingPlan;
    private final LocalizedMessages messages;

    public SamplingPlansController(CreateSamplingPlanUseCase createSamplingPlan, LocalizedMessages messages) {
        this.createSamplingPlan = createSamplingPlan;
        this.messages = messages;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> create(@RequestBody CreateSamplingPlanResource resource, Locale locale) {
        var command = CreateSamplingPlanCommandFromResourceAssembler.toCommand(resource);
        Result<SamplingPlan> result = createSamplingPlan.handle(command);
        return result.fold(
            samplingPlan -> ResponseEntity.status(HttpStatus.CREATED)
                .body(SamplingPlanResourceFromAggregateAssembler.toResource(samplingPlan)),
            messageKey -> ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResource(messages.get(messageKey, locale))));
    }
}
