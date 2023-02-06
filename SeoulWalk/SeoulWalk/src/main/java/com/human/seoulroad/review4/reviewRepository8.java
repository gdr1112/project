package com.human.seoulroad.review4;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reviewRepository8 extends JpaRepository<review8, Integer> {
	Page<review8> findAll(Pageable pageable);
}

