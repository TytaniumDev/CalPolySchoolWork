----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    15:22:59 05/13/2009 
-- Design Name: 
-- Module Name:    Exp6 - Behavioral 
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

entity Exp6 is
    Port ( R17 : in  STD_LOGIC;
           N17 : in  STD_LOGIC;
           L13 : in  STD_LOGIC;
           L14 : in  STD_LOGIC;
           Display : out  STD_LOGIC_VECTOR(6 downto 0);
			  A0 : out  STD_LOGIC;
			  A1 : out  STD_LOGIC;
			  A2 : out  STD_LOGIC;
			  A3 : out  STD_LOGIC;
           DP : out  STD_LOGIC);
end Exp6;

architecture Behavioral of Exp6 is
	signal input : STD_LOGIC_VECTOR(3 downto 0);
begin
	input <= (R17 & N17 & L13 & L14);

	display <= "0000001" when input = "0000" else
				  "1001111" when input = "0001" else
				  "0010010" when input = "0010" else
				  "0000110" when input = "0011" else
				  "1001100" when input = "0100" else
				  "0100100" when input = "0101" else
				  "0100000" when input = "0110" else
				  "0001111" when input = "0111" else
				  "0000000" when input = "1000" else
				  "0000100" when input = "1001" else
				  "1111111";

	A0 <= '1';
	A1 <= '1';
	A2 <= '1';
	A3 <= '0';
	DP <= '1';
end Behavioral;

