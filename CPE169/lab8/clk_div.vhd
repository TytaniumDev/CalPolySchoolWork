----------------------------------------------------------------------------------
-- Company: 
-- Engineer: bryan mealy
-- 
-- Create Date:    09:10:43 09/23/2006 
-- Design Name:  clock divider
-- Module Name:    clk_div - clk_div 
-- Project Name: 
-- Target Devices: Nexys board
-- Tool versions: 
-- Description: This is a generic clock divider. 
--
-- Dependencies: 
--
-- Revision: 
-- Revision 0.01 - File Created
--      09-15-07: Converted for use with 25 MHz clock setting (was 100 MHz) -WCP
--      03-01-08: Converted for use with 50 MHz clock setting (Nexys 1 or 2) -WCP
-- Additional Comments: 
--
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;


entity clk_div is
    Port ( CLK : in  STD_LOGIC;
           SCLK : out  STD_LOGIC);
end clk_div;

architecture clk_div of clk_div is

   signal clkdiv  : std_logic_vector(23 downto 0);
	
begin

	-- Divide the master clock (50 MHz) down to a lower frequency.
	process (CLK)
		begin
			if (rising_edge(CLK)) then
				clkdiv <= clkdiv + 1;
			end if;
		end process;

	SCLK <= clkdiv(23);

end clk_div;

