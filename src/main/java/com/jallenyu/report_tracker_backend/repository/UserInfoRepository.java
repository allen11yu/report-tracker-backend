package com.jallenyu.report_tracker_backend.repository;

import com.jallenyu.report_tracker_backend.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    Optional<Object> findByUsername(String username);
}
