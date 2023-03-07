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
    
12. **Query all employees whose salary greater than 50,000 based on all salary component .**
    
**EMPLOYEE Table:**
    | ID      | First_Name | Last_Name
    | ----------- | ----------- | -----------
    | 1      | Kumar | Sudarshan
    | 2   | Rahul | Kumar
    | 3   | Ankit | Kumar


   **EMP_SALARY Table:**
   | EMP_ID      | Component | Salary
   | ----------- | ----------- | -----------
   | 1      | BASIC | 25000
   | 1   | HRA | 12000
   | 1   | BONUS | 37000
   | 2      | BASIC | 15000
   | 2   | HRA | 10000
   | 2   | BONUS | 11000
   | 3      | BASIC | 20000
   | 3   | HRA | 20000
   | 3   | BONUS | 35000


```    
    SELECT es.EMP_ID , e.FIRST_NAME , e.LAST_NAME, SUM(es.SALARY)  FROM EMPLOYEE e, EMP_SALARY es 
      WHERE e.ID = es.EMP_ID 
      GROUP BY es.EMP_ID 
      HAVING SUM(es.SALARY) > 50000
```  
Output:
   | EMP_ID | First_Name | Last_Name | Salary
   | ----------- | ----------- | ----------- | -----------
   1 |	Kumar |	Sudarshan |	74000
   2 |	Ankit |	Kumar |	70000

13. Create temporal tables
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

## What are Indexes and how to create an indexes in SQL?
```
Indexes are database objects which help in retrieving records quickly and more efficiently.
Column indexes can be created on both Tables and Views. 
By declaring a Column as an index within a table/ view, 
the user can access those records quickly by executing the index. 
Indexes with more than one column are called Clustered indexes.
```

Syntax:
    **CREATE INDEX INDEX_NAME ON TABLE_NAME(COL1, COL2);**
    
**The syntax to drop an Index is DROP INDEX INDEX_NAME on TABLE_NAME;**

### How these indexes work internally
**Indexes** are known to improve the efficiency of SQL Select queries
Suppose we need to search by employee name = Kumar
What goes on behind the scenes is Every single row is checked to see
if the employee_name matches with Kumar. This effectively means that the 
entire table will have to be scanned (known as the **full table scan**).

An index is a data structure that stores the values for a certain specific column
of a table and helps us avoid a full table scan. 

Database Indexing in reality, allows us to cut down the number of rows/records
that need to be examined when a select query with a where clause is executed.

Few DS are :
**B-Tree** : B-Trees are the most commonly used data structures for indexes 
as they are time-efficient for lookups, deletions and insertions. All these
operations can be done in **logarithmic time**. Data that is stored inside of a B-tree 
can be **sorted**.

Database indexes will also store pointers which are simply reference 
information for the location of the additional information in memory. 
Basically the index holds the customer_id and that particular row’s home address on the memory disk.

The query looks for the specific row in the index; the index refers to the pointer which will
find the rest of the information.


### Disadvantages of indexes
- Index takes up additional space, so the larger the table, the bigger the index.
- Every time you perform and add, delete or update operation, the same operation will
   need to be perfromed on the index as well.

### If we drop a table, does it also drop related objects like contraints, indexes, columns, default, views and stored procedures?
- Yes, SQL server drops all related objects, which exists inside a table like constraints, 
indexes, columns, defaults etc.
- But dropping a table will not drop views and sorted procedures as they exist outside the table.
