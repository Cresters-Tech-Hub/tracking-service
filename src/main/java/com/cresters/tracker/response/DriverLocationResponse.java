package com.cresters.tracker.response;

import lombok.Data;

@Data
public class DriverLocationResponse {

    private long driverId;
    private String driverLocation;
    private String lastUpdatedTime;
    private String startLocation;
    private String endLocation;
}
