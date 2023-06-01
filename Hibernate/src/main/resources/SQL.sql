-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

ALTER SESSION SET CURRENT_SCHEMA = V705417;

ALTER USER V705417 ACCOUNT UNLOCK;

DROP TABLE "BIN$1WYmf+KIQKClSCKi39nYJQ==$0";

CREATE TABLE DEPARTMENT
(
   DEPT_ID            NUMBER(18,0) PRIMARY KEY,
   DEPT_NAME          VARCHAR2(30) NOT NULL,
   DEPT_LOC           VARCHAR2(30) NOT NULL
);

INSERT INTO DEPARTMENT VALUES (1 ,'INV','Phase-1');
INSERT INTO DEPARTMENT VALUES (2 ,'WSH','Phase-1');
INSERT INTO DEPARTMENT VALUES (3 ,'RCV','Phase-1');
INSERT INTO DEPARTMENT VALUES (4 ,'MFG','Phase-2');
INSERT INTO DEPARTMENT VALUES (5 ,'PRC','Phase-2');
INSERT INTO DEPARTMENT VALUES (6 ,'CST','Phase-3');
INSERT INTO DEPARTMENT VALUES (7 ,'REL','Phase-3');
INSERT INTO DEPARTMENT VALUES (8 ,'DOO','Phase-4');
INSERT INTO DEPARTMENT VALUES (9 ,'VET','Bangalore');
INSERT INTO DEPARTMENT VALUES (10 ,'Redwing','Mumbai');

CREATE TABLE EMPLOYEE
(
    EMP_ID             NUMBER(18,0) PRIMARY KEY
  , EMP_NAME           VARCHAR2(30)
  , SALARY             NUMBER(10,2)
  , ADDRESS            VARCHAR2(50)
  , DOJ                DATE
  , DOB                DATE
  , DESIGNATION        VARCHAR2(50)
  , MGR_ID             NUMBER(18,0)
  , DEPT_ID            NUMBER(18,0) REFERENCES DEPARTMENT
  , GENDER             VARCHAR2(1)
);

CREATE SEQUENCE EMP_ID_SEQ START WITH 1 INCREMENT BY 1;

INSERT INTO EMPLOYEE VALUES(1 ,'Abhinaw_Bhagat' , 70000 ,'Lingampally' ,'01-JUL-2013' ,'03-MAY-1988' ,'Senior Application Engineer' , 7 , 1 ,'M');

INSERT INTO EMPLOYEE VALUES(2 ,'Suresh' , 50000 ,'Kondapur' ,'03-Jul-2014' ,'01-JAN-1989' ,'Application Engineer' , 7 , 1 ,'M');

INSERT INTO EMPLOYEE VALUES(3 ,'Aarti' , 55000 ,'Noida' ,'01-JAN-1991' ,'24-MAR-2014' ,'Senior Application Engineer' , 7 , 1 ,'F');

INSERT INTO EMPLOYEE VALUES(4 ,'Naseer' , 90000 ,'Madinaguda' ,'01-JAN-1972' ,'02-FEB-2008' ,'Release' , 9 , 7 ,'M');

INSERT INTO EMPLOYEE VALUES(5 ,'Manish' , 90000 ,'Kondapur' ,'01-JAN-1990' ,'02-FEB-2013' ,'Release' , 4 , 7 ,'M');

INSERT INTO EMPLOYEE VALUES(6 ,'Kush' , 60000 ,'Miyapur' ,'01-JAN-1989' ,'10-JUN-2013' ,'Receiving' , 3 ,'1' ,'M');

INSERT INTO EMPLOYEE VALUES(7 ,'Govind' , 100000 ,'Chandanagar' ,'01-JAN-1972' ,'02-FEB-2002' ,'Manager' , 9 , 7 ,'M');

INSERT INTO EMPLOYEE VALUES(8 ,'Saket' , 100000 ,'Lingampally' ,'01-JAN-1972' ,'02-FEB-2008' ,'Project Lead' , 9 , 7 ,'M');

INSERT INTO EMPLOYEE VALUES(10 ,'Rajitha' , 100000 ,'Lingampally' ,'01-JAN-1972' ,'02-FEB-2008' ,'Project Lead' , 9 , NULL ,'F');

INSERT INTO EMPLOYEE VALUES(11 ,'Phani' , 100000 ,'Lingampally' ,'01-JAN-1972' ,'02-FEB-2008' ,'Project Lead' , 9 , NULL ,'F');

ALTER TABLE EMPLOYEE ADD PHONE_NUMBER VARCHAR2(15);

CREATE TABLE SALARY
(
    LEVEL_NO INTEGER PRIMARY KEY,
    MIN_SAL  INTEGER NOT NULL,
    MAX_SAL  INTEGER NOT NULL
);

INSERT INTO SALARY VALUES(1, 10000, 50000);

INSERT INTO SALARY VALUES(2, 50001, 60000);

INSERT INTO SALARY VALUES(3, 60001, 70000);

INSERT INTO SALARY VALUES(4, 70001, 80000);

INSERT INTO SALARY VALUES(5, 80001, 90000);

INSERT INTO SALARY VALUES(6, 90001, 99000);

SELECT * FROM EMPLOYEE;

SELECT * FROM SALARY;

SELECT * FROM DEPARTMENT;

-- EQUI JOIN
SELECT E.EMP_NAME, E.ADDRESS, E.DOB,
       D.DEPT_NAME, D.DEPT_LOC
FROM   EMPLOYEE E, DEPARTMENT D
WHERE  E.DEPT_ID = D.DEPT_ID;

SELECT E.EMP_NAME, E.ADDRESS, E.DOB,
       D.DEPT_NAME,D.DEPT_LOC
FROM   EMPLOYEE E  INNER JOIN  DEPARTMENT D
ON     E.DEPT_ID = D.DEPT_ID;

-- NON EQUI JOIN
SELECT E.EMP_ID, E.EMP_NAME, E.SALARY,
       S.LEVEL_NO
FROM   EMPLOYEE E, SALARY S
WHERE E.SALARY BETWEEN S.MIN_SAL AND S.MAX_SAL;

-- LEFT OUTER JOIN
SELECT E.EMP_NAME,E.SALARY,D.DEPT_NAME,D.DEPT_LOC
FROM
EMPLOYEE E , DEPARTMENT D
WHERE
E.DEPT_ID = D.DEPT_ID(+);

