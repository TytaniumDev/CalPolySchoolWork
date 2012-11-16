---------------------------------------------------------------
-- insert_recipe.sql -- Recipe Database: Populate tables with data 
-- NOTE: This database is for educational purpose; the accuracy of the data 
--       should not be assumed.
-- Created by M. Liu,  Fall 2010
---------------------------------------------------------------
insert into recipe values
  ('Fried Cheese', 'appetizer', 6.50, 10);
insert into recipe values
  ('Hummus', 'appetizer', 4.55, 20);
insert into recipe values
  ('Garlic Shrimp', 'entree', 17.5, 4);
insert into recipe values
  ('Meatloaf', 'entree', 12.0, 2);
insert into recipe values
  ('Butter Cookies', 'dessert', 5.0, 6);
insert into recipe values
  ('Apple Treat', 'dessert', 5.5, 2);
--------------------------------------
insert into ingredient values
  ('flour','starch', .05, 400);
insert into ingredient values
  ('paprika','seasoning', 0.5, 0);
insert into ingredient values
  ('milk','dairy', .45, 150);
insert into ingredient values
  ('cheese','dairy', .65, 500);
insert into ingredient values
  ('butter','dairy', .75, 100);
insert into ingredient values
  ('egg','dairy', 0.2, 90);
insert into ingredient values
  ('bread crumbs','starch', 0.35, 390);
insert into ingredient values
  ('oregano','herb', 0.5, 0);
insert into ingredient values
  ('olive oil','oil', 1.2, 191);
insert into ingredient values
  ('garbanzo beans','legume', 1.25, 300);
insert into ingredient values
  ('seasame seeds', 'seasoning', 2.0, 45);
insert into ingredient values
  ('garlic','seasoning', 0.6, 10);
insert into ingredient values
  ('sugar','seasoning', 1.0, 770);
insert into ingredient values
  ('lemon juice','seasoning', .35, 5);
insert into ingredient values
  ('shrimp','seafood', 2.5, 400);
insert into ingredient values
  ('salt','seasoning', 0.05, 0);
insert into ingredient values
  ('pepper','seasoning', 0.5, 0);
insert into ingredient values
  ('parsley','herb', 0.8, 2);
insert into ingredient values
  ('almonds','seasoning', 0.5, 795);
insert into ingredient values
  ('ground beef', 'protein', 1.5, 250);
insert into ingredient values
  ('onion', 'seasoning', 0.2, 50);
insert into ingredient values
  ('bread', 'starch', 0.25, 100);
insert into ingredient values
  ('tomato sauce', 'seasoning', 0.85, 75);
insert into ingredient values
  ('apple sauce','seasoning', 1.25, 150);
---------------------------------------
insert into contains values
  ('Fried Cheese', 'flour', 3);
insert into contains values
  ('Fried Cheese', 'paprika', 1);
insert into contains values
  ('Fried Cheese', 'cheese', .5);
insert into contains values
  ('Fried Cheese', 'egg', 2);
insert into contains values
  ('Fried Cheese', 'bread crumbs', 0.5);
insert into contains values
  ('Fried Cheese', 'oregano', 1);
insert into contains values
  ('Fried Cheese', 'olive oil', 2);

insert into contains values
  ('Hummus', 'garbanzo beans', 1);
insert into contains values
  ('Hummus', 'lemon juice', 0.25);
insert into contains values
  ('Hummus', 'seasame seeds', 0.25);
insert into contains values
  ('Hummus', 'garlic', 2);
insert into contains values
  ('Hummus', 'salt', .75);
insert into contains values
  ('Hummus', 'pepper', .5);
insert into contains values
  ('Hummus', 'paprika', .5);
insert into contains values
  ('Hummus', 'olive oil', 4);

insert into contains values
  ('Garlic Shrimp', 'shrimp', .75);
insert into contains values
  ('Garlic Shrimp', 'olive oil', 1);
insert into contains values
  ('Garlic Shrimp', 'parsley', 1);
insert into contains values
  ('Garlic Shrimp', 'lemon juice', 1);
insert into contains values
  ('Garlic Shrimp', 'garlic', 7);
insert into contains values
  ('Garlic Shrimp', 'salt', .5);
insert into contains values
  ('Garlic Shrimp', 'pepper', .125);

insert into contains values
  ('Meatloaf', 'ground beef', 2);
insert into contains values
  ('Meatloaf', 'onion',1);
insert into contains values
  ('Meatloaf', 'egg', 2);
insert into contains values
  ('Meatloaf', 'bread', 3);
insert into contains values
  ('Meatloaf', 'salt', .5);
insert into contains values
  ('Meatloaf', 'pepper', .25);

insert into contains values
  ('Butter Cookies', 'butter', 4);
insert into contains values
  ('Butter Cookies', 'sugar', .25);
insert into contains values
  ('Butter Cookies', 'flour', 4);
insert into contains values
  ('Butter Cookies', 'almonds', 3);

insert into contains values
  ('Apple Treat', 'bread', 4);
insert into contains values
  ('Apple Treat', 'apple sauce', 1);
insert into contains values
  ('Apple Treat', 'egg', 2);
insert into contains values
  ('Apple Treat', 'milk', 1);
insert into contains values
  ('Apple Treat', 'sugar', .5);
insert into contains values
  ('Apple Treat', 'salt', .5);

--------------------------------------



