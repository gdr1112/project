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
public class reviewService6 {

    private final reviewRepository6 reviewRepository6;

    public Page<review6> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate6"));
    	Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));
        return this.reviewRepository6.findAll(pageable);
    }
    public void create(String reviewStar6, String id6, String reviewContents6) {
        review6 r = new review6();
        r.setReviewStar6(reviewStar6);
        r.setId6(id6);
        r.setReviewContents6(reviewContents6);
        r.setCreateDate6(LocalDateTime.now());
        this.reviewRepository6.save(r);
    }
   
}