--------------------------------------------------------------------------------
-- Copyright (c) 1995-2003 Xilinx, Inc.
-- All Right Reserved.
--------------------------------------------------------------------------------
--   ____  ____ 
--  /   /\/   / 
-- /___/  \  /    Vendor: Xilinx 
-- \   \   \/     Version : 9.1.03i
--  \   \         Application : ISE
--  /   /         Filename : proc3test.vhw
-- /___/   /\     Timestamp : Wed May 27 17:35:14 2009
-- \   \  /  \ 
--  \___\/\___\ 
--
--Command: 
--Design Name: proc3test
--Device: Xilinx
--

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
USE IEEE.STD_LOGIC_TEXTIO.ALL;
USE STD.TEXTIO.ALL;

ENTITY proc3test IS
END proc3test;

ARCHITECTURE testbench_arch OF proc3test IS
    FILE RESULTS: TEXT OPEN WRITE_MODE IS "results.txt";

    COMPONENT proc3
        PORT (
            SW : In std_logic;
            CLK : In std_logic;
            CACG : Out std_logic_vector (6 DownTo 0);
            AN : Out std_logic_vector (3 DownTo 0);
            DP : Out std_logic
        );
    END COMPONENT;

    SIGNAL SW : std_logic := '0';
    SIGNAL CLK : std_logic := '0';
    SIGNAL CACG : std_logic_vector (6 DownTo 0) := "0000000";
    SIGNAL AN : std_logic_vector (3 DownTo 0) := "0000";
    SIGNAL DP : std_logic := '0';

    constant PERIOD : time := 200 ns;
    constant DUTY_CYCLE : real := 0.5;
    constant OFFSET : time := 100 ns;

    BEGIN
        UUT : proc3
        PORT MAP (
            SW => SW,
            CLK => CLK,
            CACG => CACG,
            AN => AN,
            DP => DP
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
                -- -------------  Current Time:  185ns
                WAIT FOR 185 ns;
                SW <= '1';
                -- -------------------------------------
                WAIT FOR 10015 ns;

            END PROCESS;

    END testbench_arch;

