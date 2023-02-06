package com.human.seoulroad.review2;

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
public class reviewService4 {

    private final reviewRepository4 reviewRepository4;

    public Page<review4> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate4"));
        Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));
        return this.reviewRepository4.findAll(pageable);
    }
    public void create(String reviewStar4, String id4, String reviewContents4) {
        review4 r = new review4();
        r.setReviewStar4(reviewStar4);
        r.setId4(id4);
        r.setReviewContents4(reviewContents4);
        r.setCreateDate4(LocalDateTime.now());
        this.reviewRepository4.save(r);
    }
}