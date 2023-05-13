package com.cresters.tracker.exceptions;

import com.cresters.tracker.dto.global.DispatchResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
    @ResponseBody
    public DispatchResponse<?> handleNullPointerException(final NullPointerException ex) {
        return DispatchResponse.builder().data("").status(HttpStatus.FAILED_DEPENDENCY.value())
                .message(ex.getMessage()).error(ex.getMessage())
                .build();
    }
}