SELECT E.EMP_NAME, E.SALARY, D.DEPT_NAME, D.DEPT_LOC
FROM   EMPLOYEE E  LEFT OUTER JOIN  DEPARTMENT D  ON
E.DEPT_ID = D.DEPT_ID;

-- RIGHT OUTER JOIN
SELECT E.EMP_NAME
     , E.SALARY
     , D.DEPT_NAME
     , D.DEPT_ID
     , D.DEPT_LOC
FROM   EMPLOYEE   E
     , DEPARTMENT D
WHERE E.DEPT_ID(+)= D.DEPT_ID;

SELECT E.EMP_NAME,E.SALARY,
       D.DEPT_NAME,D.DEPT_ID,D.DEPT_LOC
FROM EMPLOYEE E RIGHT OUTER JOIN DEPARTMENT D
ON E.DEPT_ID = D.DEPT_ID;

-- FULL OUTER JOIN
SELECT E.*,D.*
FROM
    EMPLOYEE E FULL OUTER JOIN DEPARTMENT D
ON E.dept_id = D.dept_id;

SELECT E.*, D.*
FROM EMPLOYEE   E, DEPARTMENT D
WHERE E.DEPT_ID = D.DEPT_ID;


--CROSS JOIN

SELECT E1.EMP_NAME AS EMP1
     , E2.EMP_NAME AS EMP2
     , ABS(E1.SALARY - E2.SALARY) AS SALARY_DIFF
FROM EMPLOYEE E1 CROSS JOIN EMPLOYEE E2
WHERE E1.SALARY < E2.SALARY
AND ROWNUM <=1 ORDER BY 3,1,2;


SELECT GENDER, LISTAGG(EMP_NAME, ',') WITHIN GROUP (ORDER BY EMP_NAME) "Names"
FROM   EMPLOYEE
GROUP BY GENDER;

SELECT COUNT(GENDER), GENDER FROM EMPLOYEE GROUP BY GENDER;

--Find all Employee records containing the word "Joe", regardless of whether it was stored as JOE, Joe, or joe.
SELECT * FROM EMPLOYEE WHERE UPPER(EMP_NAME) LIKE '%JOE%';

--You have a composite index of three columns, and you only provide the value of two columns in
--WHERE clause of a select query? Will Index be used for this operation? For example if Index is
--on EmpId, EmpFirstName, and EmpSecondName and you write query like
--SELECT * FROM Employee WHERE EmpId=2 and EmpFirstName='Radhe'
--If the given two columns are secondary index column then the index will not invoke,
--but if the given 2 columns contain the primary index(first column while creating index)
--then the index will invoke. In this case, Index will be used because EmpId and EmpFirstName are primary columns.
-- Query to check whether date passed to Query is the date of given format or not.
--SELECT  ISDATE('1/08/13') AS "MM/DD/YY" FROM DUAL;

-- DISPLAY THE CURRENT USER
SHOW USER;

SET SQLPROMPT 'XE';
-- TO SWITCH TO DOS PROMPT 'HOST';
HOST;

-- DISPLAY THE RECORDS BETWEEN 2 RANGES
SELECT * FROM EMPLOYEE WHERE ROWID IN(SELECT ROWID FROM EMPLOYEE WHERE ROWNUM <= &UPTO MINUS SELECT ROWID FROM EMPLOYEE WHERE ROWNUM < &FRM);

--DISPLAY NTH HIGHEST SALARY
SELECT * FROM EMPLOYEE E1 WHERE &N = SELECT COUNT(DISTINCT(E2.SALARY)) FROM EMPLOYEE E2 WHERE E1.SALARY <= E2.SALARY;

--DISPLAY ODD NUMBER OF RECORDS
SELECT * FROM EMPLOYEE WHERE(ROWID,1) IN(SELECT ROWID,MOD(ROWNUM,2) FROM EMPLOYEE);

--DISPLAY EVEN NUMBER OF RECORDS
SELECT * FROM EMPLOYEE WHERE(ROWID,0) IN(SELECT ROWID,MOD(ROWNUM,2) FROM EMPLOYEE);

-- DISPLAY THE NAMES OF ALL THE EMPLOYEE WHO ARE REPORTING TO THEIR RESPECTIVE MANAGERS
SELECT LPAD(E1.EMP_NAME,15,'*') ||' -> ' || RPAD(E2.EMP_NAME,10,'#')
FROM
EMPLOYEE E1 , EMPLOYEE E2
WHERE
E1.MGR_ID = E2.EMP_ID;

< ANY -> LESS THAN THE MAX VALUE
> ANY -> MORE THAN THE MIN VALUE
< ALL -> LESS THAN THE MIN VALUE
> ALL -> MORE THAN THE MAX VALUE

SELECT EMP_NAME, SALARY FROM EMPLOYEE WHERE SALARY < ANY(90000,50000);

SELECT EMP_NAME, SALARY FROM EMPLOYEE WHERE SALARY < ALL(90000,60000);

-- DISPLAY THE EMPLOYEE DETAILS GETTING MAXIMUM SALARY WITHOUT USING MAX FUNCTION
SELECT * FROM EMPLOYEE WHERE SALARY NOT IN(SELECT SALARY FROM EMPLOYEE WHERE SALARY < ANY(SELECT SALARY FROM EMPLOYEE));

-- OR BELOW QUERY ALSO WORKS
SELECT * FROM EMPLOYEE WHERE SALARY > ALL(SELECT SALARY FROM  EMPLOYEE WHERE SALARY < ANY(SELECT SALARY  FROM EMPLOYEE));

-- DISPLAY THE EMPLOYEE DETAILS GETTING MAXIMUM SALARY USING MAX FUNCTION
SELECT * FROM EMPLOYEE WHERE SALARY IN(SELECT MAX(SALARY) FROM EMPLOYEE);

-- DISPLAY THE EMPLOYEE DETAILS GETTING MINIMUM SALARY WITHOUT USING MIN FUNCTION
SELECT * FROM EMPLOYEE WHERE SALARY NOT IN(SELECT SALARY FROM EMPLOYEE WHERE SALARY > ANY (SELECT SALARY FROM EMPLOYEE));

--OR BELOW QUERY ALSO WORKS
SELECT * FROM EMPLOYEE WHERE SALARY < ALL(SELECT SALARY FROM EMPLOYEE WHERE SALARY > ANY (SELECT SALARY FROM EMPLOYEE));

