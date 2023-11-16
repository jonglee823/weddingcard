package com.wedding.weddingcard.controller;

import com.wedding.weddingcard.request.CommentRequest;
import com.wedding.weddingcard.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping(value="/posts")
    public void post(@RequestBody @Valid CommentRequest request){
        commentService.write(request);
    }
}