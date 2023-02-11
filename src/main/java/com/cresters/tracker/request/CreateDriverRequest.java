package com.cresters.tracker.request;

import com.cresters.tracker.model.Location;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateDriverRequest {

    @NotBlank
    long driverId;
    Location driverLocation;
    Location startLocation;
    Location endLocation;
}
