
--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   17:27:48 05/13/2009
-- Design Name:   encoder
-- Module Name:   E:/CPE169/Experiment6/Exp6/encodertest.vhd
-- Project Name:  Exp6
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: encoder
--
-- Dependencies:
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
--
-- Notes: 
-- This testbench has been automatically generated using types std_logic and
-- std_logic_vector for the ports of the unit under test.  Xilinx recommends 
-- that these types always be used for the top-level I/O of a design in order 
-- to guarantee that the testbench will bind correctly to the post-implementation 
-- simulation model.
--------------------------------------------------------------------------------
LIBRARY ieee;
USE ieee.std_logic_1164.ALL;
USE ieee.std_logic_unsigned.all;
USE ieee.numeric_std.ALL;

ENTITY encodertest_vhd IS
END encodertest_vhd;

ARCHITECTURE behavior OF encodertest_vhd IS 

	-- Component Declaration for the Unit Under Test (UUT)
	COMPONENT encoder
	PORT(
		I : IN std_logic_vector(7 downto 0);          
		Y : OUT std_logic_vector(2 downto 0);
		STROBE : OUT std_logic
		);
	END COMPONENT;

	--Inputs
	SIGNAL I :  std_logic_vector(7 downto 0) := (others=>'0');

	--Outputs
	SIGNAL Y :  std_logic_vector(2 downto 0);
	SIGNAL STROBE :  std_logic;

BEGIN

	-- Instantiate the Unit Under Test (UUT)
	uut: encoder PORT MAP(
		I => I,
		Y => Y,
		STROBE => STROBE
	);

	tb : PROCESS
	BEGIN

		-- Wait 100 ns for global reset to finish
		wait for 100 ns;

		-- Place stimulus here

		wait; -- will wait forever
	END PROCESS;

END;
