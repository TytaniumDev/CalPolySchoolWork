----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    17:13:13 05/13/2009 
-- Design Name: 
-- Module Name:    encoder - Behavioral 
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

entity encoder is
    Port ( I : in  STD_LOGIC_VECTOR (7 downto 0);
           Y : out  STD_LOGIC_VECTOR (2 downto 0);
           STROBE : out  STD_LOGIC);
end encoder;

architecture Behavioral of encoder is

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
	
end Behavioral;

