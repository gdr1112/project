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
public class reviewService2 {

    private final reviewRepository2 reviewRepository2;

    public Page<review2> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate2"));
    	Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));
        return this.reviewRepository2.findAll(pageable);
    }
    public void create(String reviewStar2, String id2, String reviewContents2) {
        review2 r = new review2();
        r.setReviewStar2(reviewStar2);
        r.setId2(id2);
        r.setReviewContents2(reviewContents2);
        r.setCreateDate2(LocalDateTime.now());
        this.reviewRepository2.save(r);
    }
   
}