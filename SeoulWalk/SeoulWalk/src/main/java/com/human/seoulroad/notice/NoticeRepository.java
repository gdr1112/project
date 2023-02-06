package com.human.seoulroad.notice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface NoticeRepository extends JpaRepository<Notice, Integer>{
	
	Notice findBySubject(String subject);
	Notice findBySubjectAndContent(String subject, String content);
	List<Notice> findBySubjectLike(String subject);
	
    // 검색쿼리
    @Query("select "
            + "distinct q "
            + "from Notice q " 
            + "left outer join SiteUser u1 on q.author=u1 "
            + "where "
            + "   q.subject like %:kw% "
            + "   or q.content like %:kw% "
            + "   or u1.nickname like %:kw% ")
    Page<Notice> findAllByKeyword(@Param("kw") String kw, Pageable pageable); 

}
