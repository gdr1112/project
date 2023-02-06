# Final Project - Seoul Walk
SpringBoot + html + thymeleaf + MySQL : 서울 둘레길 코스 정보/추천 사이트
<br/><br/>

## 🖥️ 프로젝트 소개
**서울 둘레길 코스 정보/추천 사이트 : Seoul Walk**입니다. 

<br/>

<a href="https://seoulwalk.kro.kr">사이트 링크</a>

<br/>

## 🕰️ 개발 기간
22.12.16 - 23.01.27 ( 6주 )
<br/><br/>

## 🧑‍🤝‍🧑 맴버구성
 - 팀원1 : 임여명
 - 팀원2 : 임한용
 - 팀원3 : 한유경
 - 팀원4 : 황지훈
<br/><br/>

## ⚙️ 개발 환경
- `Java 17`
- **IDE** : STS 4.16.1
- **Framework** : Springboot(3.0.1)
- **Database** : MySQL(8.0.31)
- **ORM** : JPA
- **Build** : Gradle(7.6)
<br/>

## 📌 주요 기능

### 메인 화면

<details>
<summary>메인화면 img</summary>
<div markdown="1">

<img src="https://user-images.githubusercontent.com/82715109/216530432-cbaa15fc-6cc6-4486-bcd8-73478863bdb6.png" width="1200" height="1000" />

</div>
</details>

<details>
<summary>메인화면 모바일 img</summary>
<div markdown="1">

<img src="https://user-images.githubusercontent.com/82715109/216531118-316d45a2-1336-4e04-8242-0b46b48204a3.png" />

</div>
</details>

<br>

### 둘레길 코스 - <a href="https://github.com/rkgh17/SeoulWalk/wiki/%EB%91%98%EB%A0%88%EA%B8%B8-%EC%BD%94%EC%8A%A4#-%EB%91%98%EB%A0%88%EA%B8%B8-%EC%BD%94%EC%8A%A4" >상세보기 - WIKI 이동</a>
- 코스 시각화 : 네이버 지도 api를 통해 지도 표시, DB(경도, 위도) - Controller - Javascript 를 통해 경로 시각화

<br>

### 둘레길 추천 코스 - <a href="https://github.com/rkgh17/SeoulWalk/wiki/%EB%91%98%EB%A0%88%EA%B8%B8-%EC%B6%94%EC%B2%9C-%EC%BD%94%EC%8A%A4" >상세보기 - WIKI 이동</a>
- 코스 리뷰 : 각 코스별 리뷰 게시판 구현, Ajax를 사용한 비동기 페이징 구현

<br>

### 둘레길 유형 테스트 - <a href="https://github.com/rkgh17/SeoulWalk/wiki/%EB%91%98%EB%A0%88%EA%B8%B8-%EC%9C%A0%ED%98%95-%ED%85%8C%EC%8A%A4%ED%8A%B8" >상세보기 - WIKI 이동</a>
- 유형 테스트 : 8가지 질문을 통해 코스 추천
- sns 공유 : 테스트와 테스트 결과를 sns로 공유

<br>

### 그밖의 길 - <a href="https://github.com/rkgh17/SeoulWalk/wiki/%EA%B7%B8%EB%B0%96%EC%9D%98-%EA%B8%B8" >상세보기 - WIKI 이동</a>
- 그밖의 길 : JPA를 활용하여 지역/코스길이/시간/난이도별 산책로 목록 검색

<br>

### 소셜 로그인 - <a href="https://github.com/rkgh17/SeoulWalk/wiki/%EC%86%8C%EC%85%9C-%EB%A1%9C%EA%B7%B8%EC%9D%B8" >상세보기 - WIKI 이동</a>
- 소셜 로그인  :  OAUTH2.0 라이브러리 사용, 로그인 시 세션(Session) 생성
- 접근 제한 : 세션값을 검증하여 로그인 페이지로 이동, 로그인 시 이전 페이지로 이동

<br>

### 커뮤니티 - <a href="https://github.com/rkgh17/SeoulWalk/wiki/%EC%BB%A4%EB%AE%A4%EB%8B%88%ED%8B%B0" >상세보기 - WIKI 이동</a> 
- 공지사항 : 관리자 계정만 사용 가능하도록 접근 제한
- 커뮤니티 : CRUD기능, 추천, JPA를 활용한 게시글 페이징과 검색
