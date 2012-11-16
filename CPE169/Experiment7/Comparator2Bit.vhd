----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    17:15:12 05/20/2009 
-- Design Name: 
-- Module Name:    Comparator2Bit - Behavioral 
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

entity Comparator2Bit is
	Port(A: in STD_LOGIC_VECTOR(1 downto 0);
			B: in STD_LOGIC_VECTOR(1 downto 0);
			AeqB : out STD_LOGIC);
end Comparator2Bit;

architecture Behavioral of Comparator2Bit is

begin

AeqB <= ( A(1) XNOR B(1)) AND ( A(0) XNOR B(0));

end Behavioral;

