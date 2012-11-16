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

entity final is
    Port ( I : in  STD_LOGIC_VECTOR(7 downto 0);
			  STROBE : out STD_LOGIC;
			  A0 : out  STD_LOGIC;
			  A1 : out  STD_LOGIC;
			  A2 : out  STD_LOGIC;
			  A3 : out  STD_LOGIC;
           DP : out  STD_LOGIC;
			  Y : inout  STD_LOGIC_VECTOR (2 downto 0);
           display : out  STD_LOGIC_VECTOR(6 downto 0));
end final;

architecture Behavioral of final is

begin

	test:process (I) is
	begin
	
		if(I(7) = '1') then Y <= "111";
		elsif(I(6) = '1') then Y <= "110";
		elsif(I(5) = '1') then Y <= "101";
		elsif(I(4) = '1') then Y <= "100";
		elsif(I(3) = '1') then Y <= "011";
		elsif(I(2) = '1') then Y <= "010";
		elsif(I(1) = '1') then Y <= "001";
		elsif(I(0) = '1') then Y <= "000";
		else Y <= "000";
		end if;
	
		if(I = "00000000") then STROBE <= '0';
		else STROBE <= '1';
		end if;
		
	end process test;
	
	display <= "0000001" when Y = "000" else
				  "1001111" when Y = "001" else
				  "0010010" when Y = "010" else
				  "0000110" when Y = "011" else
				  "1001100" when Y = "100" else
				  "0100100" when Y = "101" else
				  "0100000" when Y = "110" else
				  "0001111" when Y = "111" else
				  "1111111";

	A0 <= '1';
	A1 <= '1';
	A2 <= '1';
	A3 <= '0';
	DP <= '1';

end Behavioral;