--DISPLAY SECOND HIGHEST SALARY
SELECT MAX(SALARY) FROM EMPLOYEE WHERE SALARY NOT IN(SELECT MAX(SALARY) FROM EMPLOYEE);

SELECT MAX(SALARY) FROM EMPLOYEE WHERE SALARY IN(SELECT SALARY FROM EMPLOYEE WHERE SALARY < ANY (SELECT SALARY FROM  EMPLOYEE));

--DISPLAY THE EMPLOYEE DETAILS GETTING MINIMUM SALARY USING MIN FUNCTION
SELECT * FROM EMPLOYEE WHERE SALARY IN(SELECT MIN(SALARY) FROM  EMPLOYEE);

CREATE TABLE EMP (ID INTEGER , NAME VARCHAR2(10));

INSERT INTO EMP VALUES(1 ,'john@example.com');

INSERT INTO EMP VALUES(2 ,'bob@example.com');

INSERT INTO EMP VALUES(3 ,'john@example.com');

SELECT * FROM EMP;

DELETE FROM EMP WHERE ROWID NOT IN(SELECT MAX(ROWID) FROM EMP GROUP BY ID);

--DELETE ALL THE DUPLICATE RECORDS FROM THE EMPLOYEE TABLE
DELETE FROM EMPLOYEE WHERE ROWID NOT IN(SELECT MAX(ROWID) FROM EMPLOYEE  GROUP BY EMP_ID);

DELETE FROM EMPLOYEE A WHERE ROWID <(SELECT MIN(ROWID) FROM EMPLOYEE B WHERE A.ENAME = B.ENAME);

--DISPLAY ALL THE UNIQUE RECORDS FROM THE TABLE
SELECT DISTINCT * FROM EMPLOYEE;

--DISPLAY ALL THE UNIQUE RECORDS FROM THE TABLE WITHOUT USING DISTINCT
SELECT * FROM EMPLOYEE WHERE ROWID IN(SELECT MAX(ROWID) FROM EMPLOYEE GROUP BY EMP_ID);

-- DISPLAY ROWNUM AND ROWID ALONG WITH ALL THE COLUMNS OF THE TABLE

SELECT ROWNUM,ROWID,E.* FROM EMPLOYEE E;

-- DISPLAY ALL THE DUPLICATE RECORDS FROM THE DATABASE TABLE EMPLOYEE
SELECT * FROM EMPLOYEE WHERE ROWID NOT IN(SELECT MAX(ROWID) FROM EMPLOYEE GROUP BY EMP_ID);

--DISPLAY THE RECORDS WHOSE NAME CONTAINS '_'
SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE '%/_%' ESCAPE'/';

--DISPLAY EMPLOYEE WHOSE HAVE N+ YEARS EXPERIENCE
SELECT * FROM EMPLOYEE WHERE DOJ<=(SYSDATE-(365*&N));

SELECT * FROM EMPLOYEE WHERE((SYSDATE-DOJ)/365)>=&N;

SELECT * FROM EMPLOYEE WHERE MONTHS_BETWEEN(SYSDATE,DOJ)/12 >= &N;

SELECT * FROM EMPLOYEE WHERE &N <= (SYSDATE-DOJ)/365;

--DISPLAY EMPLOYEE WHOSE JOINED ORGANIZATION IN THE LAST 26 MONTHS
SELECT * FROM EMPLOYEE WHERE DOJ>=(SYSDATE-30*26);

SELECT * FROM EMPLOYEE WHERE MONTHS_BETWEEN(SYSDATE,DOJ) <=26;

SELECT * FROM EMPLOYEE WHERE(SYSDATE-DOJ)/30 <=16;

SELECT * FROM EMPLOYEE WHERE SYSDATE-DOJ <= 30*16;

--DISPLAY THE TOTAL NO OF EACH EMPLOYEE WITH DIFFERENT DESIGNATION
SELECT  DESIGNATION, COUNT(DESIGNATION) FROM  EMPLOYEE GROUP BY  DESIGNATION;

--DISPLAY THE NUMBER OF EMPLOYEES WORKING IN EACH DEPARTMENT
SELECT  DEPT_ID, COUNT(DEPT_ID)"Count" FROM  EMPLOYEE GROUP BY  DEPT_ID;

SELECT  D.DEPT_NAME, COUNT(D.DEPT_NAME)"Count" FROM  EMPLOYEE   E, DEPARTMENT D
WHERE  E.DEPT_ID = D.DEPT_ID
GROUP BY  D.DEPT_NAME;

SELECT  D.DEPT_NAME, MAX(E.SALARY)"Salary" FROM  EMPLOYEE E, DEPARTMENT D
WHERE  E.DEPT_ID = D.DEPT_ID
GROUP BY  D.DEPT_NAME;

SELECT  D.DEPT_NAME"Department",E.EMP_NAME"Employee", MAX(E.SALARY)"Salary" FROM  EMPLOYEE E, DEPARTMENT D
WHERE  E.DEPT_ID = D.DEPT_ID
GROUP BY  D.DEPT_NAME,E.EMP_NAME,E.SALARY
HAVING E.SALARY IN(SELECT MAX(E1.SALARY) FROM EMPLOYEE E1 GROUP BY E1.DEPT_ID);

--DISPLAY THE NUMBER OF EMPLOYEES WORKING IN A PARTICULAR DEPARTMENT eg 'INV'
SELECT  D.DEPT_NAME, COUNT(D.DEPT_NAME)"Count" FROM  EMPLOYEE E, DEPARTMENT D
WHERE  E.DEPT_ID = D.DEPT_ID
GROUP BY  D.DEPT_NAME
HAVING  D.DEPT_NAME = 'VET';

SELECT COUNT(*) FROM EMPLOYEE WHERE DEPT_ID =(SELECT DEPT_ID FROM DEPARTMENT WHERE DEPT_NAME = 'VET');

SELECT  DEPT_ID, COUNT(DEPT_ID)"Count" FROM  EMPLOYEE
GROUP BY  DEPT_ID
HAVING  DEPT_ID =  (SELECT DEPT_ID FROM DEPARTMENT WHERE DEPT_NAME = 'VET');

--DISPLAY THE EMPLOYEE DETAILS WHOSE NAME SECOND LETTER IS 'b'
SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE '_b%';

