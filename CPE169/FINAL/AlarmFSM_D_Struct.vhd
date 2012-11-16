----------------------------------------------------------------------------------
-- Company: Cal Poly State Univ
-- Engineer: Wayne Pilkington
-- 
-- Create Date:    09:20:20 11/26/2006 
-- Design Name: 
-- Module Name:    AlarmFSM_D_Struct 
-- Project Name: 	AlarmSystem
-- Target Devices: 
-- Tool versions: 
-- Description:   Structural Model of Alarm FSM using D Flip-Flops
-- Revision: 
-- Revision 0.01 - File Created
-- Additional Comments: 
--
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;


entity AlarmFSM is
    Port ( Break_In : in  STD_LOGIC;
           Sys_On_L : in  STD_LOGIC;
			  Clock : in  STD_LOGIC;
           Sys_Armed : out  STD_LOGIC;
           Alarm : out  STD_LOGIC);
end AlarmFSM;


-- USING A STRUCTURAL MODEL OF THE ALARM CONTROL STATE MACHINE --
architecture AlarmFSM_D_Struct of AlarmFSM is

-- D Flip Flops Are Used to Implement the Finite State Machine --
component D_FF is
Port ( D : in  STD_LOGIC;
           Clk : in  STD_LOGIC;
           Q : out  STD_LOGIC;
           Qnot : out  STD_LOGIC);
end component D_FF;

-- Define Inputs/Outputs of 2 D Flip-Flops for interconnection
signal D0, D1, Q0, Q0not, Q1, Q1not : STD_LOGIC;

begin

-- D Flip-Flop Instantiations --
D1_ff:	D_FF  port map (D1, Clock, Q1, Q1not); 
D0_ff:	D_FF  port map (D0, Clock, Q0, OPEN); -- NOTE: "OPEN" used if not connected to anything

-- Excitation Combinational Logic --
D1 <= ((Q1 OR Break_In) AND (NOT( Sys_On_L)) AND Q0); 
D0 <= ((Q0 OR Q1not) AND (NOT( Sys_On_L))); 

-- Output Logic --
Alarm <= Q1 AND Q0;
Sys_Armed <= Q1 XOR Q0;



end AlarmFSM_D_Struct;

