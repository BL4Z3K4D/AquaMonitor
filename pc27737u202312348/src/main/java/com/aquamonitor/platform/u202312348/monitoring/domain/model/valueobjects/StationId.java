package com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects;

import java.util.UUID;

/** Identifies a monitoring station owned by another bounded context. @author Yazid Said */
public record StationId(UUID value) {
    public StationId {
        if (value == null) {
            throw new IllegalArgumentException("Station ID must not be null.");
        }
    }
}
