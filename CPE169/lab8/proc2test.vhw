--------------------------------------------------------------------------------
-- Copyright (c) 1995-2003 Xilinx, Inc.
-- All Right Reserved.
--------------------------------------------------------------------------------
--   ____  ____ 
--  /   /\/   / 
-- /___/  \  /    Vendor: Xilinx 
-- \   \   \/     Version : 9.1.03i
--  \   \         Application : ISE
--  /   /         Filename : proc2test.vhw
-- /___/   /\     Timestamp : Wed May 27 16:24:48 2009
-- \   \  /  \ 
--  \___\/\___\ 
--
--Command: 
--Design Name: proc2test
--Device: Xilinx
--

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
USE IEEE.STD_LOGIC_TEXTIO.ALL;
USE STD.TEXTIO.ALL;

ENTITY proc2test IS
END proc2test;

ARCHITECTURE testbench_arch OF proc2test IS
    FILE RESULTS: TEXT OPEN WRITE_MODE IS "results.txt";

    COMPONENT proc2
        PORT (
            EN : In std_logic;
            CLK : In std_logic;
            b0 : Out std_logic;
            b1 : Out std_logic;
            b2 : Out std_logic;
            b3 : Out std_logic
        );
    END COMPONENT;

    SIGNAL EN : std_logic := '0';
    SIGNAL CLK : std_logic := '0';
    SIGNAL b0 : std_logic := '0';
    SIGNAL b1 : std_logic := '0';
    SIGNAL b2 : std_logic := '0';
    SIGNAL b3 : std_logic := '0';

    constant PERIOD : time := 200 ns;
    constant DUTY_CYCLE : real := 0.5;
    constant OFFSET : time := 200 ns;

    BEGIN
        UUT : proc2
        PORT MAP (
            EN => EN,
            CLK => CLK,
            b0 => b0,
            b1 => b1,
            b2 => b2,
            b3 => b3
        );

        PROCESS    -- clock process for CLK
        BEGIN
            WAIT for OFFSET;
            CLOCK_LOOP : LOOP
                CLK <= '0';
                WAIT FOR (PERIOD - (PERIOD * DUTY_CYCLE));
                CLK <= '1';
                WAIT FOR (PERIOD * DUTY_CYCLE);
            END LOOP CLOCK_LOOP;
        END PROCESS;

        PROCESS
            BEGIN
                -- -------------  Current Time:  285ns
                WAIT FOR 285 ns;
                EN <= '1';
                -- -------------------------------------
                WAIT FOR 49915 ns;

            END PROCESS;

    END testbench_arch;

