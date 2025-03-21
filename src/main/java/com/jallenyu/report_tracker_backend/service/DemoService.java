package com.jallenyu.report_tracker_backend.service;

import com.jallenyu.report_tracker_backend.entity.Demo;
import com.jallenyu.report_tracker_backend.repository.DemoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    private final DemoRepository repository;

    public DemoService(DemoRepository repository) {
        this.repository = repository;
    }

    public List<Demo> getDemoReports() {
        return repository.findAll();
    }
}
