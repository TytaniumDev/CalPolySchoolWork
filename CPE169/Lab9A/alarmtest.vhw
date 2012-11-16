--------------------------------------------------------------------------------
-- Copyright (c) 1995-2003 Xilinx, Inc.
-- All Right Reserved.
--------------------------------------------------------------------------------
--   ____  ____ 
--  /   /\/   / 
-- /___/  \  /    Vendor: Xilinx 
-- \   \   \/     Version : 9.1.03i
--  \   \         Application : ISE
--  /   /         Filename : alarmtest.vhw
-- /___/   /\     Timestamp : Tue Jun 02 17:13:32 2009
-- \   \  /  \ 
--  \___\/\___\ 
--
--Command: 
--Design Name: alarmtest
--Device: Xilinx
--

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
USE IEEE.STD_LOGIC_TEXTIO.ALL;
USE STD.TEXTIO.ALL;

ENTITY alarmtest IS
END alarmtest;

ARCHITECTURE testbench_arch OF alarmtest IS
    FILE RESULTS: TEXT OPEN WRITE_MODE IS "results.txt";

    COMPONENT TopUnit
        PORT (
            Btns : In std_logic_vector (3 DownTo 0);
            AccessCode : In std_logic_vector (3 DownTo 0);
            UserCode : In std_logic_vector (3 DownTo 0);
            Cs : Out std_logic_vector (6 DownTo 0);
            AN : Out std_logic_vector (3 DownTo 0);
            DP : Out std_logic;
            SYS_ARMED : Out std_logic;
            ALARM : Out std_logic;
            MCLK : In std_logic
        );
    END COMPONENT;

    SIGNAL Btns : std_logic_vector (3 DownTo 0) := "0000";
    SIGNAL AccessCode : std_logic_vector (3 DownTo 0) := "0000";
    SIGNAL UserCode : std_logic_vector (3 DownTo 0) := "0000";
    SIGNAL Cs : std_logic_vector (6 DownTo 0) := "0000000";
    SIGNAL AN : std_logic_vector (3 DownTo 0) := "0000";
    SIGNAL DP : std_logic := '0';
    SIGNAL SYS_ARMED : std_logic := '0';
    SIGNAL ALARM : std_logic := '0';
    SIGNAL MCLK : std_logic := '0';

    constant PERIOD : time := 200 ns;
    constant DUTY_CYCLE : real := 0.5;
    constant OFFSET : time := 100 ns;

    BEGIN
        UUT : TopUnit
        PORT MAP (
            Btns => Btns,
            AccessCode => AccessCode,
            UserCode => UserCode,
            Cs => Cs,
            AN => AN,
            DP => DP,
            SYS_ARMED => SYS_ARMED,
            ALARM => ALARM,
            MCLK => MCLK
        );

        PROCESS    -- clock process for MCLK
        BEGIN
            WAIT for OFFSET;
            CLOCK_LOOP : LOOP
                MCLK <= '0';
                WAIT FOR (PERIOD - (PERIOD * DUTY_CYCLE));
                MCLK <= '1';
                WAIT FOR (PERIOD * DUTY_CYCLE);
            END LOOP CLOCK_LOOP;
        END PROCESS;

        PROCESS
            BEGIN
                -- -------------  Current Time:  185ns
                WAIT FOR 185 ns;
                AccessCode <= "1111";
                UserCode <= "1110";
                -- -------------------------------------
                -- -------------  Current Time:  585ns
                WAIT FOR 400 ns;
                UserCode <= "1111";
                -- -------------------------------------
                -- -------------  Current Time:  1185ns
                WAIT FOR 600 ns;
                UserCode <= "0000";
                -- -------------------------------------
                -- -------------  Current Time:  1385ns
                WAIT FOR 200 ns;
                Btns <= "0100";
                -- -------------------------------------
                -- -------------  Current Time:  1785ns
                WAIT FOR 400 ns;
                UserCode <= "1110";
                -- -------------------------------------
                -- -------------  Current Time:  1985ns
                WAIT FOR 200 ns;
                UserCode <= "1111";
                -- -------------------------------------
                -- -------------  Current Time:  2185ns
                WAIT FOR 200 ns;
                Btns <= "0000";
                -- -------------------------------------
                -- -------------  Current Time:  2385ns
                WAIT FOR 200 ns;
                UserCode <= "0000";
                -- -------------------------------------
                WAIT FOR 97815 ns;

            END PROCESS;

    END testbench_arch;

