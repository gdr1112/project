package com.human.seoulroad.review3;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reviewRepository5 extends JpaRepository<review5, Integer> {
	Page<review5> findAll(Pageable pageable);
}

