package com.human.seoulroad.review5;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reviewRepository11 extends JpaRepository<review11, Integer> {
	Page<review11> findAll(Pageable pageable);
}