********DISPLAY THE NAME OF EMPLOYEE WHO ARE WORKING UNDER THE MANAGER 'Govind'********
SELECT * FROM EMPLOYEE WHERE MGR_ID =(SELECT EMP_ID FROM EMPLOYEE WHERE EMP_NAME = 'Govind');

SELECT E1.EMP_NAME
FROM EMPLOYEE E1, EMPLOYEE E2
WHERE
E1.MGR_ID = E2.EMP_ID
AND E2.EMP_NAME='Govind';

-- DISPLAY ALL EMPLOYEE WHO ARE NOT MANAGERS

SELECT * FROM EMPLOYEE WHERE EMP_ID NOT IN(SELECT DISTINCT(MGR_ID) FROM EMPLOYEE);

********DISPLAY THE NAME OF EMPLOYEE WHO ARE WORKING UNDER THE MANAGER &MGR ********
SELECT * FROM EMPLOYEE WHERE MGR_ID =(SELECT EMP_ID FROM EMPLOYEE WHERE EMP_NAME='&MGR');

SELECT E1.EMP_NAME FROM EMPLOYEE E1, EMPLOYEE E2 WHERE E1.MGR_ID = E2.EMP_ID AND E2.EMP_NAME='&MGR';

********DISPLAY THE NUMBER OF EMPLOYEE WHO ARE WORKING UNDER THE MANAGER &MGR ********
SELECT COUNT(*) FROM EMPLOYEE
WHERE
MGR_ID=(SELECT EMP_ID FROM EMPLOYEE WHERE EMP_NAME='&MGR');

--DISPLAY THE TOTAL SALARY OF ALL EMPLOYEES OR TOTAL COST UNDER THE MANAGER Govind
SELECT SUM(SALARY) FROM EMPLOYEE WHERE EMP_NAME ='Govind' OR MGR_ID IN (SELECT EMP_ID FROM EMPLOYEE WHERE EMP_NAME='Govind');

--DISPLAY THE TOTAL SALARY OF ALL EMPLOYEES OR TOTAL COST UNDER Each Manager
SELECT  SUM(E1.SALARY), E1.MGR_ID FROM  EMPLOYEE E1, EMPLOYEE E2
WHERE  E1.MGR_ID = E2.EMP_ID
GROUP BY  E1.MGR_ID;

--DISPLAY THE TOTAL NUMBER OF EMPLOYEE WORKING UNDER RESPECTIVE MANAGER
SELECT  MGR_ID, COUNT(MGR_ID) FROM  EMPLOYEE GROUP BY  MGR_ID;

SELECT  E2.EMP_NAME, COUNT(E2.EMP_NAME)
FROM  EMPLOYEE E1, EMPLOYEE E2
WHERE  E1.MGR_ID = E2.EMP_ID
GROUP BY  E2.EMP_NAME;

--DISPLAY THE TOTAL NUMBER OF EMPLOYEE WORKING UNDER MANAGER 'Atmadeep'
SELECT  MGR_ID, COUNT(MGR_ID) FROM  EMPLOYEE GROUP BY MGR_ID HAVING  MGR_ID = (SELECT MGR_ID FROM EMPLOYEE WHERE EMP_NAME = 'Naseer');

SELECT COUNT(*) FROM EMPLOYEE WHERE MGR_ID =(SELECT EMP_ID FROM EMPLOYEE WHERE EMP_NAME = 'Naseer');

--DISPLAY THE EMPLOYEE DETAILS WHO ARE ALSO MANAGERS
SELECT * FROM EMPLOYEE WHERE EMP_ID IN(SELECT DISTINCT(MGR_ID) FROM EMPLOYEE);
SELECT E1.* FROM EMPLOYEE E1, EMPLOYEE E2 WHERE E1.EMP_ID = E2.MGR_ID;

--DISPLAY ALL THE EMPLOYEE WHOSE SALARY ARE GREATER THAN THE AVERAGE SALARY
SELECT * FROM EMPLOYEE WHERE SALARY>(SELECT AVG(SALARY) FROM EMPLOYEE);

--SQL QUERY TO FIND YEAR FROM A DATE
SELECT SYSDATE FROM DUAL;

SELECT CURRENT_DATE FROM DUAL;

SELECT SUBSTR(TO_CHAR(SYSDATE,'DD-MON-YYYY'),8,4)"YEAR" FROM DUAL;

SELECT TO_CHAR(SYSDATE,'DD-MM-YYYY,HH-MI-SS:AM')"SYSDATE" FROM DUAL;

SELECT TO_CHAR(SYSDATE,'DD-MON-YYYY,HH-MI-SS:AM')"Current Date and Time" FROM DUAL;

SELECT TO_CHAR(CURRENT_DATE,'DD-MON-YYYY,HH-MI-SS:AM')"Current Date and Time" FROM DUAL;

SELECT SALARY, TO_CHAR(TO_DATE(SALARY,'J'),'JSP') FROM EMPLOYEE;

ALTER TABLE EMPLOYEE MODIFY MARKS NUMBER(5);

DROP TABLE B;

CREATE TABLE B(EMP_ID NUMBER PRIMARY KEY, EMP_NAME VARCHAR2(20) UNIQUE, PHONE_NO NUMBER(10) NOT NULL);

DESC B;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'B';

ALTER TABLE B DROP PRIMARY KEY CASCADE;

ALTER TABLE B DROP CONSTRAINT SYS_C0010941;

ALTER TABLE B DROP CONSTRAINT SYS_C0010943;

DROP TABLE B;

ALTER TABLE B DISABLE CONSTRAINT PRIMARY KEY CASCADE;

ALTER TABLE B DISABLE CONSTRAINT SYS_C009893;

-- CASCADE CLAUSE IS NOT USED WITH ENABLE
ALTER TABLE B ENABLE PRIMARY KEY;

ALTER TABLE B ENABLE CONSTRAINT SYS_C009893;

SELECT *FROM EMPLOYEE;

SELECT LPAD(EMP_NAME,15,'*')   ||'     '   ||DOJ   ||'     '   ||SALARY "Employee Details" FROM EMPLOYEE;

SELECT PHONE_NUM+SALARY FROM EMPLOYEE;

SELECT TO_CHAR((DOJ+SALARY),'DD-MON-YYYY')FROM EMPLOYEE;

SELECT MONTHS_BETWEEN(SYSDATE,'07-OCT-1986')"Age in Month's" FROM DUAL;

