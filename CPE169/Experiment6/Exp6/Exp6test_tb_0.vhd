--------------------------------------------------------------------------------
-- Copyright (c) 1995-2003 Xilinx, Inc.
-- All Right Reserved.
--------------------------------------------------------------------------------
--   ____  ____ 
--  /   /\/   / 
-- /___/  \  /    Vendor: Xilinx 
-- \   \   \/     Version : 9.1.03i
--  \   \         Application : ISE
--  /   /         Filename : Exp6test.vhw
-- /___/   /\     Timestamp : Wed May 13 16:25:48 2009
-- \   \  /  \ 
--  \___\/\___\ 
--
--Command: 
--Design Name: Exp6test_tb_0
--Device: Xilinx
--

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
USE IEEE.STD_LOGIC_TEXTIO.ALL;
USE STD.TEXTIO.ALL;

ENTITY Exp6test_tb_0 IS
END Exp6test_tb_0;

ARCHITECTURE testbench_arch OF Exp6test_tb_0 IS
    FILE RESULTS: TEXT OPEN WRITE_MODE IS "results.txt";

    COMPONENT Exp6
        PORT (
            R17 : In std_logic;
            N17 : In std_logic;
            L13 : In std_logic;
            L14 : In std_logic;
            Display : Out std_logic_vector (6 DownTo 0);
            A0 : Out std_logic;
            A1 : Out std_logic;
            A2 : Out std_logic;
            A3 : Out std_logic;
            DP : Out std_logic
        );
    END COMPONENT;

    SIGNAL R17 : std_logic := '0';
    SIGNAL N17 : std_logic := '0';
    SIGNAL L13 : std_logic := '0';
    SIGNAL L14 : std_logic := '0';
    SIGNAL Display : std_logic_vector (6 DownTo 0) := "0000000";
    SIGNAL A0 : std_logic := '0';
    SIGNAL A1 : std_logic := '0';
    SIGNAL A2 : std_logic := '0';
    SIGNAL A3 : std_logic := '0';
    SIGNAL DP : std_logic := '0';

    constant PERIOD : time := 200 ns;
    constant DUTY_CYCLE : real := 0.5;
    constant OFFSET : time := 100 ns;

    BEGIN
        UUT : Exp6
        PORT MAP (
            R17 => R17,
            N17 => N17,
            L13 => L13,
            L14 => L14,
            Display => Display,
            A0 => A0,
            A1 => A1,
            A2 => A2,
            A3 => A3,
            DP => DP
        );

        PROCESS    -- clock process for R17
        BEGIN
            WAIT for OFFSET;
            CLOCK_LOOP : LOOP
                R17 <= '0';
                WAIT FOR (PERIOD - (PERIOD * DUTY_CYCLE));
                R17 <= '1';
                WAIT FOR (PERIOD * DUTY_CYCLE);
            END LOOP CLOCK_LOOP;
        END PROCESS;

        PROCESS
            BEGIN
                -- -------------  Current Time:  385ns
                WAIT FOR 385 ns;
                L13 <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  585ns
                WAIT FOR 200 ns;
                L13 <= '0';
                L14 <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  785ns
                WAIT FOR 200 ns;
                L13 <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  985ns
                WAIT FOR 200 ns;
                N17 <= '1';
                L13 <= '0';
                L14 <= '0';
                -- -------------------------------------
                -- -------------  Current Time:  1185ns
                WAIT FOR 200 ns;
                L13 <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  1385ns
                WAIT FOR 200 ns;
                L13 <= '0';
                L14 <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  1585ns
                WAIT FOR 200 ns;
                L13 <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  1785ns
                WAIT FOR 200 ns;
                N17 <= '0';
                L13 <= '0';
                L14 <= '0';
                -- -------------------------------------
                -- -------------  Current Time:  1985ns
                WAIT FOR 200 ns;
                L13 <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  2185ns
                WAIT FOR 200 ns;
                L13 <= '0';
                L14 <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  2385ns
                WAIT FOR 200 ns;
                L13 <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  2585ns
                WAIT FOR 200 ns;
                N17 <= '1';
                L13 <= '0';
                L14 <= '0';
                -- -------------------------------------
                -- -------------  Current Time:  2785ns
                WAIT FOR 200 ns;
                L13 <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  2985ns
                WAIT FOR 200 ns;
                L13 <= '0';
                L14 <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  3185ns
                WAIT FOR 200 ns;
                L13 <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  3385ns
                WAIT FOR 200 ns;
                N17 <= '0';
                L13 <= '0';
                L14 <= '0';
                -- -------------------------------------
                -- -------------  Current Time:  3585ns
                WAIT FOR 200 ns;
                L13 <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  3785ns
                WAIT FOR 200 ns;
                L13 <= '0';
                L14 <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  3985ns
                WAIT FOR 200 ns;
                L13 <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  4185ns
                WAIT FOR 200 ns;
                N17 <= '1';
                L13 <= '0';
                L14 <= '0';
                -- -------------------------------------
                -- -------------  Current Time:  4385ns
                WAIT FOR 200 ns;
                L13 <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  4585ns
                WAIT FOR 200 ns;
                L13 <= '0';
                L14 <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  4785ns
                WAIT FOR 200 ns;
                L13 <= '1';
                -- -------------------------------------
                -- -------------  Current Time:  4985ns
                WAIT FOR 200 ns;
                N17 <= '0';
                L13 <= '0';
                L14 <= '0';
                -- -------------------------------------
                WAIT FOR 215 ns;

            END PROCESS;

    END testbench_arch;

