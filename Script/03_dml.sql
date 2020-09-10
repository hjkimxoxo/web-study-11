SELECT * FROM MEMBER;
DELETE FROM MEMBER;
INSERT ALL 
	INTO MEMBER VALUES ('이소미', 'somi', '1234', 'gmd@naver.com', '010-2362-5157', 0, sysdate)
	INTO MEMBER VALUES ('하성오', 'sang12', '1234', 'ha12@naver.com', '010-5629-8888',1, sysdate)
	INTO MEMBER VALUES ('김윤승', 'light', '1234', 'youn1004@naver.com', '010-9999-8282',1, sysdate)
	SELECT 1 FROM dual; --조건이 참이면 넣는다
	
--user check
SELECT name, userid, pwd, email, phone, admin, joindate FROM MEMBER;

SELECT PWD FROM MEMBER WHERE USERID='SOMI';

SELECT name, userid, pwd, email, phone, admin, joindate FROM MEMBER
WHERE userid = 'somi' AND pwd = '1234';

SELECT * FROM product; 

insert into product values(null, '개념을 콕콕 잡아주는 데이터베이스', 27000, 'db.jpg', '데이터베이스에 관한 모든 것을 쉽고 재미있게 정리한 교재...');
insert into product values(null, '웹표준을 위한 HTML5', 25000, 'html5.jpg', 'HTML5 가이드북. 홈페이지 제작을 위한 필수 선택 HTML 기본 문법...');
insert into product values(null, 'Dynamic Programming book 시리즈-01 오라클 11g + PL/SQL', 25000, 'oracle.jpg','Dynamic 실무 코칭 프로그래밍 Book의 첫번째 책으로, 오라클 11g의 새로운 ...');
insert into product values(null, 'Visual C++ MFC 윈도우 프로그래밍', 26000, 'mfc.jpg', 'Visual C++를 처음 시작하는 독자의 눈높이에 맞춘 Visual C++...');
insert into product values(null, 'jQuery and jQuery Mobile : 이해하기 쉽게 풀어쓴', 25000, 'jquery.jpg', '소스 하나로 데스크탑과 모바일까지 HTML5와 함께 사용한다. 초보자들도 ...');

-- OR INSERT INTO product(NAME,PRICE,PICTUREURL,DESCRIPTION) VALUES 어쩌고 가능

