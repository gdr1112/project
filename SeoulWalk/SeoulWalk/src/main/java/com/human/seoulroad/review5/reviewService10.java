package com.human.seoulroad.review5;

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
public class reviewService10 {

    private final reviewRepository10 reviewRepository10;

    public Page<review10> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate10"));
    	Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));
        return this.reviewRepository10.findAll(pageable);
    }
    public void create(String reviewStar10, String id10, String reviewContents10) {
        review10 r = new review10();
        r.setReviewStar10(reviewStar10);
        r.setId10(id10);
        r.setReviewContents10(reviewContents10);
        r.setCreateDate10(LocalDateTime.now());
        this.reviewRepository10.save(r);
    }
   
}