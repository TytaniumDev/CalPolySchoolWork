----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    15:47:25 05/20/2009 
-- Design Name: 
-- Module Name:    Procedure3 - Behavioral 
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

entity Procedure3 is
    Port ( A : in  STD_LOGIC_VECTOR (3 downto 0);
           B : in  STD_LOGIC_VECTOR (3 downto 0);
           Sum : out  STD_LOGIC_VECTOR (3 downto 0);
           CarryOut : out  STD_LOGIC);
end Procedure3;

architecture Behavioral of Procedure3 is
component HalfAdder is
	    Port ( A : in  STD_LOGIC;
           B : in  STD_LOGIC;
           Sum : out  STD_LOGIC;
           Carry : out  STD_LOGIC);
end component;

component FullAdder is
    Port ( A : in  STD_LOGIC;
           B : in  STD_LOGIC;
           CarryIn : in  STD_LOGIC;
           Sum : out  STD_LOGIC;
           Carry : out  STD_LOGIC);
end component;

signal C1, C2, C3 : STD_LOGIC;

begin

H1 : HalfAdder
	port map (A(0), B(0), Sum(0), C1);
	
F1 : FullAdder
	port map (A(1), B(1), C1, Sum(1), C2); 
	
F2 : FullAdder
	port map (A(2), B(2), C2, Sum(2), C3);

F3 : FullAdder
	port map (A(3), B(3), C3, Sum(3), CarryOut);
	
end Behavioral;

