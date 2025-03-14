package com.jallenyu.report_tracker_backend.repository;

import com.jallenyu.report_tracker_backend.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository extends JpaRepository<Demo, Long> {
}
