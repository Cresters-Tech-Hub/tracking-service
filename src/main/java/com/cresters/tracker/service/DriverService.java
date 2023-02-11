package com.cresters.tracker.service;

import com.cresters.tracker.request.CreateDriverRequest;
import com.cresters.tracker.request.UpdateDriverDestination;
import com.cresters.tracker.request.UpdateDriverLocationRequest;
import com.cresters.tracker.response.CreateDriverResponse;
import com.cresters.tracker.response.DriverLocationResponse;
import com.cresters.tracker.response.UpdateDriverLocationResponse;
import org.springframework.stereotype.Service;

@Service
public interface DriverService {

     UpdateDriverLocationResponse updateDriverLocation(UpdateDriverLocationRequest updateDriverLocationRequest);

    CreateDriverResponse createDriver(CreateDriverRequest createDriverRequest);

    DriverLocationResponse getDriverLocation(long driverId);

    DriverLocationResponse updateDriverDestination(UpdateDriverDestination driverLocationRequest);
}
