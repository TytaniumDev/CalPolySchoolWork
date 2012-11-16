----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    17:09:13 05/20/2009 
-- Design Name: 
-- Module Name:    Procedure4 - Behavioral 
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

entity Procedure4 is
	Port(A : in STD_LOGIC_VECTOR(3 downto 0);
			B: in STD_LOGIC_VECTOR(3 downto 0);
			A_equals_B : out STD_LOGIC);
end Procedure4;

architecture Behavioral of Procedure4 is

component Comparator2Bit is
	Port(A : in STD_LOGIC_VECTOR(1 downto 0);
			B : in STD_LOGIC_VECTOR(1 downto 0);
			AeqB : out STD_LOGIC);
end component;

signal upper_AeqB, lower_AeqB : std_logic;

begin

upper_comp : Comparator2Bit
	port map(A(3 downto 2), B(3 downto 2), upper_AeqB);
	
lower_comp : Comparator2Bit
	port map(A(1 downto 0), B(1 downto 0), lower_AeqB);

A_equals_B <= upper_AeqB AND lower_AeqB;

end Behavioral;

