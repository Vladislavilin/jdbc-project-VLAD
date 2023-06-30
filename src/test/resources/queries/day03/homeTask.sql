select * from employees;
select * from DEPARTMENTS;

-- 1. Display all first_name and department_name

select * from EMPLOYEES;
select * from DEPARTMENTS;
select FIRST_NAME, DEPARTMENT_NAME from EMPLOYEES join DEPARTMENTS on employees.DEPARTMENT_ID=DEPARTMENTS.DEPARTMENT_ID;


-- 2.Display all first_name and department_name including the  department without employee
select  FIRST_NAME, DEPARTMENT_NAME from EMPLOYEES right join DEPARTMENTS on employees.department_id=departments.department_id;


-- 3.Display all first_name and department_name including the  employee without department
select FIRST_NAME, DEPARTMENT_NAME from EMPLOYEES left join DEPARTMENTS on employees.DEPARTMENT_ID=  DEPARTMENTS.DEPARTMENT_ID;


-- 4.Display all first_name and department_name
-- including the  department without employee  and  employees  without departments
select FIRST_NAME, DEPARTMENt_name from EMPLOYEES full  join DEPARTMENTS on employees.DEPARTMENT_ID=departments.DEPARTMENT_ID;

-- 5.Display All cities and related country names
select CITY, COUNTRY_NAME from LOCATIONS join COUNTRIES on locations.COUNTRY_ID=countries.COUNTRY_ID;


-- 6.Display All cities and related country names  including with countries without city
select CITY, COUNTRY_NAME from LOCATIONS right join COUNTRIES on locations.COUNTRY_ID=countries.COUNTRY_ID;




-- 7.Display all department name and  street adresss
SELECT * from DEPARTMENTS;
select  * from LOCATIONS;

select  DEPARTMENT_NAME, STREET_ADDRESS from DEPARTMENTS join LOCATIONS on DEPARTMENTS.LOCATION_ID = LOCATIONS.LOCATION_ID;




-- 8.Display first_name,last_name and department_name,city for all employees
select FIRST_NAME, LAST_NAME, DEPARTMENT_NAME, city from EMPLOYEES join DEPARTMENTS on EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID join LOCATIONS on DEPARTMENTS.LOCATION_ID = LOCATIONS.LOCATION_ID;



-- 9.Display first_name,last_name and department_name,city,country_name for all employees
select FIRST_NAME, LAST_NAME, DEPARTMENT_NAME, CITY, COUNTRY_NAME from EMPLOYEES join DEPARTMENTS on EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID join LOCATIONS on DEPARTMENTS.LOCATION_ID = LOCATIONS.LOCATION_ID join COUNTRIES on LOCATIONS.COUNTRY_ID = COUNTRIES.COUNTRY_ID;



-- 10.Display first_name,last_name and department_name,city who is living in United Kingdom

select FIRST_NAME, LAST_NAME, DEPARTMENT_NAME, city, COUNTRY_NAME from EMPLOYEES join DEPARTMENTS on EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID join LOCATIONS on DEPARTMENTS.LOCATION_ID = LOCATIONS.LOCATION_ID join COUNTRIES on LOCATIONS.COUNTRY_ID=COUNTRIES.COUNTRY_ID where COUNTRY_NAME = 'United Kingdom';



-- 11.Display how many employee we have for each country name
select * from EMPLOYEES;

SELECT COUNTRY_NAME, count(EMPLOYEE_ID) as employee from COUNTRIES full join LOCATIONS on COUNTRIES.COUNTRY_ID = LOCATIONS.COUNTRY_ID full join DEPARTMENTS on LOCATIONS.LOCATION_ID = DEPARTMENTS.LOCATION_ID full join EMPLOYEES on DEPARTMENTS.DEPARTMENT_ID = EMPLOYEES.DEPARTMENT_ID group by COUNTRY_NAME;

select FIRST_NAME, CITY from EMPLOYEES join DEPARTMENTS on EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID join LOCATIONS on DEPARTMENTS.LOCATION_ID = LOCATIONS.LOCATION_ID ;

select * from EMPLOYEES join DEPARTMENTS on EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID join LOCATIONS on DEPARTMENTS.LOCATION_ID = LOCATIONS.LOCATION_ID join COUNTRIES on LOCATIONS.COUNTRY_ID = COUNTRIES.COUNTRY_ID where COUNTRY_NAME is null;

SELECT
    COUNTRY_NAME,
    COUNT(EMPLOYEE_ID) AS employee, EMPLOYEES.FIRST_NAME
FROM
    COUNTRIES
        FULL JOIN LOCATIONS ON COUNTRIES.COUNTRY_ID = LOCATIONS.COUNTRY_ID
        FULL JOIN DEPARTMENTS ON LOCATIONS.LOCATION_ID = DEPARTMENTS.LOCATION_ID
        FULL JOIN EMPLOYEES ON DEPARTMENTS.DEPARTMENT_ID = EMPLOYEES.DEPARTMENT_ID
GROUP BY
    COUNTRY_NAME,
    EMPLOYEES.FIRST_NAME;

select * from EMPLOYEES;










