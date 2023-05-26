-- 10=> Fiyatı 30 dan büyük kaç ürün var
Select * from products
where unit_price >30

-- 11=> Ürünlerin adını tamamen küçültüp fiyat sırasına göre tersten listele
Select Lower(product_name) from products

-- 12=> Çalışanların ad ve soyadlarını yan yana gelecek şekilde yazdır
Select CONCAT(first_name,' ',last_name) from employees

-- 13=> Region alanı NULL olan kaç tedarikçim var? 
Select Count(*) from customers 
where region is null

-- 14=> a.Null olmayanlar?
Select * from customers
where region is not null

-- 15=> Ürün adlarının hepsinin soluna TR koy ve büyültüp olarak ekrana yazdır.
SELECT CONCAT('TR ', UPPER(product_name))
FROM products

-- 16=> a.Fiyatı 20den küçük ürünlerin adının başına TR ekle
UPDATE products
SET product_name = CONCAT('TR ', product_name)
WHERE fiyat < 20;

-- 17=> En pahalı ürün listesini (`ProductName` , `UnitPrice`) almak için bir sorgu yazın.
Select product_name,unit_price from products 
group by product_name,unit_price
order by unit_price desc

-- 18=> En pahalı on ürünün Ürün listesini (`ProductName` , `UnitPrice`) almak için bir sorgu yazın.
Select product_name,unit_price from products
group by product_name,unit_price
order by unit_price desc limit 10 

	
-- 19=> Ürünlerin ortalama fiyatının üzerindeki Ürün listesini (`ProductName` , `UnitPrice`) almak için bir sorgu yazın.
Select product_name , unit_price from products 
where unit_price > (select AVG(unit_price)from products)
group by product_name , unit_price

-- 20=> Stokta olan ürünler satıldığında elde edilen miktar ne kadardır.
SELECT product_name, (units_in_stock - COALESCE(SUM(units_on_order), 0)) AS elde_edilen_miktar
FROM products
GROUP BY product_name, units_in_stock

-- 21=> Mevcut ve Durdurulan ürünlerin sayılarını almak için bir sorgu yazın.
SELECT
  (SELECT COUNT(*) FROM products WHERE discontinued = '0') AS mevcut_ürün_sayısı,
  (SELECT COUNT(*) FROM products WHERE discontinued = '1') AS durdurulan_ürün_sayısı;
	
-- 22=> Ürünleri kategori isimleriyle birlikte almak için bir sorgu yazın.
select product_name,category_name from products p
inner join categories c
on p.category_id = c.category_id
group by product_name, category_name

-- 23=> Ürünlerin kategorilerine göre fiyat ortalamasını almak için bir sorgu yazın.
select distinct category_name, AVG(unit_price) from products p
full outer join categories c
on p.category_id = c.category_id
group by  category_name


-- 24=> En pahalı ürünümün adı, fiyatı ve kategorisin adı nedir?
Select product_name, unit_price , category_name from products p
inner join categories c
on p.category_id = c.category_id
order by unit_price desc limit 1


-- 25=> En çok satılan ürününün adı, kategorisinin adı ve tedarikçisinin adı

Select product_name, category_name , units_on_order ,company_name from products p
join categories c on p.category_id = c.category_id
Join suppliers s on p.supplier_id = s.supplier_id
group by product_name, category_name, units_on_order, company_name
order by units_on_order desc limit 1

-- 26=> Stokta bulunmayan ürünlerin ürün listesiyle birlikte tedarikçilerin ismi ve iletişim numarasını (`ProductID`, `ProductName`, `CompanyName`, `Phone`) almak için bir sorgu yazın.
SELECT product_id, product_name,company_name,phone
FROM products
INNER JOIN suppliers
ON products.supplier_id = suppliers.supplier_id
WHERE units_in_stock = 0 

-- 27=> 1998 yılı mart ayındaki siparişlerimin adresi, siparişi alan çalışanın adı, çalışanın soyadı
SELECT	order_date, ship_address, first_name,last_name from orders o
inner join employees e
on o.employee_id = e.employee_id
WHERE EXTRACT(YEAR FROM o.order_date) = 1998
AND EXTRACT(MONTH FROM o.order_date) = 3

