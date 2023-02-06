package com.human.seoulroad.review3;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reviewRepository7 extends JpaRepository<review7, Integer> {
	Page<review7> findAll(Pageable pageable);
}

