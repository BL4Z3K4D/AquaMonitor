package com.aquamonitor.platform.u202312348.monitoring.infrastructure.persistence.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDate;
import java.util.UUID;
import com.aquamonitor.platform.u202312348.monitoring.domain.model.enums.SamplingPlanStatus;

/** JPA persistence representation of a sampling plan. @author Yazid Said */
@Entity
@Table(name = "sampling_plans", schema = "aqua_monitor",
    uniqueConstraints = @UniqueConstraint(
        name = SamplingPlanEntity.PLAN_CODE_UNIQUE_CONSTRAINT,
        columnNames = "plan_code"))
public class SamplingPlanEntity {
    public static final String PLAN_CODE_UNIQUE_CONSTRAINT = "uk_sampling_plans_plan_code";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plan_code", nullable = false, length = 255)
    private String planCode;

    @Column(name = "station_id", nullable = false, columnDefinition = "BINARY(16)")
    private UUID stationId;

    @Column(name = "sampling_window_start_date", nullable = false)
    private LocalDate samplingWindowStartDate;

    @Column(name = "sampling_window_end_date", nullable = false)
    private LocalDate samplingWindowEndDate;

    @Column(name = "sample_volume_quantity", nullable = false)
    private Integer sampleVolumeQuantity;

    @Column(name = "sample_volume_unit", nullable = false, length = 50)
    private String sampleVolumeUnit;

    @Column(name = "priority_level", nullable = false)
    private Integer priorityLevel;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SamplingPlanStatus status;

    @Column(name = "sampling_notes", length = 2000)
    private String samplingNotes;

    public SamplingPlanEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
