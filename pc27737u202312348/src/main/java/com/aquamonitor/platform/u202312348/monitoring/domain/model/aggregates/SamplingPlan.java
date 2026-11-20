package com.aquamonitor.platform.u202312348.monitoring.domain.model.aggregates;

import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.PlanCode;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.enums.SamplingPlanStatus;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.PriorityLevel;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.SampleVolume;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.SamplingWindow;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects.StationId;

/** Aggregate root for the sampling-plan registration flow. @author Yazid Said */
public final class SamplingPlan {
    private final Long id;
    private final PlanCode planCode;
    private final SamplingPlanStatus status;
    private final StationId stationId;
    private final SamplingWindow samplingWindow;
    private final SampleVolume sampleVolume;
    private final PriorityLevel priorityLevel;
    private final String samplingNotes;

    private SamplingPlan(Long id, PlanCode planCode, StationId stationId, SamplingWindow samplingWindow,
        SampleVolume sampleVolume, PriorityLevel priorityLevel, SamplingPlanStatus status, String samplingNotes) {
        if (planCode == null) {
            throw new IllegalArgumentException("Plan code is required.");
        }
        if (stationId == null) {
            throw new IllegalArgumentException("Station ID is required.");
        }
        if (samplingWindow == null) {
            throw new IllegalArgumentException("Sampling window is required.");
        }
        if (sampleVolume == null) {
            throw new IllegalArgumentException("Sample volume is required.");
        }
        if (priorityLevel == null) {
            throw new IllegalArgumentException("Priority level is required.");
        }
        if (status == null) {
            throw new IllegalArgumentException("Sampling plan status is required.");
        }
        this.id = id;
        this.planCode = planCode;
        this.stationId = stationId;
        this.samplingWindow = samplingWindow;
        this.sampleVolume = sampleVolume;
        this.priorityLevel = priorityLevel;
        this.status = status;
        this.samplingNotes = samplingNotes;
    }

    /** Creates a plan before it is persisted.
     * @param planCode unique business code
     * @param stationId monitoring station identity
     * @param samplingWindow sampling period
     * @param sampleVolume quantity and unit to collect
     * @param priorityLevel plan priority
     * @param status lifecycle status
     * @param samplingNotes optional notes
     * @return new plan */
    public static SamplingPlan create(PlanCode planCode, StationId stationId, SamplingWindow samplingWindow,
        SampleVolume sampleVolume, PriorityLevel priorityLevel, SamplingPlanStatus status, String samplingNotes) {
        return new SamplingPlan(null, planCode, stationId, samplingWindow, sampleVolume, priorityLevel, status,
            samplingNotes);
    }

    /** Restores a plan from persistence.
     * @param id database identity
     * @param planCode unique business code
     * @param stationId monitoring station identity
     * @param samplingWindow sampling period
     * @param sampleVolume quantity and unit to collect
     * @param priorityLevel plan priority
     * @param status lifecycle status
     * @param samplingNotes optional notes
     * @return restored plan */
    public static SamplingPlan rehydrate(Long id, PlanCode planCode, StationId stationId,
        SamplingWindow samplingWindow, SampleVolume sampleVolume, PriorityLevel priorityLevel,
        SamplingPlanStatus status, String samplingNotes) {
        return new SamplingPlan(id, planCode, stationId, samplingWindow, sampleVolume, priorityLevel, status,
            samplingNotes);
    }

    public Long getId() {
        return id;
    }

    public PlanCode getPlanCode() {
        return planCode;
    }

    public SamplingPlanStatus getStatus() {
        return status;
    }

    public StationId getStationId() {
        return stationId;
    }

    public SamplingWindow getSamplingWindow() {
        return samplingWindow;
    }

    public SampleVolume getSampleVolume() {
        return sampleVolume;
    }

    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }

    public String getSamplingNotes() {
        return samplingNotes;
    }
}
