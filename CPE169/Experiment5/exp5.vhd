----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    16:07:13 05/06/2009 
-- Design Name: 
-- Module Name:    exp5 - Behavioral 
-- Project Name: 
-- Target Devices: 
-- Tool versions: 
-- Description: 
--
-- Dependencies: 
--
-- Revision: 
-- Revision 0.01 - File Created
-- Additional Comments: 
--
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

---- Uncomment the following library declaration if instantiating
---- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity exp5 is
    Port ( A : in  STD_LOGIC;
           B : in  STD_LOGIC;
           C : in  STD_LOGIC;
           D : in  STD_LOGIC;
           F1 : out  STD_LOGIC;
           F2 : out  STD_LOGIC);
end exp5;

architecture Behavioral of exp5 is
begin
	F1 <= (((NOT A) AND (NOT B) AND (NOT D)) OR (A AND D));
	F2 <= (((NOT A) AND C AND D) OR (B AND C AND (NOT D)) OR (B AND (NOT C) AND D) OR (A AND (NOT B) AND (NOT D)));
end Behavioral;

