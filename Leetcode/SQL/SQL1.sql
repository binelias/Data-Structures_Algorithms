-- Big Countries
-- Input
-- Table: World
-- +-------------+-----------+---------+------------+--------------+
-- | name        | continent | area    | population | gdp          |
-- +-------------+-----------+---------+------------+--------------+
-- | Afghanistan | Asia      | 652230  | 25500100   | 20343000000  |
-- | Albania     | Europe    | 28748   | 2831741    | 12960000000  |
-- | Algeria     | Africa    | 2381741 | 37100000   | 188681000000 |
-- | Andorra     | Europe    | 468     | 78115      | 3712000000   |
-- | Angola      | Africa    | 1246700 | 20609294   | 100990000000 |
-- +-------------+-----------+---------+------------+--------------+
-- Output: 
-- +-------------+------------+---------+
-- | name        | population | area    |
-- +-------------+------------+---------+
-- | Afghanistan | 25500100   | 652230  |
-- | Algeria     | 37100000   | 2381741 |
-- +-------------+------------+---------+
SELECT name,population,area FROM World WHERE area >= 3000000 OR population >= 25000000;


-- Recyclable and Low Fat Products
-- Input: 
-- Products table:
-- +-------------+----------+------------+
-- | product_id  | low_fats | recyclable |
-- +-------------+----------+------------+
-- | 0           | Y        | N          |
-- | 1           | Y        | Y          |
-- | 2           | N        | Y          |
-- | 3           | Y        | Y          |
-- | 4           | N        | N          |
-- +-------------+----------+------------+
-- Output: 
-- +-------------+
-- | product_id  |
-- +-------------+
-- | 1           |
-- | 3           |
-- +-------------+
-- Explanation: Only products 1 and 3 are both low fat and recyclable.
SELECT product_id FROM Products WHERE low_fats ="Y" AND recyclable="Y";


-- Find Customer Referee
-- Input: 
-- Customer table:
-- +----+------+------------+
-- | id | name | referee_id |
-- +----+------+------------+
-- | 1  | Will | null       |
-- | 2  | Jane | null       |
-- | 3  | Alex | 2          |
-- | 4  | Bill | null       |
-- | 5  | Zack | 1          |
-- | 6  | Mark | 2          |
-- +----+------+------------+
-- Output: 
-- +------+
-- | name |
-- +------+
-- | Will |
-- | Jane |
-- | Bill |
-- | Zack |
-- +------+
SELECT name FROM Customer WHERE COALESCE(referee_id, 0) != 2;
SELECT name FROM Customer WHERE referee_id IS NULL OR referee_id <> 2;
SELECT name FROM Customer WHERE referee_id IS NULL OR referee_id != 2;


-- Customers Who Never Order
-- Input: 
-- Customers table:
-- +----+-------+
-- | id | name  |
-- +----+-------+
-- | 1  | Joe   |
-- | 2  | Henry |
-- | 3  | Sam   |
-- | 4  | Max   |
-- +----+-------+
-- Orders table:
-- +----+------------+
-- | id | customerId |
-- +----+------------+
-- | 1  | 3          |
-- | 2  | 1          |
-- +----+------------+
-- Output: 
-- +-----------+
-- | Customers |
-- +-----------+
-- | Henry     |
-- | Max       |
-- +-----------+
SELECT name AS Customers
FROM Customers AS c
LEFT JOIN Orders AS o
ON c.Id = o.CustomerId
WHERE o.CustomerId IS NULL;

select customers.name as 'Customers'
from customers
where customers.id not in
(
    select customerid from orders
);


-- Calculate Special Bonus
-- Input: 
-- Employees table:
-- +-------------+---------+--------+
-- | employee_id | name    | salary |
-- +-------------+---------+--------+
-- | 2           | Meir    | 3000   |
-- | 3           | Michael | 3800   |
-- | 7           | Addilyn | 7400   |
-- | 8           | Juan    | 6100   |
-- | 9           | Kannon  | 7700   |
-- +-------------+---------+--------+
-- Output: 
-- +-------------+-------+
-- | employee_id | bonus |
-- +-------------+-------+
-- | 2           | 0     |
-- | 3           | 0     |
-- | 7           | 7400  |
-- | 8           | 0     |
-- | 9           | 7700  |
-- +-------------+-------+
-- Explanation: 
-- The employees with IDs 2 and 8 get 0 bonus because they have an even employee_id.
-- The employee with ID 3 gets 0 bonus because their name starts with 'M'.
-- The rest of the employees get a 100% bonus.
SELECT employee_id, 
CASE 
    WHEN employee_id%2 = 1 AND name NOT LIKE 'M%' THEN salary
    ELSE 0 
