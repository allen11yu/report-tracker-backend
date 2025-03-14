package com.jallenyu.report_tracker_backend.controller;

import com.jallenyu.report_tracker_backend.entity.Report;
import com.jallenyu.report_tracker_backend.service.ReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Report addReport(@RequestBody Report report) {
        return service.addReport(report);
    }

    @GetMapping("/all")
    public List<Report> getReports() {
        return service.getReports();
    }

    @PutMapping("/update")
    public Report updateReport(@RequestBody Report report) {
        return service.updateReport(report);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteReport(@PathVariable Long id) {
        return service.deleteReport(id);
    }
}