SELECT(SYSDATE-(to_date('07-OCT-1986','DD-MON-YYYY')))/30"Age in Month's" FROM DUAL;

SELECT(TO_DATE('07-OCT-1986')-TO_DATE('26-APR-1986'))/30 FROM DUAL;

SELECT * FROM DUAL;

DESC DUAL;

SELECT ROUND((SYSDATE-TO_DATE('07-OCT-1986'))/365,0)"Age" FROM DUAL;

SELECT ROUND(MONTHS_BETWEEN(SYSDATE,'07-OCT-1986')/12)"Age in year" FROM DUAL;

SELECT POWER(2,15) FROM DUAL;

DROP TABLE C1;

CREATE TABLE C1 ( NAME VARCHAR2(20), ID INTEGER);

SELECT NAME, ID FROM C1 FOR UPDATE OF NAME, ID NOWAIT;

INSERT INTO C1 VALUES('ABC' , 1);

COMMIT;

CREATE USER V705417 IDENTIFIED BY PASSWORD;

ALTER USER V705417 IDENTIFIED BY PASSWORD;
alter session set "_ORACLE_SCRIPT"=true;
GRANT SELECT,UPDATE,INSERT,CREATE,TRUNCATE, COMMIT, ROLLBACK, SAVEPOINT, ALTER, INDEXES, EXECUTE, REFERENCES TO V705417;

GRANT ALL PRIVILEGES TO V705417;

REVOKE SELECT,UPDATE,INSERT,CREATE,TRUNCATE, COMMIT, ROLLBACK, SAVEPOINT, ALTER, INDEXES, EXECUTE, REFERENCES FROM V705417;

PURGE TABLE "BIN$Q/QyjqnaTcSoSSq0d7+6uA==$0";

CREATE ROLE ROLE_NAME;

GRANT SELECT,UPDATE,INSERT,CREATE,TRUNCATE, COMMIT, ROLLBACK, SAVEPOINT, ALTER, INDEXES, EXECUTE, REFERENCES TO ROLE_NAME;

GRANT ROLE_NAME TO USER_NAME;

REVOKE ROLE_NAME FROM USER_NAME;

REVOKE SELECT,UPDATE,INSERT,CREATE,TRUNCATE, COMMIT, ROLLBACK, SAVEPOINT, ALTER, INDEXES, EXECUTE, REFERENCES FROM USER_NAME;

SELECT INITCAP('ABHINAW KUMar bHAGAT') FROM DUAL;

SELECT ROUND(745.47,-1) FROM DUAL; -- 750

SELECT ROUND(744.47,-1) FROM DUAL; -- 740

SELECT ROUND(SYSDATE) FROM DUAL;

SELECT ROUND(SYSDATE+1,'MONTH') FROM DUAL;

SELECT ROUND(SYSDATE,'YEAR') FROM DUAL;

SELECT TRUNC(SYSDATE) FROM DUAL;

SELECT TRUNC(SYSDATE,'MONTH') FROM DUAL;

SELECT TRUNC(SYSDATE,'YEAR') FROM DUAL;

SELECT TO_CHAR(SALARY,'$099,99,999') FROM EMPLOYEE;

SELECT INSTR('ABCDEFGEJIEESS','E') FROM DUAL;

SELECT NEXT_DAY(SYSDATE,'SUNDAY') FROM DUAL;

SELECT  DESIGNATION, COUNT(DESIGNATION), COUNT(EMP_NAME) FROM  EMPLOYEE GROUP BY  DESIGNATION;

SELECT  DEPT_NAME, COUNT(DEPT_NAME) FROM  DEPARTMENT GROUP BY  DEPT_NAME;

--INLINE VIEW
SELECT ROWNUM, EMP_ID, EMP_NAME FROM(SELECT EMP_ID, EMP_NAME FROM EMPLOYEE ORDER BY SALARY DESC) WHERE ROWNUM <= 5;

-- STORE AN IMAGE IN DATABASE
CREATE TABLE IMAGE_T  (ID INTEGER, IMAGE BLOB);

INSERT INTO IMAGE_T VALUES(1 , utl_raw.cast_to_raw('D:\Java Study Materials\Preity Zinta.jpg'));

SELECT * FROM IMAGE_T;

DELETE FROM IMAGE_T WHERE ROWID NOT IN(SELECT MAX(ROWID) FROM IMAGE_T GROUP BY ID);

SELECT EMP_NAME   ||EMP_ID AS "Name-ID", SALARY FROM EMPLOYEE;

CREATE OR REPLACE VIEW EMP_DEPT_V AS
SELECT  D.DEPT_NAME NAME, MIN(SALARY) LOWEST, AVG(SALARY) AVERAGE, MAX(SALARY) HIGHEST
FROM  EMPLOYEE   E, DEPARTMENT D
WHERE  E.DEPT_ID = D.DEPT_ID
GROUP BY  D.DEPT_NAME;

SELECT * FROM EMP_DEPT_V;

-- TO GET THE CURRENT DATE
SELECT CURRENT_DATE FROM DUAL;

CREATE TABLE DATE_V(TODAY_DATE DATE);

INSERT INTO DATE_V VALUES(CURRENT_DATE);

SELECT TO_CHAR(TODAY_DATE,'DD-MON-YYYY,HH:MI:SS AM') FROM DATE_V;

SELECTTO_CHAR(CURRENT_DATE,'DD-MON-YYYY,HH:MI:SS AM') FROM DUAL;

ALTER TABLE DEPARTMENT ADD CONSTRAINT FK FOREIGN KEY(DEPT_ID) REFERENCES EMPLOYEE ON DELETE CASCADE;

SHOW USER;
-- Display the number value in Words
SELECT TO_CHAR(TO_DATE(525,'J'),'JSP') FROM DUAL;

SELECT SALARY,(TO_CHAR(TO_DATE(SALARY,'J'),'JSP')) FROM EMPLOYEE;