END AS "bonus"
FROM Employees ORDER BY employee_id;


-- Swap Salary
-- Input: 
-- Salary table:
-- +----+------+-----+--------+
-- | id | name | sex | salary |
-- +----+------+-----+--------+
-- | 1  | A    | m   | 2500   |
-- | 2  | B    | f   | 1500   |
-- | 3  | C    | m   | 5500   |
-- | 4  | D    | f   | 500    |
-- +----+------+-----+--------+
-- Output: 
-- +----+------+-----+--------+
-- | id | name | sex | salary |
-- +----+------+-----+--------+
-- | 1  | A    | f   | 2500   |
-- | 2  | B    | m   | 1500   |
-- | 3  | C    | f   | 5500   |
-- | 4  | D    | m   | 500    |
-- +----+------+-----+--------+
-- Explanation: 
-- (1, A) and (3, C) were changed from 'm' to 'f'.
-- (2, B) and (4, D) were changed from 'f' to 'm'.
UPDATE Salary SET sex = IF(sex ="m","f","m");
UPDATE Salary SET sex = CASE sex WHEN 'm' THEN 'f' ELSE 'm' END;

-- Delete Duplicate Emails
-- Input: 
-- Person table:
-- +----+------------------+
-- | id | email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- | 3  | john@example.com |
-- +----+------------------+
-- Output: 
-- +----+------------------+
-- | id | email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- +----+------------------+
-- Explanation: john@example.com is repeated two times. We keep the row with the smallest Id = 1.
DELETE p1 FROM Person p1,
    Person p2
WHERE
    p1.Email = p2.Email AND p1.Id > p2.Id;

DELETE FROM Person WHERE Id NOT IN 
(SELECT * FROM(
    SELECT MIN(Id) FROM Person GROUP BY Email) as p);


-- Fix Names in a Table
-- Input: 
-- Users table:
-- +---------+-------+
-- | user_id | name  |
-- +---------+-------+
-- | 1       | aLice |
-- | 2       | bOB   |
-- +---------+-------+
-- Output: 
-- +---------+-------+
-- | user_id | name  |
-- +---------+-------+
-- | 1       | Alice |
-- | 2       | Bob   |
-- +---------+-------+
SELECT user_id, CONCAT(UPPER(SUBSTR(name,1,1)), LOWER(SUBSTR(name,2,100))) AS name 
FROM Users
ORDER BY user_id;


-- Group Sold Products By The Date
-- Input: 
-- Activities table:
-- +------------+------------+
-- | sell_date  | product     |
-- +------------+------------+
-- | 2020-05-30 | Headphone  |
-- | 2020-06-01 | Pencil     |
-- | 2020-06-02 | Mask       |
-- | 2020-05-30 | Basketball |
-- | 2020-06-01 | Bible      |
-- | 2020-06-02 | Mask       |
-- | 2020-05-30 | T-Shirt    |
-- +------------+------------+
-- Output: 
-- +------------+----------+------------------------------+
-- | sell_date  | num_sold | products                     |
-- +------------+----------+------------------------------+
-- | 2020-05-30 | 3        | Basketball,Headphone,T-shirt |
-- | 2020-06-01 | 2        | Bible,Pencil                 |
-- | 2020-06-02 | 1        | Mask                         |
-- +------------+----------+------------------------------+
-- Explanation: 
-- For 2020-05-30, Sold items were (Headphone, Basketball, T-shirt), we sort them lexicographically and separate them by a comma.
-- For 2020-06-01, Sold items were (Pencil, Bible), we sort them lexicographically and separate them by a comma.
-- For 2020-06-02, the Sold item is (Mask), we just return it.
SELECT sell_date,
COUNT(DISTINCT(product)) as num_sold,
GROUP_CONCAT(DISTINCT product ORDER BY product SEPARATOR ',') as products
FROM Activities
GROUP BY sell_date;


