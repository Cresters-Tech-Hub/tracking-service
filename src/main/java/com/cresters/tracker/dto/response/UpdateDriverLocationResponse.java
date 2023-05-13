package com.cresters.tracker.dto.response;

import com.cresters.tracker.model.Location;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateDriverLocationResponse {
    private long id;
    private Location location;

}
