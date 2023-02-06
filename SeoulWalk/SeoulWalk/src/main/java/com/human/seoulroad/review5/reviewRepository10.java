package com.human.seoulroad.review5;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reviewRepository10 extends JpaRepository<review10, Integer> {
	Page<review10> findAll(Pageable pageable);
}