-- Patients With a Condition
-- Input: 
-- Patients table:
-- +------------+--------------+--------------+
-- | patient_id | patient_name | conditions   |
-- +------------+--------------+--------------+
-- | 1          | Daniel       | YFEV COUGH   |
-- | 2          | Alice        |              |
-- | 3          | Bob          | DIAB100 MYOP |
-- | 4          | George       | ACNE DIAB100 |
-- | 5          | Alain        | DIAB201      |
-- +------------+--------------+--------------+
-- Output: 
-- +------------+--------------+--------------+
-- | patient_id | patient_name | conditions   |
-- +------------+--------------+--------------+
-- | 3          | Bob          | DIAB100 MYOP |
-- | 4          | George       | ACNE DIAB100 | 
-- +------------+--------------+--------------+
-- Explanation: Bob and George both have a condition that starts with DIAB1.
SELECT * FROm Patients
WHERE conditions LIKE '% DIAB1%' OR conditions LIKE 'DIAB1%';

-- Employees With Missing Information
-- Input: 
-- Employees table:
-- +-------------+----------+
-- | employee_id | name     |
-- +-------------+----------+
-- | 2           | Crew     |
-- | 4           | Haven    |
-- | 5           | Kristian |
-- +-------------+----------+
-- Salaries table:
-- +-------------+--------+
-- | employee_id | salary |
-- +-------------+--------+
-- | 5           | 76071  |
-- | 1           | 22517  |
-- | 4           | 63539  |
-- +-------------+--------+
-- Output: 
-- +-------------+
-- | employee_id |
-- +-------------+
-- | 1           |
-- | 2           |
-- +-------------+
-- Explanation: 
-- Employees 1, 2, 4, and 5 are working at this company.
-- The name of employee 1 is missing.
-- The salary of employee 2 is missing.
SELECT employee_id FROM Employees WHERE employee_id NOT IN (SELECT employee_id FROM Salaries)
UNION
SELECT employee_id FROM Salaries WHERE employee_id NOT IN (SELECT employee_id FROM Employees)
ORDER BY employee_id;


-- Rearrange Products Table
-- Input: 
-- Products table:
-- +------------+--------+--------+--------+
-- | product_id | store1 | store2 | store3 |
-- +------------+--------+--------+--------+
-- | 0          | 95     | 100    | 105    |
-- | 1          | 70     | null   | 80     |
-- +------------+--------+--------+--------+
-- Output: 
-- +------------+--------+-------+
-- | product_id | store  | price |
-- +------------+--------+-------+
-- | 0          | store1 | 95    |
-- | 0          | store2 | 100   |
-- | 0          | store3 | 105   |
-- | 1          | store1 | 70    |
-- | 1          | store3 | 80    |
-- +------------+--------+-------+
-- Explanation: 
-- Product 0 is available in all three stores with prices 95, 100, and 105 respectively.
-- Product 1 is available in store1 with price 70 and store3 with price 80. The product is not available in store2.
SELECT product_id, "store1" AS store, store1 AS price FROM Products WHERE store1 IS NOT NULL
UNION ALL
SELECT product_id, "store2" AS store, store2 AS price FROM Products WHERE store2 IS NOT NULL
UNION ALL
SELECT product_id, "store3" AS store, store3 AS price FROM Products WHERE store3 IS NOT NULL
ORDER BY product_id;


-- Second Highest Salary
-- Example 1:
-- Input: 
-- Employee table:
-- +----+--------+
-- | id | salary |
-- +----+--------+
-- | 1  | 100    |
-- | 2  | 200    |
-- | 3  | 300    |
-- +----+--------+
-- Output: 
-- +---------------------+
-- | SecondHighestSalary |
-- +---------------------+
-- | 200                 |
-- +---------------------+
-- Example 2:
-- Input: 
-- Employee table:
-- +----+--------+
-- | id | salary |
-- +----+--------+
-- | 1  | 100    |
-- +----+--------+
-- Output: 
-- +---------------------+
-- | SecondHighestSalary |
-- +---------------------+
-- | null                |
-- +---------------------+
SELECT(
SELECT DISTINCT Salary
FROM Employee
ORDER BY Salary 
DESC LIMIT 1 OFFSET 1) AS SecondHighestSalary;

SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Salary < (SELECT MAX(Salary) FROM Employee);

SELECT IFNULL(
(SELECT DISTINCT Salary
FROM Employee
ORDER BY Salary DESC
LIMIT 1 OFFSET 1),NULL) AS SecondHighestSalary;


-- Tree Node
-- Each node in the tree can be one of three types:

-- "Leaf": if the node is a leaf node.
-- "Root": if the node is the root of the tree.
-- "Inner": If the node is neither a leaf node nor a root node.
-- Write an SQL query to report the type of each node in the tree.

-- Return the result table ordered by id in ascending order.

-- The query result format is in the following example.
-- Example 1:
-- Input: 
-- Tree table:
-- +----+------+
-- | id | p_id |
-- +----+------+
-- | 1  | null |
-- | 2  | 1    |
-- | 3  | 1    |
-- | 4  | 2    |
-- | 5  | 2    |
-- +----+------+
-- Output: 
-- +----+-------+
-- | id | type  |
-- +----+-------+
-- | 1  | Root  |
-- | 2  | Inner |
-- | 3  | Leaf  |
-- | 4  | Leaf  |
-- | 5  | Leaf  |
-- +----+-------+
-- Explanation: 
-- Node 1 is the root node because its parent node is null and it has child nodes 2 and 3.
-- Node 2 is an inner node because it has parent node 1 and child node 4 and 5.
-- Nodes 3, 4, and 5 are leaf nodes because they have parent nodes and they do not have child nodes.

-- Example 2:
-- Input: 
-- Tree table:
-- +----+------+
-- | id | p_id |
-- +----+------+
-- | 1  | null |
-- +----+------+
-- Output: 
-- +----+-------+
-- | id | type  |
-- +----+-------+
-- | 1  | Root  |
-- +----+-------+
-- Explanation: If there is only one node on the tree, you only need to output its root attributes.
SELECT
    id AS `Id`,
    CASE
        WHEN tree.id = (SELECT atree.id FROM tree atree WHERE atree.p_id IS NULL)
          THEN 'Root'
        WHEN tree.id IN (SELECT atree.p_id FROM tree atree)
          THEN 'Inner'
        ELSE 'Leaf'
    END AS Type
FROM
    tree
ORDER BY `Id`;


SELECT
    atree.id,
    IF(ISNULL(atree.p_id),
        'Root',
        IF(atree.id IN (SELECT p_id FROM tree), 'Inner','Leaf')) Type
FROM
    tree atree
ORDER BY atree.id


SELECT
    id, 'Root' AS Type
FROM
    tree
WHERE
    p_id IS NULL

UNION

SELECT
    id, 'Leaf' AS Type
FROM
    tree
WHERE
    id NOT IN (SELECT DISTINCT
            p_id
        FROM
            tree
        WHERE
            p_id IS NOT NULL)
        AND p_id IS NOT NULL

UNION

SELECT
    id, 'Inner' AS Type
FROM
    tree
WHERE
    id IN (SELECT DISTINCT
            p_id
        FROM
            tree
        WHERE
            p_id IS NOT NULL)
        AND p_id IS NOT NULL
ORDER BY id;


-- Combine Two Tables
-- Input: 
-- Person table:
-- +----------+----------+-----------+
-- | personId | lastName | firstName |
-- +----------+----------+-----------+
-- | 1        | Wang     | Allen     |
-- | 2        | Alice    | Bob       |
-- +----------+----------+-----------+
-- Address table:
-- +-----------+----------+---------------+------------+
-- | addressId | personId | city          | state      |
-- +-----------+----------+---------------+------------+
-- | 1         | 2        | New York City | New York   |
-- | 2         | 3        | Leetcode      | California |
-- +-----------+----------+---------------+------------+
-- Output: 
-- +-----------+----------+---------------+----------+
-- | firstName | lastName | city          | state    |
-- +-----------+----------+---------------+----------+
-- | Allen     | Wang     | Null          | Null     |
-- | Bob       | Alice    | New York City | New York |
-- +-----------+----------+---------------+----------+
-- Explanation: 
-- There is no address in the address table for the personId = 1 so we return null in their city and state.
-- addressId = 1 contains information about the address of personId = 2.
SELECT p.FirstName, p.LastName, a.City,a.State
FROM Person p
LEFT OUTER JOIN
Address a
ON p.PersonId=a.PersonId;

