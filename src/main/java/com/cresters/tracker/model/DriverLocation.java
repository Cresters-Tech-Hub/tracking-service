package com.cresters.tracker.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverLocation {

    @Id
    private long id;
    private long driverId;
    @Embedded
    private Location driverLocation;
    private String lastUpdatedTime;
//    @Embedded
//    private Location startLocation;
//    @Embedded
//    private Location endLocation;


}
