package com.human.seoulroad.review4;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reviewRepository9 extends JpaRepository<review9, Integer> {
	Page<review9> findAll(Pageable pageable);
}

