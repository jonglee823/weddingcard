package com.wedding.weddingcard.repository;

import com.wedding.weddingcard.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
