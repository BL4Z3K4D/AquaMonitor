package com.aquamonitor.platform.u202312348.monitoring.domain.exceptions;

/** Signals that a sampling-plan code already exists. @author Yazid Said */
public class DuplicatePlanCodeException extends RuntimeException {
    public DuplicatePlanCodeException(Throwable cause) {
        super("A sampling plan with this plan code already exists.", cause);
    }
}
