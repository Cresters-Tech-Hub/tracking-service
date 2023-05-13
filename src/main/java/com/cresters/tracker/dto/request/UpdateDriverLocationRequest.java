package com.cresters.tracker.dto.request;

import com.cresters.tracker.model.Location;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateDriverLocationRequest {

    @NotNull
    Long driverId;
    private Location driverLocation;
}