SELECT Person.FirstName, Person.LastName, Address.City, Address.State 
FROM Person NATURAL 
LEFT JOIN Address;


-- Customer Who Visited but Did Not Make Any Transactions
-- Input: 
-- Visits
-- +----------+-------------+
-- | visit_id | customer_id |
-- +----------+-------------+
-- | 1        | 23          |
-- | 2        | 9           |
-- | 4        | 30          |
-- | 5        | 54          |
-- | 6        | 96          |
-- | 7        | 54          |
-- | 8        | 54          |
-- +----------+-------------+
-- Transactions
-- +----------------+----------+--------+
-- | transaction_id | visit_id | amount |
-- +----------------+----------+--------+
-- | 2              | 5        | 310    |
-- | 3              | 5        | 300    |
-- | 9              | 5        | 200    |
-- | 12             | 1        | 910    |
-- | 13             | 2        | 970    |
-- +----------------+----------+--------+
-- Output: 
-- +-------------+----------------+
-- | customer_id | count_no_trans |
-- +-------------+----------------+
-- | 54          | 2              |
-- | 30          | 1              |
-- | 96          | 1              |
-- +-------------+----------------+
-- Explanation: 
-- Customer with id = 23 visited the mall once and made one transaction during the visit with id = 12.
-- Customer with id = 9 visited the mall once and made one transaction during the visit with id = 13.
-- Customer with id = 30 visited the mall once and did not make any transactions.
-- Customer with id = 54 visited the mall three times. During 2 visits they did not make any transactions, and during one visit they made 3 transactions.
-- Customer with id = 96 visited the mall once and did not make any transactions.
-- As we can see, users with IDs 30 and 96 visited the mall one time without making any transactions. Also, user 54 visited the mall twice and did not make any transactions.
SELECT DISTINCT(customer_id), COUNT(customer_id) AS count_no_trans
FROM Visits WHERE visit_id NOT IN(SELECT visit_id FROM Transactions) 
GROUP BY customer_id;


-- Article Views I
-- Input: 
-- Views table:
-- +------------+-----------+-----------+------------+
-- | article_id | author_id | viewer_id | view_date  |
-- +------------+-----------+-----------+------------+
-- | 1          | 3         | 5         | 2019-08-01 |
-- | 1          | 3         | 6         | 2019-08-02 |
-- | 2          | 7         | 7         | 2019-08-01 |
-- | 2          | 7         | 6         | 2019-08-02 |
-- | 4          | 7         | 1         | 2019-07-22 |
-- | 3          | 4         | 4         | 2019-07-21 |
-- | 3          | 4         | 4         | 2019-07-21 |
-- +------------+-----------+-----------+------------+
-- Output: 
-- +------+
-- | id   |
-- +------+
-- | 4    |
-- | 7    |
-- +------+
SELECT DISTINCT(author_id) AS id FROM VIEWS
WHERE author_id = viewer_id
ORDER BY author_id ASC;

SELECT author_id id 
FROM VIEWS WHERE author_id=viewer_id 
GROUP BY author_id 
ORDER BY author_id ASC;


-- Rising Temperature
-- Input: 
-- Weather table:
-- +----+------------+-------------+
-- | id | recordDate | temperature |
-- +----+------------+-------------+
-- | 1  | 2015-01-01 | 10          |
-- | 2  | 2015-01-02 | 25          |
-- | 3  | 2015-01-03 | 20          |
-- | 4  | 2015-01-04 | 30          |
-- +----+------------+-------------+
-- Output: 
-- +----+
-- | id |
-- +----+
-- | 2  |
-- | 4  |
-- +----+
-- Explanation: 
-- In 2015-01-02, the temperature was higher than the previous day (10 -> 25).
-- In 2015-01-04, the temperature was higher than the previous day (20 -> 30).
SELECT
    weather.id AS 'Id'
FROM
    weather
        JOIN
    weather w ON DATEDIFF(weather.recordDate, w.recordDate) = 1
        AND weather.Temperature > w.Temperature;


