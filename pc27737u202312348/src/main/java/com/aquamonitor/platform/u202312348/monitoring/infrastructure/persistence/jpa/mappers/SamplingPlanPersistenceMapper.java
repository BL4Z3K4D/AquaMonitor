package com.aquamonitor.platform.u202312348.monitoring.infrastructure.persistence.jpa.mappers;

import com.aquamonitor.platform.u202312348.monitoring.domain.model.aggregates.SamplingPlan;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.PlanCode;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.PriorityLevel;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.SampleVolume;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.SamplingWindow;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.StationId;
import com.aquamonitor.platform.u202312348.monitoring.infrastructure.persistence.jpa.entities.SamplingPlanEntity;

/** Converts sampling plans between the domain and JPA models. @author Yazid Said */
public final class SamplingPlanPersistenceMapper {
    private SamplingPlanPersistenceMapper() {
    }

    public static SamplingPlanEntity toEntity(SamplingPlan samplingPlan) {
        var entity = new SamplingPlanEntity();
        entity.setId(samplingPlan.getId());
        entity.setPlanCode(samplingPlan.getPlanCode().code());
        entity.setStationId(samplingPlan.getStationId().value());
        entity.setSamplingWindowStartDate(samplingPlan.getSamplingWindow().startDate());
        entity.setSamplingWindowEndDate(samplingPlan.getSamplingWindow().endDate());
        entity.setSampleVolumeQuantity(samplingPlan.getSampleVolume().quantity());
        entity.setSampleVolumeUnit(samplingPlan.getSampleVolume().unit());
        entity.setPriorityLevel(samplingPlan.getPriorityLevel().value());
        entity.setStatus(samplingPlan.getStatus());
        entity.setSamplingNotes(samplingPlan.getSamplingNotes());
        return entity;
    }

    public static SamplingPlan toDomain(SamplingPlanEntity entity) {
        return SamplingPlan.rehydrate(
            entity.getId(),
            new PlanCode(entity.getPlanCode()),
            new StationId(entity.getStationId()),
            new SamplingWindow(entity.getSamplingWindowStartDate(), entity.getSamplingWindowEndDate()),
            new SampleVolume(entity.getSampleVolumeQuantity(), entity.getSampleVolumeUnit()),
            new PriorityLevel(entity.getPriorityLevel()),
            entity.getStatus(),
            entity.getSamplingNotes());
    }
}
