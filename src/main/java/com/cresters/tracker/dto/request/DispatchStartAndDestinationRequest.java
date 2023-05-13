package com.cresters.tracker.dto.request;

import com.cresters.tracker.model.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DispatchStartAndDestinationRequest {

    long driverId;
    Location startLocation;
    Location endLocation;
}
