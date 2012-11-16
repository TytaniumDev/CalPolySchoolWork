----------------------------------------------------------------------------------
-- Company: Cal Poly State Univ.
-- Engineer: Wayne C. Pilkington
-- 
-- Create Date:    09:10:33 11/26/2006 
-- Design Name: 
-- Module Name:    D_FF - Behavioral 
-- Project Name: 
-- Target Devices: 
-- Tool versions: 
-- Description:    Behavioral Model of a D Flip Flop
--                   with Q and Qnot outputs (no Set/Reset)
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


entity D_FF is
    Port ( D : in  STD_LOGIC;
           Clk : in  STD_LOGIC;
           Q : out  STD_LOGIC;
           Qnot : out  STD_LOGIC);
end D_FF;

architecture Behavioral of D_FF is

begin
dff:  process (CLK)
      begin
         if (rising_edge(CLK)) then 
            Q <= D; 
				Qnot <= not(D); 
         end if; 
      end process dff; 


end Behavioral;

