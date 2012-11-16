-- clear_recipe.sql
-- This script clears all the tables in the recipe database 
-- but does not delete the tables themselves
-- summer 2009, M. Liu
delete from contains;
delete from recipe;
delete from ingredient;
-----------------------------------------------------------------
