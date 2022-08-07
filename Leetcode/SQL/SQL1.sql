-- Big Countries
SELECT name,population,area FROM World WHERE area >= 3000000 OR population >= 25000000;

-- Recyclable and Low Fat Products
SELECT product_id FROM Products WHERE low_fats ="Y" AND recyclable="Y";

-- Find Customer Referee
SELECT name FROM Customer WHERE COALESCE(referee_id, 0) != 2;
SELECT name FROM Customer WHERE referee_id IS NULL OR referee_id <> 2;
SELECT name FROM Customer WHERE referee_id IS NULL OR referee_id != 2;

-- Customers Who Never Order
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

