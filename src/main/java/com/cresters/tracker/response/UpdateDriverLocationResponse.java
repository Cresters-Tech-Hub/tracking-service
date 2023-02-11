package com.cresters.tracker.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateDriverLocationResponse {
    private long id;
    private String location;

}