SELECT DISTINCT a.Id
FROM Weather a,Weather b
WHERE a.Temperature > b.Temperature
AND DATEDIFF(a.Recorddate,b.Recorddate) = 1;


-- Sales Person
-- Input: 
-- SalesPerson table:
-- +----------+------+--------+-----------------+------------+
-- | sales_id | name | salary | commission_rate | hire_date  |
-- +----------+------+--------+-----------------+------------+
-- | 1        | John | 100000 | 6               | 4/1/2006   |
-- | 2        | Amy  | 12000  | 5               | 5/1/2010   |
-- | 3        | Mark | 65000  | 12              | 12/25/2008 |
-- | 4        | Pam  | 25000  | 25              | 1/1/2005   |
-- | 5        | Alex | 5000   | 10              | 2/3/2007   |
-- +----------+------+--------+-----------------+------------+
-- Company table:
-- +--------+--------+----------+
-- | com_id | name   | city     |
-- +--------+--------+----------+
-- | 1      | RED    | Boston   |
-- | 2      | ORANGE | New York |
-- | 3      | YELLOW | Boston   |
-- | 4      | GREEN  | Austin   |
-- +--------+--------+----------+
-- Orders table:
-- +----------+------------+--------+----------+--------+
-- | order_id | order_date | com_id | sales_id | amount |
-- +----------+------------+--------+----------+--------+
-- | 1        | 1/1/2014   | 3      | 4        | 10000  |
-- | 2        | 2/1/2014   | 4      | 5        | 5000   |
-- | 3        | 3/1/2014   | 1      | 1        | 50000  |
-- | 4        | 4/1/2014   | 1      | 4        | 25000  |
-- +----------+------------+--------+----------+--------+
-- Output: 
-- +------+
-- | name |
-- +------+
-- | Amy  |
-- | Mark |
-- | Alex |
-- +------+
-- Explanation: 
-- According to orders 3 and 4 in the Orders table, it is easy to tell that only salesperson John and Pam have sales to company RED, so we report all the other names in the table salesperson.
SELECT name
    FROM SalesPerson
    WHERE sales_id NOT IN (SELECT sales_id FROM Orders WHERE com_id NOT IN(SELECT      
    com_id FROM Company where name <> 'RED'));

SELECT
    s.name
FROM
    salesperson s
WHERE
    s.sales_id NOT IN (SELECT
            o.sales_id
        FROM
            orders o
                LEFT JOIN
            company c ON o.com_id = c.com_id
        WHERE
            c.name = 'RED');


-- User Activity for the Past 30 Days 
-- Table: Activity

-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | user_id       | int     |
-- | session_id    | int     |
-- | activity_date | date    |
-- | activity_type | enum    |
-- +---------------+---------+
-- There is no primary key for this table, it may have duplicate rows.
-- The activity_type column is an ENUM of type ('open_session', 'end_session', 'scroll_down', 'send_message').
-- The table shows the user activities for a social media website. 
-- Note that each session belongs to exactly one user.

-- Write an SQL query to find the daily active user count for a period of 30 days ending 2019-07-27 inclusively. A user was active on someday if they made at least one activity on that day.

-- Return the result table in any order.

-- The query result format is in the following example.


-- Example 1:

-- Input: 
-- Activity table:
-- +---------+------------+---------------+---------------+
-- | user_id | session_id | activity_date | activity_type |
-- +---------+------------+---------------+---------------+
-- | 1       | 1          | 2019-07-20    | open_session  |
-- | 1       | 1          | 2019-07-20    | scroll_down   |
-- | 1       | 1          | 2019-07-20    | end_session   |
-- | 2       | 4          | 2019-07-20    | open_session  |
-- | 2       | 4          | 2019-07-21    | send_message  |
-- | 2       | 4          | 2019-07-21    | end_session   |
-- | 3       | 2          | 2019-07-21    | open_session  |
-- | 3       | 2          | 2019-07-21    | send_message  |
-- | 3       | 2          | 2019-07-21    | end_session   |
-- | 4       | 3          | 2019-06-25    | open_session  |
-- | 4       | 3          | 2019-06-25    | end_session   |
-- +---------+------------+---------------+---------------+
-- Output: 
-- +------------+--------------+ 
-- | day        | active_users |
-- +------------+--------------+ 
-- | 2019-07-20 | 2            |
-- | 2019-07-21 | 2            |
-- +------------+--------------+ 
-- Explanation: Note that we do not care about days with zero active users.
SELECT activity_date AS day, 
COUNT( DISTINCT user_id ) AS active_users FROM Activity
WHERE DATEDIFF('2019-07-27', activity_date) BETWEEN 0 AND 29
GROUP BY day;


