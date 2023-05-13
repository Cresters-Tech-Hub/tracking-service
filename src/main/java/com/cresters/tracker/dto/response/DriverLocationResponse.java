package com.cresters.tracker.dto.response;

import com.cresters.tracker.model.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverLocationResponse {

    private long driverId;
    private Location driverLocation;

}
