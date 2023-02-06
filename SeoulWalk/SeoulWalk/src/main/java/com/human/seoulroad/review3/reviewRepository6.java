package com.human.seoulroad.review3;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reviewRepository6 extends JpaRepository<review6, Integer> {
	Page<review6> findAll(Pageable pageable);
}

