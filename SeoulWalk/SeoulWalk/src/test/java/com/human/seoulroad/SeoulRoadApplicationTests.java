package com.human.seoulroad;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.human.seoulroad.question.Question;
import com.human.seoulroad.question.QuestionRepository;

@SpringBootTest
class SeoulRoadApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;
	
	@Test
	void testJpa(){
        Question q1 = new Question();
        q1.setSubject("둘레길이 무엇인가요?");
        q1.setContent("둘레길에 대해서 알고 싶습니다.");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);  // 첫번째 질문 저장

        Question q2 = new Question();
        q2.setSubject("둘레길 질문입니다.");
        q2.setContent("1번 코스는 얼마나 걸리나요?");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);  // 두번째 질문 저장
	}

}
