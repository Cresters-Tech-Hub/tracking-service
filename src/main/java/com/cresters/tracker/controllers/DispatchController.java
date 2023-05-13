package com.cresters.tracker.controllers;

import com.cresters.tracker.dto.global.DispatchResponse;
import com.cresters.tracker.dto.request.DispatchStartAndDestinationRequest;
import com.cresters.tracker.dto.request.UpdateDriverLocationRequest;
import com.cresters.tracker.dto.response.*;
import com.cresters.tracker.service.DispatchService;
import com.cresters.tracker.utils.ResponseUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DispatchController {

    private final DispatchService driverService;

    //Controllers
    //Get driverLocation
    //Update Driver location
    //Get driver History


    @PostMapping("/update")
    ResponseEntity<DispatchResponse<UpdateDriverLocationResponse>>
    updateDriverLocation(@RequestBody @Valid UpdateDriverLocationRequest updateDriverLocationRequest) {
        UpdateDriverLocationResponse response = driverService.updateDriverLocation(updateDriverLocationRequest);

        return ResponseEntity.ok().body(DispatchResponse.<UpdateDriverLocationResponse>builder()
                .message(ResponseUtil.SUCC)
                .status(HttpStatus.OK.value())
                .data(response)
                .error("")
                .build());
    }

    @GetMapping("{driverId}")
    ResponseEntity<DispatchResponse<DispatchInfoResponse>> getDriverLocation(@PathVariable long driverId) {
        DispatchInfoResponse response = driverService.getDispatchInformation(driverId);

        return ResponseEntity.ok().body(DispatchResponse.<DispatchInfoResponse>builder()
                .message(ResponseUtil.SUCC)
                .status(HttpStatus.OK.value())
                .data(response)
                .error("")
                .build());
    }

    @PostMapping("/updateDriverDestinations")
    ResponseEntity<DispatchResponse<DriverLocationResponse>> updateDriverDestination(@RequestBody DispatchStartAndDestinationRequest driverLocationRequest) {
        DriverLocationResponse response = driverService.updateDriverDestination(driverLocationRequest);

        return ResponseEntity.ok().body(DispatchResponse.<DriverLocationResponse>builder()
                .message(ResponseUtil.SUCC)
                .status(HttpStatus.OK.value())
                .data(response)
                .error("")
                .build());
    }


}
