package com.human.seoulroad.review2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reviewRepository2 extends JpaRepository<review2, Integer> {
	Page<review2> findAll(Pageable pageable);
}

