package com.jallenyu.report_tracker_backend.service;

import com.jallenyu.report_tracker_backend.entity.Report;
import com.jallenyu.report_tracker_backend.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    private final ReportRepository repository;

    public ReportService(ReportRepository repository) {
        this.repository = repository;
    }

    public Report addReport(Report report) {
        return repository.save(report);
    }

    public List<Report> getReports() {
        return repository.findAll();
    }

    public String deleteReport(Long id) {
        repository.deleteById(id);
        return "Report deleted: " + id;
    }

    public Report updateReport(Report report) {
        Report existingReport = repository.findById(report.getReportId()).orElse(null);

        if (existingReport == null) {
            throw new RuntimeException("Report not found with ID: " + report.getReportId());
        }

        existingReport.setReportId(report.getReportId());
        existingReport.setClientName(report.getClientName());
        existingReport.setInspectionDate(report.getInspectionDate());
        existingReport.setDueDate(report.getDueDate());
        existingReport.setExpedited(report.isExpedited());
        existingReport.setTags(report.getTags());
        existingReport.setNotes(report.getNotes());
        existingReport.setStatus(report.getStatus());

        return repository.save(existingReport);
    }
}
