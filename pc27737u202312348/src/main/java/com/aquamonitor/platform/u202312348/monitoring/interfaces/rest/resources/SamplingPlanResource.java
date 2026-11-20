package com.aquamonitor.platform.u202312348.monitoring.interfaces.rest.resources;

/** HTTP representation of a created sampling plan. @author Yazid Said */
public record SamplingPlanResource(
    Long id,
    String planCode,
    String stationId,
    String samplingWindowStartDate,
    String samplingWindowEndDate,
    Integer sampleVolumeQuantity,
    String sampleVolumeUnit,
    Integer priorityLevel,
    String status,
    String samplingNotes
) {
}
