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
public class reviewService11 {

    private final reviewRepository11 reviewRepository11;

    public Page<review11> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate11"));
    	Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));
        return this.reviewRepository11.findAll(pageable);
    }
    public void create(String reviewStar11, String id11, String reviewContents11) {
        review11 r = new review11();
        r.setReviewStar11(reviewStar11);
        r.setId11(id11);
        r.setReviewContents11(reviewContents11);
        r.setCreateDate11(LocalDateTime.now());
        this.reviewRepository11.save(r);
    }
   
}