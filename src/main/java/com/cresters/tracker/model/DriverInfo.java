package com.cresters.tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DriverInfo {

    @Id
    long id;
    long driverId;
    double driver_lat;
    double driver_long;
    boolean isAvailable;
    double start_long;
    double start_lat;
    double end_long;
    double end_lat;
    long driver_history_id;

}