-- 28=> 1997 yılı şubat ayında kaç siparişim var?
Select count(order_date) from orders
where EXTRACT(YEAR FROM order_date)= 1997
AND EXTRACT(MONTH FROM order_date)= 2

-- 29=> London şehrinden 1998 yılında kaç siparişim var?
Select count(order_date)  from orders
where ship_city ='London' AND  EXTRACT(YEAR FROM order_date) = 1998
 
-- 30=> 1997 yılında sipariş veren müşterilerimin contactname ve telefon numarası
Select * from orders 
Select order_date ,contact_name, phone from orders o
inner join customers c
on o.customer_id = c.customer_id
WHERE EXTRACT(YEAR From order_date)= 1997
group by contact_name ,phone ,order_date
 
-- 31=> Taşıma ücreti 40 üzeri olan siparişlerim 
SELECT * FROM orders
WHERE freight > 40

-- 32=> Taşıma ücreti 40 ve üzeri olan siparişlerimin şehri, müşterisinin adı
SELECT  ship_city , contact_name from orders o
inner join customers c
on o.customer_id = c.customer_id
where freight > 40

-- 33=> 1997 yılında verilen siparişlerin tarihi, şehri, çalışan adı -soyadı ( ad soyad birleşik olacak ve büyük harf),
Select order_date , ship_city , CONCAT(first_name ,' ',last_name) as full_name FROM orders o
inner join employees e
on o.employee_id = e.employee_id
WHERE EXTRACT(YEAR FROM order_date)= 1997 

-- 34=> 1997 yılında sipariş veren müşterilerin contactname i, ve telefon numaraları ( telefon formatı 2223322 gibi olmalı )
Select contact_name ,CONCAT(LEFT(phone, 3), SUBSTRING(phone, 4, 3), RIGHT(phone, 4)) AS FormattedPhone from orders o
inner join customers c
on o.customer_id = c.customer_id
WHERE  EXTRACT(YEAR From order_date) = 1997
	
 -- 35=> Sipariş tarihi, müşteri contact name, çalışan ad, çalışan soyad 
SELECT order_date, contact_name, first_name, last_name
FROM orders
INNER JOIN customers ON orders.customer_id = customers.customer_id
INNER JOIN employees ON orders.employee_id = employees.employee_id

-- 36=> Geciken siparişlerim?
SELECT * FROM Orders 
WHERE  order_date < required_date AND shipped_date IS NULL

-- 37=> Geciken siparişlerimin tarihi, müşterisinin adı
Select order_date ,contact_name from orders, o
inner join customers c
on o.customer_id = c.customer_id
where order_date < required_date AND shipped_date IS NULL

-- 38=> 10248 nolu siparişte satılan ürünlerin adı, kategorisinin adı, adedi 
Select order_details.order_id ,products.product_name , categories.category_name , products.quantity_per_unit as adet 
from order_details
INNER JOIN products on order_details.product_id = products.product_id
INNER JOIN categories on products.category_id = categories.category_id
where order_id ='10248'

-- 39=> 10248 nolu siparişin ürünlerinin adı , tedarikçi adı
Select order_id ,product_name , company_name from products p
join order_details od on p.product_id = od.product_id
Join suppliers s on p.supplier_id = s.supplier_id
where order_id = '10248'

-- 40=> 3 numaralı ID ye sahip çalışanın 1997 yılında sattığı ürünlerin adı ve adeti
select product_name, quantity ,From order_details od
inner join products p
on od.product_id = p.product_id
inner join orders o
on od.order_id = o.order_id
WHERE o.employee_id = 3 AND EXTRACT(YEAR FROM o.order_date) = 1997

-- 41=> 1997 yılında bir defasinda en çok satış yapan çalışanımın ID,Ad soyad
SELECT first_name, last_name ,o.employee_id FROM orders o
inner join employees e 
on o.employee_id = e.employee_id
WHERE EXTRACT(YEAR FROM o.order_date) = 1997
GROUP BY o.employee_id, e.first_name, e.last_name
ORDER BY COUNT(*) DESC
LIMIT 1

