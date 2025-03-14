package com.jallenyu.report_tracker_backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "demo")
public class Demo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @JsonProperty("clientName")
    private String clientName;

    @JsonProperty("inspectionDate")
    private LocalDate inspectionDate;

    @JsonProperty("dueDate")
    private LocalDate dueDate;

    @JsonProperty("expedited")
    private boolean expedited;

    @JsonProperty("tags")
    @ElementCollection
    private List<String> tags;

    @JsonProperty("notes")
    private String notes;

    @JsonProperty("status")
    private String status;
}
