package com.cresters.tracker.service.impl;

import com.cresters.tracker.model.DriverLocation;
import com.cresters.tracker.repository.DriverRepository;
import com.cresters.tracker.request.CreateDriverRequest;
import com.cresters.tracker.request.UpdateDriverDestination;
import com.cresters.tracker.request.UpdateDriverLocationRequest;
import com.cresters.tracker.response.CreateDriverResponse;
import com.cresters.tracker.response.DriverLocationResponse;
import com.cresters.tracker.response.UpdateDriverLocationResponse;
import com.cresters.tracker.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final ModelMapper modelMapper;

    public UpdateDriverLocationResponse updateDriverLocation(UpdateDriverLocationRequest updateDriverLocationRequest) {
        Optional<DriverLocation> location = driverRepository.findByDriverId(updateDriverLocationRequest.getDriverId());
        if (location.isPresent()) {
            location.get().setDriverLocation(updateDriverLocationRequest.getDriverLocation());
            location.get().setLastUpdatedTime(LocalDateTime.now().toString());
        } else {
            throw new IllegalArgumentException("Driver id not found");
        }
            return modelMapper.map(location, UpdateDriverLocationResponse.class);
    }

    public CreateDriverResponse createDriver(CreateDriverRequest createDriverRequest) {
        DriverLocation driverLocation = driverRepository.save(DriverLocation.builder()
                        .driverId(createDriverRequest.getDriverId())
                        .driverLocation(createDriverRequest.getDriverLocation())
                        .lastUpdatedTime(LocalDateTime.now().toString())
//                        .endLocation(createDriverRequest.getEndLocation())
//                        .startLocation(createDriverRequest.getStartLocation())
                .build());
        return modelMapper.map(driverLocation, CreateDriverResponse.class);
    }

    public DriverLocationResponse getDriverLocation(long driverId) {
        Optional<DriverLocation> location = driverRepository.findByDriverId(driverId);
        if (location.isPresent()) {
            return modelMapper.map(location, DriverLocationResponse.class);
        } else {
            throw new IllegalArgumentException("Driver id not found");
        }

    }

    @Override
    public DriverLocationResponse updateDriverDestination(UpdateDriverDestination driverDestination) {
        Optional<DriverLocation> location = driverRepository.findByDriverId(driverDestination.getDriverId());
        if (location.isPresent()) {
//            location.get().setEndLocation(driverDestination.getDriverDestination());
//            location.get().setStartLocation(driverDestination.getDriverStartingPoint());
            location.get().setLastUpdatedTime(LocalDateTime.now().toString());
        } else {
            throw new IllegalArgumentException("Driver id not found");
        }
        return modelMapper.map(location, DriverLocationResponse.class);
    }
}
