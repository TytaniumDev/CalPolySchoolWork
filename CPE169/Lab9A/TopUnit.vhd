----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    16:45:27 06/02/2009 
-- Design Name: 
-- Module Name:    TopUnit - Behavioral 
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

entity TopUnit is
    Port ( Btns : in  STD_LOGIC_VECTOR (3 downto 0);
           UserCode : in  STD_LOGIC_VECTOR (3 downto 0);
           Cs : out  STD_LOGIC_VECTOR (6 downto 0);
           AN : out  STD_LOGIC_VECTOR (3 downto 0);
           DP : out  STD_LOGIC;
           SYS_ARMED : out  STD_LOGIC;
           ALARM : out  STD_LOGIC;
			  MCLK : in STD_LOGIC);
end TopUnit;

architecture Behavioral of TopUnit is

component BCDto7 is
    Port ( A0 : out  STD_LOGIC;
			  A1 : out  STD_LOGIC;
			  A2 : out  STD_LOGIC;
			  A3 : out  STD_LOGIC;
           DP : out  STD_LOGIC;
			  Y : in  STD_LOGIC_VECTOR (3 downto 0);
           display : out  STD_LOGIC_VECTOR(6 downto 0));
end component;

component encoder is
    Port ( I : in  STD_LOGIC_VECTOR (7 downto 0);
           Y : out  STD_LOGIC_VECTOR (2 downto 0);
           STROBE : out  STD_LOGIC);
end component;

component Procedure4 is --Comparator
	Port( A : in STD_LOGIC_VECTOR(3 downto 0);
			B: in STD_LOGIC_VECTOR(3 downto 0);
			A_equals_B : out STD_LOGIC);
end component;

component AlarmFSM is
    Port ( Break_In : in  STD_LOGIC;
           Sys_On_L : in  STD_LOGIC;
			  Clock : in  STD_LOGIC;
           Sys_Armed : out  STD_LOGIC;
           Alarm : out  STD_LOGIC);
end component;

signal strobeout :std_logic; --encoder output
signal encoderout : std_logic_vector(3 downto 0); --encoder output
signal equal : std_logic; --comparator output
signal encoderinI : std_logic_vector(7 downto 0);
signal AccessCode : std_logic_vector(3 downto 0);

begin

encoderout(3) <= '0';
encoderinI <= ('0', '0', '0', Btns(3), Btns(2), Btns(1), Btns(0), '0');
AccessCode <= ('0', '1', '0', '1');
PriorityEnc : encoder
	port map (encoderinI(7 downto 0), encoderout(2 downto 0), strobeout);

BCDto7dec : BCDto7
	port map (AN(0), AN(1), AN(2), AN(3), DP, encoderout(3 downto 0), Cs(6 downto 0));

comparator : Procedure4
	port map (UserCode(3 downto 0), AccessCode(3 downto 0), equal);
	
AlarmFSMthing : AlarmFSM
	port map (strobeout, equal, MCLK, Sys_armed, Alarm);

end Behavioral;

