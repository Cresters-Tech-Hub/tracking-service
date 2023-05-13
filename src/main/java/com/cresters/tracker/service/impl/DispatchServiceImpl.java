package com.cresters.tracker.service.impl;

import com.cresters.tracker.dto.request.DispatchStartAndDestinationRequest;
import com.cresters.tracker.dto.request.DriverStartLocationRequest;
import com.cresters.tracker.dto.request.UpdateDriverDestination;
import com.cresters.tracker.dto.request.UpdateDriverLocationRequest;
import com.cresters.tracker.dto.response.DispatchInfoResponse;
import com.cresters.tracker.dto.response.DriverLocationResponse;
import com.cresters.tracker.dto.response.UpdateDriverLocationResponse;
import com.cresters.tracker.model.Dispatch;
import com.cresters.tracker.model.Location;
import com.cresters.tracker.repository.DispatchRepository;
import com.cresters.tracker.service.DispatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DispatchServiceImpl implements DispatchService {

    private final DispatchRepository dispatchRepository;

    @Override
    public UpdateDriverLocationResponse updateDriverLocation(UpdateDriverLocationRequest driverLocationRequest) {
        long driverId = driverLocationRequest.getDriverId();
        Dispatch dispatch;
        if (verifyDriverId(driverId)) {
            try {
                var dispatchInfo = dispatchRepository.findByDispatchId(driverId);
                if (dispatchInfo.isPresent()) {
                    dispatch = dispatchInfo.get();
                    dispatch.setCurrentLatitude(driverLocationRequest.getDriverLocation().getLatitude());
                    dispatch.setCurrentLongitude(driverLocationRequest.getDriverLocation().getLongitude());
                    dispatch = dispatchRepository.save(dispatch);
                } else {
                    dispatch = Dispatch.builder()
                            .dispatchId(driverId)
                            .currentLatitude(driverLocationRequest.getDriverLocation().getLatitude())
                            .currentLongitude(driverLocationRequest.getDriverLocation().getLongitude())
                            .build();
                    dispatch = dispatchRepository.save(dispatch);
                }
            } catch (Exception ex) {
                throw new RuntimeException("internal server error");
            }
        } else {
            throw new RuntimeException("driver not found");
        }

        return UpdateDriverLocationResponse.
                builder()
                .id(dispatch.getDispatchId())
                .location(Location.builder()
                        .latitude(dispatch.getCurrentLatitude())
                        .longitude(dispatch.getCurrentLongitude())
                        .build())
                .build();
    }

    @Override
    public DriverLocationResponse getDriverLocation(long driverId) {
        DriverLocationResponse dispatchResponse = new DriverLocationResponse();
        try {
            var dispatch = dispatchRepository.findById(driverId);
            if (dispatch.isEmpty()) {
                throw new RuntimeException("Driver not found");
            }
            Location dispatchLocation = Location.builder()
                    .latitude(dispatch.get().getCurrentLatitude())
                    .longitude(dispatch.get().getCurrentLongitude())
                    .build();
            dispatchResponse = DriverLocationResponse.
                    builder()
                    .driverLocation(dispatchLocation)
                    .build();

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return dispatchResponse;
    }


    public DriverLocationResponse updateDriverDestination(UpdateDriverDestination driverLocationRequest) {
        long driverId = driverLocationRequest.getDriverId();
        DriverLocationResponse response = new DriverLocationResponse();
        try {
            if (verifyDriverId(driverId)) {
                var dispatchInfo = dispatchRepository.findById(driverId);
                if (dispatchInfo.isPresent()) {
                    Dispatch dispatch = dispatchInfo.get();
                    dispatch.setEndLatitude(driverLocationRequest.getDriverDestination().getLatitude());
                    dispatch.setEndLongitude(driverLocationRequest.getDriverDestination().getLongitude());
                    dispatch = dispatchRepository.save(dispatch);
                    BeanUtils.copyProperties(dispatch, response);
                } else {
                    Dispatch dispatch = Dispatch.builder()
                            .dispatchId(driverId)
                            .endLatitude(driverLocationRequest.getDriverDestination().getLatitude())
                            .endLongitude(driverLocationRequest.getDriverDestination().getLongitude())
                            .build();
                    dispatch = dispatchRepository.save(dispatch);
                    BeanUtils.copyProperties(dispatch, response);
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return response;
    }

    public DriverLocationResponse updateDriverStartingPoint(DriverStartLocationRequest request) {
        long driverId = request.getDriverId();
        DriverLocationResponse response = new DriverLocationResponse();
        try {
            if (verifyDriverId(driverId)) {
                var dispatchInfo = dispatchRepository.findById(driverId);
                if (dispatchInfo.isPresent()) {
                    Dispatch dispatch = dispatchInfo.get();
                    dispatch.setStartLatitude(request.getStartLocation().getLatitude());
                    dispatch.setStartLongitude(request.getStartLocation().getLongitude());
                    dispatch = dispatchRepository.save(dispatch);
                    BeanUtils.copyProperties(dispatch, response);
                } else {
                    Dispatch dispatch = Dispatch.builder()
                            .dispatchId(driverId)
                            .startLatitude(request.getStartLocation().getLatitude())
                            .startLongitude(request.getStartLocation().getLongitude())
                            .build();
                    dispatch = dispatchRepository.save(dispatch);
                    BeanUtils.copyProperties(dispatch, response);
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return response;
    }


    @Override
    public DriverLocationResponse updateDriverDestination(DispatchStartAndDestinationRequest destinationRequest) {
        long driverId = destinationRequest.getDriverId();
        DriverLocationResponse response = new DriverLocationResponse();
        Dispatch saved = new Dispatch();
        if (verifyDriverId(driverId)) {
            var dispatch = dispatchRepository.findByDispatchId(driverId);
            if (dispatch.isPresent()) {
                dispatch.get().setStartLatitude(destinationRequest.getStartLocation().getLatitude());
                dispatch.get().setStartLongitude(destinationRequest.getStartLocation().getLongitude());
                dispatch.get().setEndLongitude(destinationRequest.getEndLocation().getLongitude());
                dispatch.get().setEndLatitude(destinationRequest.getEndLocation().getLatitude());
                saved = dispatchRepository.saveAndFlush(dispatch.get());
            } else {
                Dispatch newDispatch = Dispatch.builder()
                        .dispatchId(destinationRequest.getDriverId())
                        .startLatitude(destinationRequest.getStartLocation().getLatitude())
                        .startLongitude(destinationRequest.getStartLocation().getLongitude())
                        .endLatitude(destinationRequest.getStartLocation().getLatitude())
                        .endLongitude(destinationRequest.getEndLocation().getLongitude())
                        .build();
                saved = dispatchRepository.saveAndFlush(newDispatch);
            }
            response.setDriverId(saved.getDispatchId());
            response.setDriverLocation(Location.builder()
                    .longitude(saved.getCurrentLongitude())
                    .latitude(saved.getCurrentLatitude())
                    .build());

        } else {
            throw new RuntimeException("Driver not found");
        }
        return response;
    }


    @Override
    public DispatchInfoResponse getDispatchInformation(long driverId) {
        if (!verifyDriverId(driverId)) {
            throw new RuntimeException("Driver not found");
        }
        var dispatch = dispatchRepository.findByDispatchId(driverId);
        if (dispatch.isEmpty()) {
            throw new RuntimeException("Driver record not found");
        }
        DispatchInfoResponse response = new DispatchInfoResponse();
        BeanUtils.copyProperties(dispatch.get(), response);
        return response;

    }

    private boolean verifyDriverId(long id) {
        return true;
    }
}
