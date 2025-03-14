package com.jallenyu.report_tracker_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    private String clientName;
    private LocalDate inspectionDate;
    private LocalDate dueDate;
    private boolean expedited;

    @ElementCollection
    private List<String> tags;

    private String notes;
    private String status;


    public Long getReportId() {
        return reportId;
    }

    public String getClientName() {
        return clientName;
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isExpedited() {
        return expedited;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getNotes() {
        return notes;
    }

    public String getStatus() {
        return status;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setExpedited(boolean expedited) {
        this.expedited = expedited;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}