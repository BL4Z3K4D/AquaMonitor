package com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects;

/** Represents a sampling-plan priority from 1 (lowest) to 5 (highest). @author Yazid Said */
public record PriorityLevel(Integer value) {
    /** Validates that the priority is within its supported range.
     * @param value priority from 1 through 5, inclusive
     * @throws IllegalArgumentException if the value is null or outside the range */
    public PriorityLevel {
        if (value == null || value < 1 || value > 5) {
            throw new IllegalArgumentException("Priority level must be an integer between 1 and 5.");
        }
    }
}
