package com.cresters.tracker.dto.request;

import com.cresters.tracker.model.Location;
import lombok.Data;

@Data
public class UpdateDriverDestination {

    private long driverId;
    private Location driverDestination;

}