**************************************************** PL/SQL **************************************************************
-- CREATE A CURSOR TO FETCH ALL THE ROWS FROM THE EMPLOYEE TABLE
SET SERVEROUTPUT ON;
BEGIN
    DECLARE NAME EMPLOYEE.EMP_NAME%TYPE; ADDRESS EMPLOYEE.ADDRESS%TYPE; EMP EMPLOYEE%ROWTYPE; CURSOR CUR IS SELECT        EMP_NAME      , ADDRESS FROM        EMPLOYEE ;  CURSOR EMP_CUR           (               emp_id Employee.emp_id%type           ) IS SELECT * FROM        EMPLOYEE where        emp_id = emp_id ;-- emp is passed as the parameter to the cursor
    BEGIN OPEN CUR; LOOP FETCH CUR INTO       NAME     , ADDRESS ;  EXIT WHEN CUR%NOTFOUND; DBMS_OUTPUT.PUT_LINE('Name    :' ||NAME); DBMS_OUTPUT.PUT_LINE('Address :' ||ADDRESS); END LOOP; DBMS_OUTPUT.PUT_LINE(CUR%ROWCOUNT); CLOSE CUR; OPEN EMP_CUR(100); -- 100 is passed as the parameter to the cursor EMP_CUR --> EMP_CUR(emp_id Employee.emp_id%type :=100) LOOP FETCH EMP_CUR INTO       EMP ;  EXIT WHEN EMP_CUR%NOTFOUND; DBMS_OUTPUT.PUT_LINE('Name :' ||EMP.EMP_NAME); DBMS_OUTPUT.PUT_LINE('Address :' ||EMP.SALARY); END LOOP; DBMS_OUTPUT.PUT_LINE(EMP_CUR%ROWCOUNT); CLOSE EMP_CUR;
    END;
END;
-- ALTERNATE WAY TO FETCH ROWS FROM CURSOR USING FOR LOOP
SET SERVEROUTPUT ON;
DECLARE
    I INTEGER :=0;
BEGIN
    DBMS_OUTPUT.PUT_LINE(LPAD('Name',15,' ')
    ||'    Salary');
    DBMS_OUTPUT.PUT_LINE('-------------------------------');
    FOR CUR IN
    (    SELECT *    FROM       EMPLOYEE
    )
    LOOP EXIT WHEN I=5; DBMS_OUTPUT.PUT_LINE(LPAD(CUR.EMP_NAME,15,' ') ||'    ' ||CUR.SALARY); I := I+1;
    END LOOP;
END;
--------------------------------------------------------
SET SERVEROUTPUT ON;
DECLARE
    I INTEGER :=0;
    J INTEGER :=0;
BEGIN
    SELECT COUNT(*) INTO I FROM EMPLOYEE;
    DBMS_OUTPUT.PUT_LINE('Total No of Rows '||I);
    J :=I;
    I :=0;
    FOR CUR IN (SELECT * FROM EMPLOYEE)
    LOOP EXIT WHEN I=J; DBMS_OUTPUT.PUT_LINE(LPAD(CUR.EMP_NAME,14,'*')); I := I+1;
    END LOOP;
END;
--------------------------------------------------------
**********IMPLICIT CURSOR*********
    BEGIN UPDATE    EMP_INFORMATION SET    EMP_DEPT='Web Developer' WHERE    EMP_NAME='Saulin' ;

    IF SQL%FOUND THEN DBMS_OUTPUT.PUT_LINE('Updated - If Found');
    END IF;
    IF SQL%NOTFOUND THEN DBMS_OUTPUT.PUT_LINE('NOT Updated - If NOT Found');
    END IF;
    IF SQL%ROWCOUNT>0 THEN DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT ||' Rows Updated');
    ELSE DBMS_OUTPUT.PUT_LINE('NO Rows Updated Found');
    END;
    --CREATE PROCEDURE
    CREATE OR REPLACE PROCEDURE PRC_NAME                             (                                 X IN VARCHAR2                             )
    IS I    INTEGER :=1; NAME VARCHAR2(15); SAL  NUMBER;
    BEGIN FOR CUR IN (    SELECT *    FROM           EMPLOYEE ) LOOP EXIT WHEN I=5; DBMS_OUTPUT.PUT_LINE(LPAD(CUR.EMP_NAME,15,'*') ||'     ' ||CUR.SALARY); I := I+1; END LOOP;
    END;
    BEGIN PRC_NAME('X');
    END;

DECLARE
   i INTEGER := 1;
BEGIN
   WHILE i <= 10 LOOP
     DBMS_OUTPUT.PUT_LINE(i);
     i := i+1;
   END LOOP;
END;

    --PROCEDURE TO FIND THE FACTORIAL OF A NUMBER

    CREATE OR REPLACE PROCEDURE FACT_PRC (N IN INTEGER)
    IS
    FACT INTEGER :=1;
    I    INTEGER :=1;
    BEGIN
    IF N >=0 THEN WHILE I <= N
       LOOP
       FACT := FACT * I;
       EXIT WHEN I=N;
       I := I+1;
       END LOOP;
       DBMS_OUTPUT.PUT_LINE('Factorial is : ' || FACT);
    ELSE
       DBMS_OUTPUT.PUT_LINE('Factorial is : NA');
    END IF;
    END;

    SET SERVEROUTPUT ON;
    BEGIN FACT_PRC(0);
    END;
    BEGIN FACT_PRC(-5);
    END;
    SELECT * FROM EMPLOYEE;
    
    SELECT * FROM  EMPLOYEE ORDER BY  ADDRESS ASC;
    
    DESC EMPLOYEE;
    UPDATE EMPLOYEE SET SALARY=1000000 WHERE EMP_NAME='Abhinaw_Bhagat';
    
    UPDATE EMPLOYEE SET ADDRESS=NULL WHERE EMP_ID=101;
    
    UPDATE EMPLOYEE SET ADDRESS='Bhagalpur' WHERE EMP_ID=101;
    
    --- Query to generate sequence from 50 to 100
    SELECT ROWNUM FROM DUAL CONNECT BY ROWNUM <=100
    MINUS
    SELECT ROWNUM FROM    DUAL CONNECT BY ROWNUM <=50;
    
    -- Query to display in single string "ABCD,EFGH,IJKL,PQRS"
    SELECT REPLACE ('ABCD#EFGH#IJKL#PQRS','#') FROM DUAL;
    
    SELECT REPLACE ('ABCD#EFGH#IJKL#PQRS','#',',') FROM DUAL;
    
    -- Query to Count each Alphabet in the String
    SELECT LENGTH(regexp_replace('s,a,d,abc',','))"Count Alphabet" FROM DUAL;
    
    SELECT REPLACE ('s,a,d,abc',',') FROM DUAL;
    
    SELECT LENGTH(REPLACE ('s,a,d,abc',','))"Count Alphabet" FROM DUAL;
    
    A database table can have a maximum of 12 triggers CREATE SEQUENCE CUST_SEQ START WITH 1 INCREMENT BY 1 CACHE 20;

    CREATE TRIGGER CUSTOMER_ID_TRIG BEFORE
    INSERT ON CUSTOMERS
    FOR EACH ROW DECLARE BEGIN IF :NEW.CUSTOMER_ID IS NULL THEN
    SELECT  CONCAT('C',CONCAT(CUST_SEQ.NEXTVAL,TO_CHAR(SYSDATE,'ddmmyyyyhhmiss')))
    INTO    :NEW.CUSTOMER_ID
    FROM    DUAL
    ;

