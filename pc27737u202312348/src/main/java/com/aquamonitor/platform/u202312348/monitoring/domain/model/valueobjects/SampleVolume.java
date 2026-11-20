package com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects;

/** Represents a positive integer water-sample volume and its unit. @author Yazid Said */
public record SampleVolume(Integer quantity, String unit) {

    /** Validates and creates a sample volume.
     * @param quantity positive volume in whole units
     * @param unit required unit of measure
     * @throws IllegalArgumentException if the quantity or unit is invalid */
    public SampleVolume {
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Sample volume quantity must be greater than zero.");
        }
        if (unit == null || unit.isBlank()) {
            throw new IllegalArgumentException("Sample volume unit must not be null or blank.");
        }
        unit = unit.trim();
    }

    /** Returns a new volume increased by the requested quantity without changing this value object.
     * @param additionalVolume positive whole-unit volume to add
     * @return a new sample volume with the same unit
     * @throws IllegalArgumentException if the increment is null, non-positive, or overflows an Integer */
    public SampleVolume addVolume(Integer additionalVolume) {
        if (additionalVolume == null || additionalVolume <= 0) {
            throw new IllegalArgumentException("Additional sample volume must be greater than zero.");
        }
        if (additionalVolume > Integer.MAX_VALUE - quantity) {
            throw new IllegalArgumentException("Sample volume quantity exceeds the maximum Integer value.");
        }
        return new SampleVolume(quantity + additionalVolume, unit);
    }
}
