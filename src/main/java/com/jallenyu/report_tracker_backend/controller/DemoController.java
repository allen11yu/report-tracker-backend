package com.jallenyu.report_tracker_backend.controller;

import com.jallenyu.report_tracker_backend.entity.Demo;
import com.jallenyu.report_tracker_backend.entity.Report;
import com.jallenyu.report_tracker_backend.service.DemoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private final DemoService service;

    public DemoController(DemoService service) {
        this.service = service;
    }

    @GetMapping("/reports")
    public List<Demo> getDemoReports() {
        return service.getDemoReports();
    }
}