END IF;
END;
SELECT * FROM ALL_TRIGGERS WHERE TABLE_NAME = 'CUSTOMER';

SELECT * FROM DBA_TRIGGERS;

SELECT * FROM ALL_VIEWS;

SELECT * FROM ALL_SEQUENCES;

SELECT * FROM DBA_OBJECTS;

CREATE SEQUENCE EMPID_S START WITH 1000 INCREMENT BY 1;
SELECT * FROM EMPLOYEE;

-- Implementation of Pagination via SQL query

SELECT  TOP 10 FIRST_NAME, LAST_NAME, SCORE, COUNT(*) OVER()
FROM  EMPLOYEE
WHERE  (       SCORE < @PREVIOUSSCORE  )  OR  (       SCORE         = @PREVIOUSSCORE       AND PLAYER_ID < @PREVIOUSPLAYERID  )
ORDER BY  SCORE DESC, PLAYER_ID DESC
;

-----------------------------------UTPL--------------------------------------
UTASSERT.EQQUERYVALUE ('String Text','SELECT COUNT(*) FROM EMPLOYEE WHERE emp_id ='
|| EMP_ID, 1);
UTASSERT.EQ( 'String Text',L_RS,'S' );
UTASSERT.EQ ('String Text',L_FINAL_FREIGHT_COST,(L_INITIAL_FREIGHT_COST-UNIT_AMOUNT_2+UNIT_AMOUNT));
INSERT INTO EMPLOYEE VALUES(1 ,'Abhinaw' ,'07-OCT-1986');

L_INSERT_COUNTER := SQL%ROWCOUNT;
UTASSERT.EQ ('Rows inserted',L_INSERT_COUNTER,1); -- Make sure rows are inserted

Clustered Index: The clustered index is used to reorder the physical order of the table and search based on the key values.
                 Each table can have only one clustered index.

NonClustered Index: NonClustered Index does not alter the physical order of the table and maintains logical order of data.
                    Each table can have 999 non-clustered indexes.