-- 42=> 1997 yılında en çok satış yapan çalışanımın ID,Ad soyad ****
SELECT  first_name, last_name
FROM (SELECT employee_id, COUNT(*) AS TotalSales
FROM orders WHERE EXTRACT(YEAR FROM order_date) = 1997
GROUP BY employee_id
ORDER BY TotalSales DESC
LIMIT 1) AS MostSales
inner JOIN employees ON MostSales.employee_id = employees.employee_id

-- 43=> En pahalı ürünümün adı,fiyatı ve kategorisin adı nedir?
SELECT product_name, unit_price, category_name FROM products p 
inner join categories c 
on p.category_id = c.category_id
ORDER BY p.unit_price DESC
LIMIT 1

-- 44=> Siparişi alan personelin adı,soyadı, sipariş tarihi, sipariş ID. Sıralama sipariş tarihine göre
SELECT first_name, last_name , order_date, order_id FROM orders o
inner join employees e
on o.employee_id = e.employee_id
ORDER BY order_date
	
-- 45=> SON 5 siparişimin ortalama fiyatı ve orderid nedir?
SELECT AVG(Unit_Price) AS Average_Price, Order_iD
FROM Order_details
GROUP BY Order_ID
ORDER BY Order_ID DESC
LIMIT 5

-- 46=> Ocak ayında satılan ürünlerimin adı ve kategorisinin adı ve toplam satış miktarı nedir?
SELECT p.Product_Name, c.Category_Name, SUM(od.Quantity) AS TotalSales FROM Orders o
INNER JOIN Order_Details od ON o.Order_ID = od.Order_ID
INNER JOIN Products p ON od.Product_ID = p.Product_ID
INNER JOIN Categories c ON p.Category_ID = c.Category_ID
WHERE EXTRACT(MONTH FROM o.Order_Date) = 1
GROUP BY p.Product_Name, c.Category_Name

-- 47=> Ortalama satış miktarımın üzerindeki satışlarım nelerdir? 
SELECT * FROM Order_Details
WHERE Quantity > (SELECT AVG(Quantity) FROM Order_Details)

-- 48=> En çok satılan ürünümün(adet bazında) adı, kategorisinin adı ve tedarikçisinin adı 
SELECT p.Product_Name, c.Category_Name, s.Company_Name FROM Order_Details od
INNER JOIN Products p ON od.Product_ID = p.Product_ID
INNER JOIN Categories c ON p.Category_ID = c.Category_ID
INNER JOIN Suppliers s ON p.Supplier_ID = s.Supplier_ID
GROUP BY p.Product_Name, c.Category_Name, s.Company_Name
ORDER BY SUM(od.Quantity) DESC
LIMIT 1

-- 49=> Kaç ülkeden müşterim var
SELECT COUNT(DISTINCT Country) AS NumberOfCountries
FROM Customers

-- 50=> 3 numaralı ID ye sahip çalışan (employee) son Ocak ayından BUGÜNE toplamda ne kadarlık ürün sattı?
SELECT SUM(od.Quantity) AS TotalSales FROM Orders o
INNER JOIN Order_Details od ON o.Order_ID = od.Order_ID
WHERE o.Employee_ID = 3
AND o.Order_Date >= DATE_TRUNC('month', CURRENT_DATE) - INTERVAL '1 month'
AND o.Order_Date <= CURRENT_DATE

-- 51=> 10248 nolu siparişte satılan ürünlerin adı, kategorisinin adı, adedi 
Select order_details.order_id ,products.product_name , categories.category_name , products.quantity_per_unit as adet 
from order_details
INNER JOIN products on order_details.product_id = products.product_id
INNER JOIN categories on products.category_id = categories.category_id
where order_id ='10248'

-- 52=> 10248 nolu siparişin ürünlerinin adı , tedarikçi adı 
Select order_id ,product_name , company_name from products p
join order_details od on p.product_id = od.product_id
Join suppliers s on p.supplier_id = s.supplier_id
where order_id = '10248'

