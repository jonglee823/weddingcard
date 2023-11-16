package com.wedding.weddingcard.response;


import lombok.Builder;
import lombok.Getter;
import org.springframework.jdbc.support.incrementer.HanaSequenceMaxValueIncrementer;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ErrorResponse {

    private final String code;

    private final String message;

    private final Map<String, String> validMap = new HashMap<>();

    @Builder
    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public void addValidMap(List<FieldError> fieldErrors){
        fieldErrors.forEach(error ->{
            validMap.put(error.getField(), error.getDefaultMessage());
        });
    }
}
