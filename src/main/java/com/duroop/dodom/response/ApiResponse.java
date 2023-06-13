package com.duroop.dodom.response;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class ApiResponse<T> {

    private final ApiResponseHeader header;
    private final Map<String, T> body;

    public static <T> ApiResponse<T> of(HttpStatus status, String key, T value) {
        Map<String, T> body = new HashMap<>() {{ put(key, value); }};

        return new ApiResponse<>(new ApiResponseHeader(status.value(), status.getReasonPhrase()), body);
    }
}
