insert into title values(1, '사장'),(2, '부장'),(3, '과장'), (4,'대리'),(5, '사원');
select * from title;

update title set titlename = '사원' where no=5;

INSERT INTO DEPARTMENT VALUES(1, '영업', 8);
INSERT INTO DEPARTMENT VALUES(2, '기획', 10);
INSERT INTO DEPARTMENT VALUES(3, '개발', 9);
INSERT INTO DEPARTMENT VALUES(4, '총무', 7);

INSERT INTO EMPLOYEE VALUES(4377, '이성래', 1, NULL, 5000000, 2);
INSERT INTO EMPLOYEE VALUES(3426, '박영권', 3, 4377, 3000000, 1);
INSERT INTO EMPLOYEE VALUES(1003, '조민희', 3, 4377, 3000000, 2);
INSERT INTO EMPLOYEE VALUES(3011, '이수민', 2, 4377, 4000000, 3);
INSERT INTO EMPLOYEE VALUES(1365, '김상원', 5, 3426 , 1500000,1);
INSERT INTO EMPLOYEE VALUES(2106, '김창섭', 4, 1003, 2500000, 2),(3427, '최종철', 5, 3011, 1500000, 3);

select * from title;
select * from department;
select * from employee;

select empno, empname, t.titlename, manager, salary, d.deptname from employee e join department d on e.dno=d.deptno join title t on e.title=t.no;

select * from employee where title in (1,2,3);


create table post(
	zipcode char(5),
	sido	varchar(20),
	sigungu	varchar(20),
	eupmyun varchar(20),
	doro	varchar(80),
	building1	char(5),
	building2	char(5),
	courtdong	varchar(20),
	ri	varchar(20),
	admindong	varchar(20),
	zibun1	varchar(4),
	zibun2	varchar(4)
);

-- post
새우편번호-1 
시도-2	
-- 시도영문-3	
시군구-4	
-- 시군구영문-5	
읍면-6	
-- 읍면영문-7	
-- 도로명코드-8	
도로명-9	
-- 도로명영문-10	
-- 지하여부-11	
건물번호본번-12	
건물번호부번-13	
-- 건물관리번호-14	
-- 다량배달처명-15	
-- 시군구용건물명-16	
-- 법정동코드-17	
법정동명-18	
리명-19	
행정동명-20	
-- 산여부-21	
지번본번-22	
-- 읍면동일련번호-23	
지번부번-24	
-- 구우편번호-25	
-- 우편번호일련번호-26

강원도.txt
경기도.txt
경상남도.txt
경상북도.txt
광주광역시.txt
대구광역시.txt
대전광역시.txt
부산광역시.txt
서울특별시.txt
세종특별자치시.txt
울산광역시.txt
인천광역시.txt
전라남도.txt
전라북도.txt
제주특별자치도.txt
충청남도.txt
충청북도.txt

LOAD data LOCAL INFILE 'C:\\Users\\KimMinSu\\git\\erp\\erp\\DataFiles\\충청북도.txt' 
INTO table  post   character set 'euckr'  fields TERMINATED by '|' 
IGNORE 1 lines
(@zipcode, @sido, @d, @sigungu , @d, @eupmyun, @d,  @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @courtdong, @ri ,@admindong, @d, @zibun1, @d, @zibun2, @d, @d) 
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu ,eupmyun=@eupmyun, doro=@doro, building1=@building1, building2=@building2, courtdong=@courtdong, ri=@ri,admindong=@admindong, zibun1=@zibun1, zibun2=@zibun2;

select * from post where doro= '고산로';
select * from post where doro= '고산로' and building1=90;
drop index idx_post_doro on post;

create index idx_post_doro on post(doro, building1, building2);
create index idx_post_doro on post(doro);

select * from post where dong='신매동';
select * from post where dong='신매동' and zibun1=569;

drop index idx_post_dong on post;
create index idx_post_dong on post(dong);

