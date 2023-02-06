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
public class reviewService3 {

    private final reviewRepository3 reviewRepository3;

    public Page<review3> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate3"));
        Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));
        return this.reviewRepository3.findAll(pageable);
    }
    public void create(String reviewStar3, String id3, String reviewContents3) {
        review3 r = new review3();
        r.setReviewStar3(reviewStar3);
        r.setId3(id3);
        r.setReviewContents3(reviewContents3);
        r.setCreateDate3(LocalDateTime.now());
        this.reviewRepository3.save(r);
    }
}