package com.skate.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skate.store.domain.BoardComment;

public interface BoardCommentRepository extends JpaRepository<BoardComment, Long>{

}
