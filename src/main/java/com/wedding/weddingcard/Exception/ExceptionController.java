package com.wedding.weddingcard.Exception;


import com.wedding.weddingcard.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse InvalidMethodArgumentNotValidException(MethodArgumentNotValidException e){
        ErrorResponse errorResponse = ErrorResponse.builder()
                                    .code("400")
                                    .message("잘못된 요청입니다.")
                                    .build();
        errorResponse.addValidMap(e.getFieldErrors());
        return errorResponse;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoSuchAlgorithmException.class)
    public ErrorResponse NoSuchAlgorithmException(NoSuchAlgorithmException e){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("400")
                .message("잘못된 비밀번호 입니다.")
                .build();
        return errorResponse;
    }
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse RuntimeException(RuntimeException e){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("200")
                .message("관리자에게 문의해주세요.")
                .build();
        return errorResponse;
    }



}