-- 53=>3 numaralı ID ye sahip çalışanın 1997 yılında sattığı ürünlerin adı ve adeti
select product_name, quantity ,From order_details od
inner join products p
on od.product_id = p.product_id
inner join orders o
on od.order_id = o.order_id
WHERE o.employee_id = 3 AND EXTRACT(YEAR FROM o.order_date) = 1997

-- 54=> 1997 yılında bir defasinda en çok satış yapan çalışanımın ID,Ad soyad
SELECT  first_name, last_name
FROM (SELECT employee_id, COUNT(*) AS TotalSales
  FROM orders WHERE EXTRACT(YEAR FROM order_date) = 1997
  GROUP BY employee_id
  ORDER BY TotalSales DESC
  LIMIT 1
) AS MostSales
inner JOIN employees ON MostSales.employee_id = employees.employee_id

-- 55=> 1997 yılında en çok satış yapan çalışanımın ID,Ad soyad ****
SELECT  first_name, last_name
FROM (SELECT employee_id, COUNT(*) AS TotalSales
FROM orders WHERE EXTRACT(YEAR FROM order_date) = 1997
GROUP BY employee_id
ORDER BY TotalSales DESC LIMIT 1) 
AS MostSales
inner JOIN employees ON MostSales.employee_id = employees.employee_id

-- 56=> En pahalı ürünümün adı,fiyatı ve kategorisin adı nedir?
SELECT product_name, unit_price, category_name FROM products p 
inner join categories c 
on p.category_id = c.category_id
ORDER BY p.unit_price DESC
LIMIT 1

-- 57=> Siparişi alan personelin adı,soyadı, sipariş tarihi, sipariş ID. Sıralama sipariş tarihine göre
SELECT first_name, last_name , order_date, order_id FROM orders o
inner join employees e
on o.employee_id = e.employee_id
ORDER BY order_date

-- 58=> SON 5 siparişimin ortalama fiyatı ve orderid nedir? 
SELECT AVG(od.Unit_Price) AS AveragePrice, o.Order_ID
FROM Orders o
INNER JOIN Order_Details od ON o.Order_ID = od.Order_ID
GROUP BY o.Order_ID
ORDER BY o.Order_ID DESC
LIMIT 5

-- 59=> Ocak ayında satılan ürünlerimin adı ve kategorisinin adı ve toplam satış miktarı nedir?
SELECT p.Product_Name, c.Category_Name, SUM(od.Quantity) AS TotalSales FROM Orders o
INNER JOIN Order_Details od ON o.Order_ID = od.Order_ID
INNER JOIN Products p ON od.Product_ID = p.Product_ID
INNER JOIN Categories c ON p.Category_ID = c.Category_ID
WHERE EXTRACT(MONTH FROM o.Order_Date) = 1
GROUP BY p.Product_Name, c.Category_Name

-- 60=> Ortalama satış miktarımın üzerindeki satışlarım nelerdir? 
WITH AverageSales AS (SELECT AVG(od.Quantity) AS AvgQuantity FROM Order_Details od)
SELECT od.Order_ID, od.Quantity FROM Order_Details od
CROSS JOIN AverageSales
WHERE od.Quantity > (SELECT AvgQuantity FROM AverageSales)

-- 61=> En çok satılan ürünümün(adet bazında) adı, kategorisinin adı ve tedarikçisinin adı 
SELECT p.Product_Name, c.Category_Name, s.Company_Name FROM Order_Details od
INNER JOIN Products p ON od.Product_ID = p.Product_ID
INNER JOIN Categories c ON p.Category_ID = c.Category_ID
INNER JOIN Suppliers s ON p.Supplier_ID = s.Supplier_ID
GROUP BY p.Product_Name, c.Category_Name, s.Company_Name
HAVING SUM(od.Quantity) = (SELECT MAX(total_sales) 
FROM(SELECT SUM(od.Quantity) AS total_sales
FROM Order_Details od
GROUP BY od.Product_ID) AS sales)

-- 62=> Kaç ülkeden müşterim var
SELECT COUNT(DISTINCT Country) AS CustomerCount FROM Customers;

-- 63=> Hangi ülkeden kaç müşterimiz var
SELECT Country, COUNT(*) AS CustomerCount FROM Customers
GROUP BY Country

