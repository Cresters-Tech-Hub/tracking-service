package com.cresters.tracker.dto.request;

import com.cresters.tracker.model.Location;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DriverStartLocationRequest {

    long driverId;
    Location startLocation;
}
