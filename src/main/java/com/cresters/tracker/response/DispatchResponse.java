package com.cresters.tracker.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DispatchResponse<T> {

    private int status;
    private String message;
    private T data;
    @Builder.Default
    private Object error = new ArrayList<>();
}
