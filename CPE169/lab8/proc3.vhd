----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    16:45:13 05/27/2009 
-- Design Name: 
-- Module Name:    proc3 - Behavioral 
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

entity proc3 is
    Port ( SW : in  STD_LOGIC;
           CLK : in  STD_LOGIC;
           CACG : out  STD_LOGIC_VECTOR(6 downto 0);
           AN : out  STD_LOGIC_VECTOR(3 downto 0);
           DP : out  STD_LOGIC);
end proc3;

architecture Behavioral of proc3 is
component proc2 is
    Port ( EN : in  STD_LOGIC;
           CLK : in  STD_LOGIC;
           b0 : out  STD_LOGIC;
           b1 : out  STD_LOGIC;
           b2 : out  STD_LOGIC;
           b3 : out  STD_LOGIC);
end component;

component BCDto7 is 
    Port ( A0 : out  STD_LOGIC;
			  A1 : out  STD_LOGIC;
			  A2 : out  STD_LOGIC;
			  A3 : out  STD_LOGIC;
			   DP : out  STD_LOGIC;
			  Y : inout  STD_LOGIC_VECTOR (3 downto 0);
           display : out  STD_LOGIC_VECTOR(6 downto 0));
end component;

signal b0, b1, b2, b3 : std_logic;
signal finalthing : std_logic_vector(3 downto 0);
begin

Counter : proc2
	port map(SW, CLK, b0, b1, b2, b3);

finalthing <= (b0, b1, b2, b3);
to7seg : BCDto7
	port map(AN(0), AN(1), AN(2), AN(3), DP, finalthing, CACG);

end Behavioral;

