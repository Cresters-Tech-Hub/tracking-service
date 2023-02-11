package com.cresters.tracker.request;

import com.cresters.tracker.model.Location;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateDriverLocationRequest {

    @NotBlank
    long driverId;
    private Location driverLocation;
}
