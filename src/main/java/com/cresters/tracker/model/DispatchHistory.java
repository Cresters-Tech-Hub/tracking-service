package com.cresters.tracker.model;

import com.cresters.tracker.constants.CompletionStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DispatchHistory {

    @Id
    private long id;
    private long driverId;
    private double start_lat;
    private double start_long;
    private double end_lat;
    private double end_long;
    String start_location;
    String end_location;
    CompletionStatus ride_status;
    LocalDateTime timeStarted;
    LocalTime timeCompleted;
    LocalDateTime expectedTimeToComplete;


}
