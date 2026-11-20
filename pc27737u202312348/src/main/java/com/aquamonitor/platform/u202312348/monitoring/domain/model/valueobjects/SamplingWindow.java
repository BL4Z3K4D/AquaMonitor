package com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects;

import java.time.LocalDate;

/** Represents the inclusive date range for sampling a water body. @author Yazid Said */
public record SamplingWindow(LocalDate startDate, LocalDate endDate) {

    public SamplingWindow {
        if (startDate == null) {
            throw new IllegalArgumentException("Sampling window start date must not be null.");
        }
        if (endDate == null) {
            throw new IllegalArgumentException("Sampling window end date must not be null.");
        }
        if (!endDate.isAfter(startDate)) {
            throw new IllegalArgumentException("Sampling window end date must be after the start date.");
        }
    }

    /** Checks whether a date falls within the sampling window, including both boundary dates.
     * @param checkDate date to check
     * @return true when the date is within the range; otherwise false
     * @throws IllegalArgumentException if checkDate is null */
    public boolean contains(LocalDate checkDate) {
        if (checkDate == null) {
            throw new IllegalArgumentException("Date to check must not be null.");
        }
        return !checkDate.isBefore(startDate) && !checkDate.isAfter(endDate);
    }
}
