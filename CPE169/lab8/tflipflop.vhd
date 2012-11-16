----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    15:13:50 05/27/2009 
-- Design Name: 
-- Module Name:    tflipflop - Behavioral 
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

entity tflipflop is
    Port ( EN : in  STD_LOGIC;
           T : in  STD_LOGIC;
           CLK : in  STD_LOGIC;
           Q : out  STD_LOGIC);
end tflipflop;

architecture Behavioral of tflipflop is
signal carry : std_logic;
begin

tff : process(EN, CLK, carry)
	begin
		if(EN = '1') then
			if (rising_edge(CLK)) then
				if(T = '1')then
					carry <= carry XOR T;
				end if;
			end if;
		else carry <= '0';
		end if;
end process tff;

Q <= carry;

end Behavioral;

