package com.wedding.weddingcard.service;


import com.wedding.weddingcard.domain.Comment;
import com.wedding.weddingcard.repository.CommentRepository;
import com.wedding.weddingcard.request.CommentRequest;
import com.wedding.weddingcard.util.EncryptionUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {

    private final EncryptionUtil  encryptionUtil;

    private final CommentRepository commentRepository;

    public void write(CommentRequest commentRequest){
        Comment comment = Comment.builder()
                                .title(commentRequest.getTitle())
                                .content(commentRequest.getContent())
                                .password(encryptionUtil.makepasswd(commentRequest.getPassword()))
                                .build();

        commentRepository.save(comment);
    }
}
