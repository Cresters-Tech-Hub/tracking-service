package com.cresters.tracker.controllers;

import com.cresters.tracker.request.CreateDriverRequest;
import com.cresters.tracker.request.UpdateDriverDestination;
import com.cresters.tracker.request.UpdateDriverLocationRequest;
import com.cresters.tracker.response.CreateDriverResponse;
import com.cresters.tracker.response.DispatchResponse;
import com.cresters.tracker.response.DriverLocationResponse;
import com.cresters.tracker.response.UpdateDriverLocationResponse;
import com.cresters.tracker.service.DriverService;
import com.cresters.tracker.utils.ResponseUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DispatchController {

    private final DriverService driverService;


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

    @PostMapping("/createDriver")
    ResponseEntity<DispatchResponse<CreateDriverResponse>>
    createDriver(@RequestBody @Valid CreateDriverRequest createDriverRequest) {
        CreateDriverResponse response = driverService.createDriver(createDriverRequest);

        return ResponseEntity.ok().body(DispatchResponse.<CreateDriverResponse>builder()
                .message(ResponseUtil.SUCC)
                .status(HttpStatus.OK.value())
                .data(response)
                .error("")
                .build());
    }

    @GetMapping("{driverId}")
    ResponseEntity<DispatchResponse<DriverLocationResponse>> getDriverLocation(@PathVariable long driverId) {
        DriverLocationResponse response = driverService.getDriverLocation(driverId);

        return ResponseEntity.ok().body(DispatchResponse.<DriverLocationResponse>builder()
                .message(ResponseUtil.SUCC)
                .status(HttpStatus.OK.value())
                .data(response)
                .error("")
                .build());
    }

    @PostMapping("/updateDriverDestination")
    ResponseEntity<DispatchResponse<DriverLocationResponse>> updateDriverDestination(@RequestBody UpdateDriverDestination driverLocationRequest) {
        DriverLocationResponse response = driverService.updateDriverDestination(driverLocationRequest);

        return ResponseEntity.ok().body(DispatchResponse.<DriverLocationResponse>builder()
                .message(ResponseUtil.SUCC)
                .status(HttpStatus.OK.value())
                .data(response)
                .error("")
                .build());
    }


}