--64 =>3 numaralı ID ye sahip çalışan (employee) son Ocak ayından BUGÜNE toplamda ne kadarlık ürün sattı?
SELECT SUM(od.Quantity) AS TotalSales FROM Orders o
INNER JOIN Order_Details od ON o.Order_ID = od.Order_ID
WHERE o.Employee_ID = 3
AND o.Order_Date >= DATE_TRUNC('month', CURRENT_DATE) - INTERVAL '1 month'
AND o.Order_Date <= CURRENT_DATE

-- 65=> 10 numaralı ID ye sahip ürünümden son 3 ayda ne kadarlık ciro sağladım?
SELECT SUM(od.Quantity * od.Unit_Price) AS Total_Revenue
FROM Order_Details od
INNER JOIN Orders o ON od.Order_ID = o.Order_ID
WHERE od.Product_ID = 10
AND o.Order_Date >= CURRENT_DATE - INTERVAL '3 months'

-- 66=> Hangi çalışan şimdiye kadar  toplam kaç sipariş almış..?
SELECT e.Employee_ID, CONCAT(e.First_Name, ' ', e.Last_Name) AS full_name, COUNT(*) AS TotalOrders
FROM Employees e
INNER JOIN Orders o ON e.Employee_ID = o.Employee_ID
GROUP BY e.Employee_ID, full_name

-- 67=> 91 müşterim var. Sadece 89’u sipariş vermiş. Sipariş vermeyen 2 kişiyi bulun
SELECT *FROM Customers
WHERE CustomerID NOT IN (SELECT DISTINCT CustomerID FROM Orders)

-- 68=> Brazil’de bulunan müşterilerin Şirket Adı, TemsilciAdi, Adres, Şehir, Ülke bilgileri
Select company_name a, contact_name b ,address c, city d, country e from customers
where country = 'Brazil'
group by a,b,c,d,e

--69=> Brezilya’da olmayan müşteriler
SELECT * FROM customers
WHERE country != 'Brazil'

--70=> Ülkesi (Country) YA Spain, Ya France, Ya da Germany olan müşteriler
Select * from customers
where country in ('Spain','France','Germany')
	
-- 71=> Faks numarasını bilmediğim müşteriler
select * from customers
Where fax is null

-- 72=> Londra’da ya da Paris’de bulunan müşterilerim
Select * from customers
where city in ('London','Paris')
	
-- 73=> Hem Mexico D.F’da ikamet eden HEM DE ContactTitle bilgisi ‘owner’ olan müşteriler
Select * from customers 
where city ='México D.F.' and contact_title ='Owner'

-- 74=> C ile başlayan ürünlerimin isimleri ve fiyatları
Select product_name,unit_price from products 
WHERE product_name LIKE 'C%'
GROUP BY product_name , unit_price

-- 75=> Adı (FirstName) ‘A’ harfiyle başlayan çalışanların (Employees); Ad, Soyad ve Doğum Tarihleri
Select first_name, last_name,birth_date from employees 
WHERE first_name LIKE 'A%'
GROUP BY first_name, last_name,birth_date

-- 76=> İsminde ‘RESTAURANT’ geçen müşterilerimin şirket adları
SELECT * FROM customers
WHERE company_name LIKE '%RESTAURANT%'

-- 77=> 50$ ile 100$ arasında bulunan tüm ürünlerin adları ve fiyatları
SELECT product_name , unit_price FROM products 
where unit_price >= 50 AND unit_price <= 100


-- 78=> 1 temmuz 1996 ile 31 Aralık 1996 tarihleri arasındaki siparişlerin (Orders), SiparişID (OrderID) ve SiparişTarihi (OrderDate) bilgileri
SELECT order_id, order_date FROM orders
WHERE order_date >= '1996-07-01' AND order_date <= '1996-12-31'

-- 79=> Ülkesi (Country) YA Spain, Ya France, Ya da Germany olan müşteriler
Select * from customers
where country in ('Spain','France','Germany')

-- 80 =>Faks numarasını bilmediğim müşteriler
select * from customers
Where fax is null