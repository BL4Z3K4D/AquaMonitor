package com.aquamonitor.platform.u202312348.monitoring.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import java.time.LocalDate;
import java.util.UUID;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.enums.SamplingPlanStatus;

/** HTTP input for creating a sampling plan. @author Yazid Said */
public class CreateSamplingPlanResource {
    private String planCode;
    private UUID stationId;
    private LocalDate samplingWindowStartDate;
    private LocalDate samplingWindowEndDate;
    private Integer sampleVolumeQuantity;
    private String sampleVolumeUnit;
    private Integer priorityLevel;
    private SamplingPlanStatus status = SamplingPlanStatus.PENDING;
    private String samplingNotes;

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public UUID getStationId() {
        return stationId;
    }

    public void setStationId(UUID stationId) {
        this.stationId = stationId;
    }

    public LocalDate getSamplingWindowStartDate() {
        return samplingWindowStartDate;
    }

    public void setSamplingWindowStartDate(LocalDate samplingWindowStartDate) {
        this.samplingWindowStartDate = samplingWindowStartDate;
    }

    public LocalDate getSamplingWindowEndDate() {
        return samplingWindowEndDate;
    }

    public void setSamplingWindowEndDate(LocalDate samplingWindowEndDate) {
        this.samplingWindowEndDate = samplingWindowEndDate;
    }

    public Integer getSampleVolumeQuantity() {
        return sampleVolumeQuantity;
    }

    public void setSampleVolumeQuantity(Integer sampleVolumeQuantity) {
        this.sampleVolumeQuantity = sampleVolumeQuantity;
    }

    public String getSampleVolumeUnit() {
        return sampleVolumeUnit;
    }

    public void setSampleVolumeUnit(String sampleVolumeUnit) {
        this.sampleVolumeUnit = sampleVolumeUnit;
    }

    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public SamplingPlanStatus getStatus() {
        return status;
    }

    @JsonSetter(value = "status", nulls = Nulls.FAIL)
    public void setStatus(SamplingPlanStatus status) {
        this.status = status;
    }

    public String getSamplingNotes() {
        return samplingNotes;
    }

    public void setSamplingNotes(String samplingNotes) {
        this.samplingNotes = samplingNotes;
    }
}
