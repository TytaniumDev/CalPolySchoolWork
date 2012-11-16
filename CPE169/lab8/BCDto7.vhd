----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    18:14:19 05/13/2009 
-- Design Name: 
-- Module Name:    final - Behavioral 
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

entity BCDto7 is
    Port ( A0 : out  STD_LOGIC;
			  A1 : out  STD_LOGIC;
			  A2 : out  STD_LOGIC;
			  A3 : out  STD_LOGIC;
           DP : out  STD_LOGIC;
			  Y : inout  STD_LOGIC_VECTOR (3 downto 0);
           display : out  STD_LOGIC_VECTOR(6 downto 0));
end BCDto7;

architecture Behavioral of BCDto7 is

begin
	display <= "0000001" when Y = "0000" else
				  "1001111" when Y = "0001" else
				  "0010010" when Y = "0010" else
				  "0000110" when Y = "0011" else
				  "1001100" when Y = "0100" else
				  "0100100" when Y = "0101" else
				  "0100000" when Y = "0110" else
				  "0001111" when Y = "0111" else
				  "0000000" when Y = "1000" else
				  "0001100" when Y = "1001" else
				  "1111111";

	A0 <= '1';
	A1 <= '1';
	A2 <= '1';
	A3 <= '0';
	DP <= '1';

end Behavioral;

