package com.human.seoulroad.review2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reviewRepository4 extends JpaRepository<review4, Integer> {
	Page<review4> findAll(Pageable pageable);
}

