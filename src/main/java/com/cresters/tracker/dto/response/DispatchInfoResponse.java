package com.cresters.tracker.dto.response;

import lombok.Data;

@Data
public class DispatchInfoResponse {
    private long dispatchId;

    private double startLongitude;
    private double startLatitude;

    private double endLatitude;
    private double endLongitude;

    private double currentLongitude;
    private double currentLatitude;

    private boolean isAvailable;
}
