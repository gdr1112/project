package com.human.seoulroad.review2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reviewRepository3 extends JpaRepository<review3, Integer> {
	Page<review3> findAll(Pageable pageable);
}

