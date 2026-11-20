package com.aquamonitor.platform.u202312348.monitoring.domain.model.valueobjects;

/** Identifies a sampling plan by its required, non-blank code. @author Yazid Said */
public record PlanCode(String code) {
    public PlanCode {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Plan code must not be null or blank.");
        }
        code = code.trim();
    }
}
