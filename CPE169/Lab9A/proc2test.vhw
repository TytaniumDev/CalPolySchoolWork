--------------------------------------------------------------------------------
-- Copyright (c) 1995-2003 Xilinx, Inc.
-- All Right Reserved.
--------------------------------------------------------------------------------
--   ____  ____ 
--  /   /\/   / 
-- /___/  \  /    Vendor: Xilinx 
-- \   \   \/     Version : 9.1.03i
--  \   \         Application : ISE
--  /   /         Filename : Proc2test.vhw
-- /___/   /\     Timestamp : Tue Jun 02 16:30:01 2009
-- \   \  /  \ 
--  \___\/\___\ 
--
--Command: 
--Design Name: Proc2test
--Device: Xilinx
--

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
USE IEEE.STD_LOGIC_TEXTIO.ALL;
USE STD.TEXTIO.ALL;

ENTITY Proc2test IS
END Proc2test;

ARCHITECTURE testbench_arch OF Proc2test IS
    FILE RESULTS: TEXT OPEN WRITE_MODE IS "results.txt";

    COMPONENT AlarmFSM
        PORT (
            Break_In : In std_logic;
            Sys_On_L : In std_logic;
            Clock : In std_logic;
            Sys_Armed : Out std_logic;
            Alarm : Out std_logic
        );
    END COMPONENT;

    SIGNAL Break_In : std_logic := '0';
    SIGNAL Sys_On_L : std_logic := '0';
    SIGNAL Clock : std_logic := '0';
    SIGNAL Sys_Armed : std_logic := '0';
    SIGNAL Alarm : std_logic := '0';

    constant PERIOD : time := 200 ns;
    constant DUTY_CYCLE : real := 0.5;
    constant OFFSET : time := 100 ns;

    BEGIN
        UUT : AlarmFSM
        PORT MAP (
            Break_In => Break_In,
            Sys_On_L => Sys_On_L,
            Clock => Clock,
            Sys_Armed => Sys_Armed,
            Alarm => Alarm
        );

        PROCESS    -- clock process for Clock
        BEGIN
            WAIT for OFFSET;
            CLOCK_LOOP : LOOP
                Clock <= '0';
                WAIT FOR (PERIOD - (PERIOD * DUTY_CYCLE));
                Clock <= '1';
                WAIT FOR (PERIOD * DUTY_CYCLE);
            END LOOP CLOCK_LOOP;
        END PROCESS;

        PROCESS
            BEGIN
                -- -------------  Current Time:  585ns
                WAIT FOR 585 ns;
                Sys_On_L <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  985ns
                WAIT FOR 400 ns;
                Break_In <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  1385ns
                WAIT FOR 400 ns;
                Break_In <= '0';
                -- -------------------------------------
                -- -------------  Current Time:  1785ns
                WAIT FOR 400 ns;
                Sys_On_L <= '0';
                -- -------------------------------------
                -- -------------  Current Time:  2385ns
                WAIT FOR 600 ns;
                Sys_On_L <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  2785ns
                WAIT FOR 400 ns;
                Sys_On_L <= '0';
                -- -------------------------------------
                -- -------------  Current Time:  2985ns
                WAIT FOR 200 ns;
                Break_In <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  3185ns
                WAIT FOR 200 ns;
                Sys_On_L <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  3585ns
                WAIT FOR 400 ns;
                Break_In <= '0';
                Sys_On_L <= '0';
                -- -------------------------------------
                -- -------------  Current Time:  3985ns
                WAIT FOR 400 ns;
                Break_In <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  4385ns
                WAIT FOR 400 ns;
                Break_In <= '0';
                -- -------------------------------------
                -- -------------  Current Time:  4585ns
                WAIT FOR 200 ns;
                Sys_On_L <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  4985ns
                WAIT FOR 400 ns;
                Sys_On_L <= '0';
                -- -------------------------------------
                -- -------------  Current Time:  5385ns
                WAIT FOR 400 ns;
                Break_In <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  5785ns
                WAIT FOR 400 ns;
                Break_In <= '0';
                -- -------------------------------------
                -- -------------  Current Time:  6185ns
                WAIT FOR 400 ns;
                Break_In <= '1';
                Sys_On_L <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  6585ns
                WAIT FOR 400 ns;
                Break_In <= '0';
                Sys_On_L <= '0';
                -- -------------------------------------
                WAIT FOR 93615 ns;

            END PROCESS;

    END testbench_arch;

