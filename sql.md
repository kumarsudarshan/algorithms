SQL Queries

1. **Fetch Nth highest salary**
    ```
        SELECT DISTINCT SALARY
        FROM TEST.EMPLOYEE e1
        WHERE N-1 =
            (SELECT COUNT(DISTINCT SALARY)
             FROM TEST.EMPLOYEE e2
             WHERE e2.SALARY > e1.SALARY)
    ```

   also

    ```
        SELECT DISTINCT SALARY
        FROM TEST.EMPLOYEE
        ORDER BY salary DESC
        LIMIT 1
        OFFSET N-1;
    ```

2. **Given two tables, City and Country. Print the name of all continents (key: Country.Continent) along with the
   average City population rounded down to the nearest integer.**

    ```
        SELECT Country.Continent,
               FLOOR(AVG(City.Population))
        FROM Country,
             City
        WHERE Country.Code = City.CountryCode
        GROUP BY Country.Continent ;
    ```

3. **Query a list of CITY names from STATION with even ID numbers only. You may print the results in any order, but must
   exclude duplicates from your answer.**

    ```
        SELECT DISTINCT CITY
        FROM STATION
        WHERE MOD(ID, 2)=0
        ORDER BY CITY ASC;
    ```

4. **Find the difference between the total number of CITY entries in the table, and the number of distinct CITY entries
   in the table.**

   ```
        SELECT COUNT(CITY) — COUNT(DISTINCT CITY)
        FROM STATION;
   ```

5. **Query the two cities in STATION with the shortest and longest CITY names, as well as their respective lengths (
   i.e.: number of characters in the name). If there is more than one smallest or largest city, choose the one that
   comes first when ordered alphabetically.**
   ```
       SELECT CITY, LENGTH(CITY)
        FROM STATION
        ORDER BY LENGTH(CITY) ASC, CITY
        LIMIT 1;
        
        SELECT CITY, LENGTH(CITY)
        FROM STATION
        ORDER BY LENGTH(CITY) DESC, CITY
        LIMIT 1;
   ```

6. **Query the list of CITY names starting with vowels (i.e., a, e, i, o, or u) from STATION. Your result cannot contain
   duplicates.**
   ```
        SELECT DISTINCT CITY
        FROM STATION
        WHERE substr(CITY, 1, 1)=’a’
            OR substr(CITY, 1, 1)=’e’
            OR substr(CITY, 1, 1)=’i’
            OR substr(CITY, 1, 1)=’o’
            OR substr(CITY, 1, 1)=’u’;
   ```
7. **Query the list of CITY names ending with vowels (a, e, i, o, u) from STATION. Your result cannot contain
   duplicates.**
   ```
        SELECT DISTINCT(CITY)
        FROM STATION
        WHERE CITY LIKE ‘%a’
            OR CITY LIKE ‘%e’
            OR CITY LIKE ‘%i’
            OR CITY LIKE ‘%o’
            OR CITY LIKE ‘%u’;
   ```
8. **Query the list of CITY names from STATION which have vowels (i.e., a, e, i, o, and u) as both their first and last
   characters. Your result cannot contain duplicates.**
   ```
        SELECT DISTINCT CITY
        FROM EMPLOYEE
        WHERE Substring(CITY, 1, 1) in ('a', 'e', 'i', 'o', 'u')
        AND 
        Substring(CITY, LENGTH(CITY), 1) in ('a', 'e', 'i', 'o', 'u')
    ```

9. **Query the total population of all cities in CITY where District is California.**
   ```
        SELECT SUM(POPULATION)
        FROM CITY
        WHERE DISTRICT = ‘California’;
   ```

10. **Query the average population for all cities in CITY, rounded down to the nearest integer.**
    ```    
        SELECT ROUND(AVG(POPULATION)) 
        FROM CITY;
    ```

11. **Query the difference between the maximum and minimum populations in CITY.**
    ```    
        SELECT MAX(POPULATION) - MIN(POPULATION) 
        FROM CITY;
    ```
    
12 Create temporal tables
System Temporal Table Declaration
In this example we will consider a simple table containing customers -
```
      CREATE TABLE CUSTOMER
         (CUSTOMER_ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH +1 INCREMENT BY +1 ),
         CUSTOMER_NAME VARCHAR(50),
         ADDRESS VARCHAR(250)
      );
```
There is a requirement to record all changes to this table and to be able to show the state of
customer record at any point in the past. This requirement, often called an audit trail, can be met
using system temporal support.

```
   alter table customer
      add system_start timestamp(12)
         generated always as row begin not null
      add system_end timestamp(12)
         generated always as row end not null
      add tx_start timestamp(12)
         generated always as transaction start id implicitly hidden
      add period system_time (system_start, system_end);
```
For select command :
```
SELECT … FROM <table> FOR SYSTEM_TIME <period-specification>

The <period-specification> comes in three formats -

AS OF <timestamp> Point in time
FROM <timestamp> TO <timestamp> Inclusive / exclusive period
BETWEEN <timestamp> AND <timestamp> Inclusive / inclusive period
```