package com.human.seoulroad.review4;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class reviewService9 {

    private final reviewRepository9 reviewRepository9;

    public Page<review9> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate9"));
    	Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));
        return this.reviewRepository9.findAll(pageable);
    }
    public void create(String reviewStar9, String id9, String reviewContents9) {
        review9 r = new review9();
        r.setReviewStar9(reviewStar9);
        r.setId9(id9);
        r.setReviewContents9(reviewContents9);
        r.setCreateDate9(LocalDateTime.now());
        this.reviewRepository9.save(r);
    }
   
}