-- Daily Leads and Partners
-- Table: DailySales

-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | date_id     | date    |
-- | make_name   | varchar |
-- | lead_id     | int     |
-- | partner_id  | int     |
-- +-------------+---------+
-- This table does not have a primary key.
-- This table contains the date and the name of the product sold and the IDs of the lead and partner it was sold to.
-- The name consists of only lowercase English letters.

-- Write an SQL query that will, for each date_id and make_name, return the number of distinct lead_id's and distinct partner_id's.

-- Return the result table in any order.

-- The query result format is in the following example.

-- Example 1:

-- Input: 
-- DailySales table:
-- +-----------+-----------+---------+------------+
-- | date_id   | make_name | lead_id | partner_id |
-- +-----------+-----------+---------+------------+
-- | 2020-12-8 | toyota    | 0       | 1          |
-- | 2020-12-8 | toyota    | 1       | 0          |
-- | 2020-12-8 | toyota    | 1       | 2          |
-- | 2020-12-7 | toyota    | 0       | 2          |
-- | 2020-12-7 | toyota    | 0       | 1          |
-- | 2020-12-8 | honda     | 1       | 2          |
-- | 2020-12-8 | honda     | 2       | 1          |
-- | 2020-12-7 | honda     | 0       | 1          |
-- | 2020-12-7 | honda     | 1       | 2          |
-- | 2020-12-7 | honda     | 2       | 1          |
-- +-----------+-----------+---------+------------+
-- Output: 
-- +-----------+-----------+--------------+-----------------+
-- | date_id   | make_name | unique_leads | unique_partners |
-- +-----------+-----------+--------------+-----------------+
-- | 2020-12-8 | toyota    | 2            | 3               |
-- | 2020-12-7 | toyota    | 1            | 2               |
-- | 2020-12-8 | honda     | 2            | 2               |
-- | 2020-12-7 | honda     | 3            | 2               |
-- +-----------+-----------+--------------+-----------------+
-- Explanation: 
-- For 2020-12-8, toyota gets leads = [0, 1] and partners = [0, 1, 2] while honda gets leads = [1, 2] and partners = [1, 2].
-- For 2020-12-7, toyota gets leads = [0] and partners = [1, 2] while honda gets leads = [0, 1, 2] and partners = [1, 2].

SELECT
    date_id,
    make_name,
    COUNT(DISTINCT lead_id) AS unique_leads,
    COUNT(DISTINCT partner_id) AS unique_partners
FROM DailySales
GROUP BY date_id, make_name;


-- Find Followers Count
-- Table: Followers

-- +-------------+------+
-- | Column Name | Type |
-- +-------------+------+
-- | user_id     | int  |
-- | follower_id | int  |
-- +-------------+------+
-- (user_id, follower_id) is the primary key for this table.
-- This table contains the IDs of a user and a follower in a social media app where the follower follows the user.

-- Write an SQL query that will, for each user, return the number of followers.

-- Return the result table ordered by user_id.

-- The query result format is in the following example.


-- Example 1:

-- Input: 
-- Followers table:
-- +---------+-------------+
-- | user_id | follower_id |
-- +---------+-------------+
-- | 0       | 1           |
-- | 1       | 0           |
-- | 2       | 0           |
-- | 2       | 1           |
-- +---------+-------------+
-- Output: 
-- +---------+----------------+
-- | user_id | followers_count|
-- +---------+----------------+
-- | 0       | 1              |
-- | 1       | 1              |
-- | 2       | 2              |
-- +---------+----------------+
-- Explanation: 
-- The followers of 0 are {1}
-- The followers of 1 are {0}
-- The followers of 2 are {0,1}
SELECT DISTINCT(user_id), COUNT(follower_id) AS followers_count
FROM followers
GROUP BY user_id
ORDER BY user_id;
















