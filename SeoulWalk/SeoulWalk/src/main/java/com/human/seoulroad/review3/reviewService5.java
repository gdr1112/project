package com.human.seoulroad.review3;

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
public class reviewService5 {

    private final reviewRepository5 reviewRepository5;

    public Page<review5> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate5"));
    	Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));
        return this.reviewRepository5.findAll(pageable);
    }
    public void create(String reviewStar5, String id5, String reviewContents5) {
        review5 r = new review5();
        r.setReviewStar5(reviewStar5);
        r.setId5(id5);
        r.setReviewContents5(reviewContents5);
        r.setCreateDate5(LocalDateTime.now());
        this.reviewRepository5.save(r);
    }
   
}