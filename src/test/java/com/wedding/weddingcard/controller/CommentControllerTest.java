package com.wedding.weddingcard.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wedding.weddingcard.repository.CommentRepository;
import com.wedding.weddingcard.request.CommentRequest;
import com.wedding.weddingcard.service.CommentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ActiveProfiles(profiles = "local")
@SpringBootTest
class CommentControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

    //@BeforeEach
    void clean(){
        commentRepository.deleteAll();
    }

    @Test
    @DisplayName("/posts submit blank String title, contents")
    void test() throws Exception {

        //given
        CommentRequest request = CommentRequest.builder()
                .title("")
                .content("")
                .build();

        String requestJson = objectMapper.writeValueAsString(request);

        //when
        mockMvc.perform(post("/posts")
                        .contentType(APPLICATION_JSON)
                        .content(requestJson)
                )
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("잘못된 요청입니다."))
                .andDo(print());
    }

    @Test
    @DisplayName("/posts submit correct title, cotent, password")
    void correctPosts() throws Exception {

        //given
        CommentRequest request = CommentRequest.builder()
                .title("댓글제목")
                .content("댓글내용")
                .password("rhtjdrhd1004A!")
                .build();

        String requestJson = objectMapper.writeValueAsString(request);

        //when
        mockMvc.perform(post("/posts")
                        .contentType(APPLICATION_JSON)
                        .content(requestJson)
                )
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    @DisplayName("/posts submit incorrect password ")
    void incorrectPasswordPosts() throws Exception {

        //given
        CommentRequest request = CommentRequest.builder()
                .title("비밀번호 공백")
                .content("비밀번호 공백")
                .password("")
                .build();

        String requestJson = objectMapper.writeValueAsString(request);

        //when
        mockMvc.perform(post("/posts")
                        .contentType(APPLICATION_JSON)
                        .content(requestJson)
                )
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("잘못된 비밀번호 입니다."))
                .andDo(print());
    }

}