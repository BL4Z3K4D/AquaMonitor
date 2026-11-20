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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SamplingPlanStatus status;

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

    public SamplingPlanStatus getStatus() {
        return status;
    }

    public void setStatus(SamplingPlanStatus status) {
        this.status = status;
    }
}