-------------------------------- Working with BLOB/CLOB and XML------------------------------
    UPDATE    EMPLOYEE SET XML = UTL_RAW.CAST_TO_RAW('<?xml version = "1.0" encoding="UTF-8" standalone="yes"?>
<EMP>
	<EMP_ID>1</EMP_ID>
	<EMP_NAME>Abhinaw</EMP_NAME>
	<SALARY>95000</SALARY>
	<DOJ>20170522</DOJ>
	<DOB>19880503</DOB>
	<DESIGNATION>Associate</DESIGNATION>
	<GENDER>M</GENDER>
	<PHONE>9701735542</PHONE>
	<EMAIL>abhinaw.kumar7@gmail.com</EMAIL>
	<FATHER>Rambrikchh</FATHER>
	<MOTHER>Amita</MOTHER>
	<RELATIONSHIP>Married</RELATIONSHIP>
	<ASSET>Y</ASSET>
	<HAS BROTHER>Y</HAS BROTHER>
	<HAS SISTER>N</HAS SISTER>
	<BIRTH PLACE>Bhagalpur</BIRTH PLACE>
	<WORK PLACE>Bangalore</WORK PLACE>
	<IPAD>
		<NAME>iPAD Air 2</NAME>
		<TYPE>Tablet</TYPE>
		<COMPANY>Apple</COMPANY>
	</IPAD>
	<LAPTOP>
		<NAME>Ideapad</NAME>
		<TYPE>Laptop</TYPE>
		<COMPANY>Lenovo</COMPANY>
	</LAPTOP>
	<BIKE>
		<NAME>Pulsar</NAME>
		<TYPE>150 cc</TYPE>
		<COMPANY>Bajaj</COMPANY>	
	</BIKE>
	<INTERNET>
		<NAME>Docomo</NAME>
		<TYPE>Broadband</TYPE>
		<COMPANY>Tata Docomo</COMPANY>
	</INTERNET>
	<MANAGER>
		<MGR_NAME>Malu</MGR_NAME>
		<MGR_ID>10</MGR_ID>
		<TOTAL>12</TOTAL>
		<MGR_DESIGNATION>VP</MGR_DESIGNATION>
		<MGR_GENDER>F</MGR_GENDER>
		<MGR_PHONE>9871231986</MGR_PHONE>
		<MGR_EMAIL>malu.mathen@gmail.com</MGR_EMAIL>
	</MANAGER>
	<DEPARTMENT>
		<DEPT_ID>1</DEPT_ID>
		<DEPT_NAME>Trade</DEPT_NAME>
		<DEPT_LOC>
			<LINE 1>Prestige Tech Park</LINE 1>
			<LINE 2>Electra Wing B - 7th Floor</LINE 2>
			<CITY>Bangalore</CITY>
			<STATE>Karnataka</STATE>
			<PIN_CODE>560067</PIN_CODE>
		</DEPT_LOC>
		<DEPT_COST>123456789</DEPT_COST>
		<DEPT_HEAD>Vinay Purohit</DEPT_HEAD>
	</DEPARTMENT>
	<PROJECT>
		<PROJ_ID>2</PROJ_ID>')
    WHERE    EMP_ID = 1;
    
    -- Steps to insert a BLOB type in database column
    CREATE
    OR
    REPLACE DIRECTORY TEST_DIR AS 'C:\Users\Nikita\Desktop\';
    GRANT READ,WRITE,EXECUTE ON DIRECTORY TEST_DIR to system;
    DECLARE l_bfile BFILE; l_blob BLOB;
    BEGIN l_bfile := BFILENAME('TEST_DIR', 'Emp.xml'); DBMS_LOB.CREATETEMPORARY(l_blob,true); DBMS_LOB.fileopen(l_bfile, Dbms_Lob.File_Readonly); DBMS_LOB.loadfromfile(l_blob, l_bfile, DBMS_LOB.getlength(l_bfile)); DBMS_LOB.fileclose(l_bfile); UPDATE    EMPLOYEE SET    XML = l_blob WHERE    EMP_ID = 1 return xml into    l_blob ;
    
    END;
    --------------------------------------------------------------------------------------------
    SELECT    TABLE_NAME  , COLUMN_NAME  , DATA_TYPE  , DATA_LENGTH
    FROM    USER_TAB_COLUMNS
    WHERE    TABLE_NAME IN( 'EMPLOYEE'            ,'DEPARTMENT')
    ;
    
    -- Convert BLOB to CLOB
    CREATE OR REPLACE FUNCTION BLOB2CLOB                             (                                 L_BLOB BLOB                             ) RETURN CLOB
    IS L_CLOB CLOB; L_SRC_OFFSET   NUMBER; L_DEST_OFFSET  NUMBER; L_BLOB_CSID    NUMBER := DBMS_LOB.DEFAULT_CSID; V_LANG_CONTEXT NUMBER := DBMS_LOB.DEFAULT_LANG_CTX; L_WARNING      NUMBER; L_AMOUNT       NUMBER;
    BEGIN DBMS_LOB.CREATETEMPORARY(L_CLOB, TRUE); L_SRC_OFFSET  := 1; L_DEST_OFFSET := 1; L_AMOUNT      := DBMS_LOB.GETLENGTH(L_BLOB); DBMS_LOB.CONVERTTOCLOB(L_CLOB,L_BLOB,L_AMOUNT,L_SRC_OFFSET,L_DEST_OFFSET,1,V_LANG_CONTEXT,L_WARNING); RETURN L_CLOB;
    END;
    -- Convert CLOB_TO_BLOB
    CREATE OR REPLACE FUNCTION CLOB2BLOB                             (                                 L_CLOB CLOB                             ) RETURN BLOB
    IS L_BLOB BLOB; L_SRC_OFFSET   NUMBER; L_DEST_OFFSET  NUMBER; L_BLOB_CSID    NUMBER := DBMS_LOB.DEFAULT_CSID; V_LANG_CONTEXT NUMBER := DBMS_LOB.DEFAULT_LANG_CTX; L_WARNING      NUMBER; L_AMOUNT       NUMBER;
    BEGIN DBMS_LOB.CREATETEMPORARY(L_BLOB, TRUE); L_SRC_OFFSET  := 1; L_DEST_OFFSET := 1; L_AMOUNT      := DBMS_LOB.GETLENGTH(L_CLOB); DBMS_LOB.CONVERTTOBLOB(L_BLOB,L_CLOB,L_AMOUNT,L_SRC_OFFSET,L_DEST_OFFSET,1,V_LANG_CONTEXT,L_WARNING); RETURN L_BLOB;
    END;
    -- PL/SQL to change BLOB TO CLOB
    DECLARE L_CLOB CLOB; L_BLOB BLOB; V_LANG_CONTEXT NUMBER := DBMS_LOB.DEFAULT_LANG_CTX; L_SRC_OFFSET   NUMBER := 1; L_DEST_OFFSET  NUMBER := 1; L_WARNING      NUMBER;
    BEGIN SELECT    XML INTO    L_BLOB FROM    EMPLOYEE WHERE    EMP_ID = 1 ;  DBMS_LOB.CREATETEMPORARY(L_CLOB, TRUE); DBMS_LOB.CONVERTTOCLOB(L_CLOB,L_BLOB,DBMS_LOB.GETLENGTH(L_BLOB),L_SRC_OFFSET,L_DEST_OFFSET,1,V_LANG_CONTEXT,L_WARNING); DBMS_OUTPUT.PUT_LINE(L_CLOB);
    END;
    -- Using the below query we can fetch the value of any node provided we know thw XPath of the XML Node
    SELECT    XMLTYPE(BLOB2CLOB(XML)).EXTRACT('/*/EMP_NAME/text()') "RESULT"
    FROM    EMPLOYEE
    WHERE    EMP_ID =1
    ;
    
    SELECT    XMLTYPE(BLOB2CLOB(XML)).EXTRACT('/*/*/*/PIN_CODE/text()') "RESULT"
    FROM    EMPLOYEE
    WHERE    EMP_ID =1
    ;
    
    SELECT    XMLQUERY('<EMPLOYEE>' RETURNING CONTENT)
    FROM    EMPLOYEE
    WHERE    EMP_ID=1
    ;
    
    SELECT    XMLTYPE.CREATEXML(BLOB2CLOB(XML)).GETROOTELEMENT() AS "ROOTELEMENT"
    FROM    EMPLOYEE
    WHERE    EMP_ID =1
    ;
    
    -- To get all the child elements of a particular node.
    SELECT    XMLTYPE.CREATEXML(BLOB2CLOB(XML)).EXTRACT('/EMPLOYEE/IPAD//text()') AS "ROOTELEMENT"
    FROM    EMPLOYEE
    WHERE    EMP_ID =1
    ;
    
    SELECT    XMLTYPE.CREATEXML(BLOB2CLOB(XML)).EXTRACT('//DEPT_LOC//text()') AS "ROOTELEMENT"
    FROM    EMPLOYEE
    WHERE    EMP_ID =1
    ;
    
    SELECT    XMLTYPE.CREATEXML(BLOB2CLOB(XML)).EXTRACT('/EMPLOYEE/ADDRESS/HOME_ADDRESS/CITY//text()') AS "ROOTELEMENT"
    FROM    EMPLOYEE
    WHERE    EMP_ID =1
    ;
    
    SELECT    XMLTYPE.CREATEXML(BLOB2CLOB(XML)).EXTRACT('EMPLOYEE/EMP_NAME/text()').GETSTRINGVAL()"Value"
    FROM    EMPLOYEE
    WHERE    EMP_ID =1
    ;
    
    SELECT    EXISTSNODE(XMLTYPE.CREATEXML(BLOB2CLOB(XML)), '/EMPLOYEE/EMP_NAME') "Emp Name"
    FROM    EMPLOYEE
    WHERE    EMP_ID =1
    ;
    
    -- Important link
    https://docs.oracle.com/cd/B10501_01/appdev.920/a96620/xdb04cre.htm
    SELECT (SYSDATE-TO_DATE('03-OCT-2011'))/365.25
    FROM DUAL
    ;