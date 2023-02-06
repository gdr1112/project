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
public class reviewService7 {

    private final reviewRepository7 reviewRepository7;

    public Page<review7> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate7"));
    	Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));
        return this.reviewRepository7.findAll(pageable);
    }
    public void create(String reviewStar7, String id7, String reviewContents7) {
        review7 r = new review7();
        r.setReviewStar7(reviewStar7);
        r.setId7(id7);
        r.setReviewContents7(reviewContents7);
        r.setCreateDate7(LocalDateTime.now());
        this.reviewRepository7.save(r);
    }
   
}