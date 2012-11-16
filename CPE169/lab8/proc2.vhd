----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    16:01:58 05/27/2009 
-- Design Name: 
-- Module Name:    proc2 - Behavioral 
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

entity proc2 is
    Port ( EN : in  STD_LOGIC;
           CLK : in  STD_LOGIC;
           b0 : out  STD_LOGIC;
           b1 : out  STD_LOGIC;
           b2 : out  STD_LOGIC;
           b3 : out  STD_LOGIC);
end proc2;

architecture Behavioral of proc2 is

component tflipflop is
	port(EN : in std_logic;
			T: in std_logic;
			CLK : in std_logic;
			Q : out std_logic);
end component;
signal Tin : std_logic := '1';
signal out0, out1, out2 : std_logic;
begin

C1 : tflipflop
	port map(EN, Tin, CLK, out0);
C2 : tflipflop
	port map(EN, Tin, out0, out1);
C3 : tflipflop
	port map(EN, Tin, out1, out2);

b0 <= NOT CLK;
b1 <= NOT out0;
b2 <= NOT out1;
b3 <= NOT out2;

end Behavioral;

