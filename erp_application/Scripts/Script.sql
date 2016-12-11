insert into title values(1, '����'),(2, '����'),(3, '����'), (4,'�븮'),(5, '���');
select * from title;

update title set titlename = '���' where no=5;

INSERT INTO DEPARTMENT VALUES(1, '����', 8);
INSERT INTO DEPARTMENT VALUES(2, '��ȹ', 10);
INSERT INTO DEPARTMENT VALUES(3, '����', 9);
INSERT INTO DEPARTMENT VALUES(4, '�ѹ�', 7);

INSERT INTO EMPLOYEE VALUES(4377, '�̼���', 1, NULL, 5000000, 2);
INSERT INTO EMPLOYEE VALUES(3426, '�ڿ���', 3, 4377, 3000000, 1);
INSERT INTO EMPLOYEE VALUES(1003, '������', 3, 4377, 3000000, 2);
INSERT INTO EMPLOYEE VALUES(3011, '�̼���', 2, 4377, 4000000, 3);
INSERT INTO EMPLOYEE VALUES(1365, '����', 5, 3426 , 1500000,1);
INSERT INTO EMPLOYEE VALUES(2106, '��â��', 4, 1003, 2500000, 2),(3427, '����ö', 5, 3011, 1500000, 3);

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
�������ȣ-1 
�õ�-2	
-- �õ�����-3	
�ñ���-4	
-- �ñ�������-5	
����-6	
-- ���鿵��-7	
-- ���θ��ڵ�-8	
���θ�-9	
-- ���θ���-10	
-- ���Ͽ���-11	
�ǹ���ȣ����-12	
�ǹ���ȣ�ι�-13	
-- �ǹ�������ȣ-14	
-- �ٷ����ó��-15	
-- �ñ�����ǹ���-16	
-- �������ڵ�-17	
��������-18	
����-19	
��������-20	
-- �꿩��-21	
��������-22	
-- ���鵿�Ϸù�ȣ-23	
�����ι�-24	
-- �������ȣ-25	
-- �����ȣ�Ϸù�ȣ-26

������.txt
��⵵.txt
��󳲵�.txt
���ϵ�.txt
���ֱ�����.txt
�뱸������.txt
����������.txt
�λ걤����.txt
����Ư����.txt
����Ư����ġ��.txt
��걤����.txt
��õ������.txt
���󳲵�.txt
����ϵ�.txt
����Ư����ġ��.txt
��û����.txt
��û�ϵ�.txt

LOAD data LOCAL INFILE 'C:\\Users\\KimMinSu\\git\\erp\\erp\\DataFiles\\��û�ϵ�.txt' 
INTO table  post   character set 'euckr'  fields TERMINATED by '|' 
IGNORE 1 lines
(@zipcode, @sido, @d, @sigungu , @d, @eupmyun, @d,  @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @courtdong, @ri ,@admindong, @d, @zibun1, @d, @zibun2, @d, @d) 
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu ,eupmyun=@eupmyun, doro=@doro, building1=@building1, building2=@building2, courtdong=@courtdong, ri=@ri,admindong=@admindong, zibun1=@zibun1, zibun2=@zibun2;

select * from post where doro= '����';
select * from post where doro= '����' and building1=90;
drop index idx_post_doro on post;

create index idx_post_doro on post(doro, building1, building2);
create index idx_post_doro on post(doro);

select * from post where dong='�Ÿŵ�';
select * from post where dong='�Ÿŵ�' and zibun1=569;

drop index idx_post_dong on post;
create index idx_post_dong on post(dong);

