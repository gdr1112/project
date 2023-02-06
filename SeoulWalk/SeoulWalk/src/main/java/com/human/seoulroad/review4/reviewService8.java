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
public class reviewService8 {

    private final reviewRepository8 reviewRepository8;

    public Page<review8> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate8"));
    	Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));
        return this.reviewRepository8.findAll(pageable);
    }
    public void create(String reviewStar8, String id8, String reviewContents8) {
        review8 r = new review8();
        r.setReviewStar8(reviewStar8);
        r.setId8(id8);
        r.setReviewContents8(reviewContents8);
        r.setCreateDate8(LocalDateTime.now());
        this.reviewRepository8.save(r);
    }
   
}