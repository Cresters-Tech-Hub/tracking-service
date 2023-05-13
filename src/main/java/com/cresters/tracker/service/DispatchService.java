package com.cresters.tracker.service;


import com.cresters.tracker.dto.request.DispatchStartAndDestinationRequest;

import com.cresters.tracker.dto.request.UpdateDriverLocationRequest;
import com.cresters.tracker.dto.response.*;
import org.springframework.stereotype.Service;

@Service
public interface DispatchService {

    UpdateDriverLocationResponse updateDriverLocation(UpdateDriverLocationRequest updateDriverLocationRequest);
    DriverLocationResponse getDriverLocation(long driverId);
    DriverLocationResponse updateDriverDestination(DispatchStartAndDestinationRequest driverLocationRequest);
    DispatchInfoResponse getDispatchInformation(long driverId);
}
