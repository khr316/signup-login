# 회원가입 및 로그인 코드 작성

[HTML CSS JavaScript 코드 참고 블로그](https://inpa.tistory.com/entry/CSS-%F0%9F%92%8D-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85-%ED%8E%98%EC%9D%B4%EC%A7%80-%EC%8A%A4%ED%83%80%EC%9D%BC-%F0%9F%96%8C%EF%B8%8F-%EB%AA%A8%EC%9D%8C)


### SQL user 테이블 
CREATE TABLE user (<br>
  id int AUTO_INCREMENT,<br>
  username varchar(30),<br>
  password varchar(20),<br>
  email varchar(50),<br>
  create_at timestamp DEFAULT CURRENT_TIMESTAMP,<br>
) ;

### 회원가입
1. user name
2. email
- 중복 체크
- 버튼 눌러야 가입 가능
- 테이블에 저장된 회원 정보와 비교하여
- 동일한 이메일 입력 시 가입 불가
3. password
- password / password check
- 두 입력값이 동일한 경우만 가입 가능
- 조건 : 특수문자 1개 이상, 알파벳 1개 이상, 12자 이상
 

### 로그인
1. email
2. password
- 테이블에 저장된 회원이면 로그인 성공
- 저장되어있지 않다면 로그인 페이지 머무르기 
- => 에러 메세지 출력
- 비밀번호 찾기
- 이름, 이메일 입력 시 이메일로 임시 비밀번호 발급

#### 상세내용 첨부
[티스토리](https://khr316.tistory.com/entry/%EC%97%AC%ED%96%89-%EA%B8%B0%EB%B0%98-%EC%9D%8C%EC%95%85-%ED%94%8C%EB%A0%88%EC%9D%B4%EB%A6%AC%EC%8A%A4%ED%8A%B8-%EC%9B%B9-%EA%B0%9C%EB%B0%9C)
