--------------------------------------------------------------------------------
-- Copyright (c) 1995-2003 Xilinx, Inc.
-- All Right Reserved.
--------------------------------------------------------------------------------
--   ____  ____ 
--  /   /\/   / 
-- /___/  \  /    Vendor: Xilinx 
-- \   \   \/     Version : 9.1.03i
--  \   \         Application : ISE
--  /   /         Filename : finaltest.vhw
-- /___/   /\     Timestamp : Wed May 13 18:53:42 2009
-- \   \  /  \ 
--  \___\/\___\ 
--
--Command: 
--Design Name: finaltest
--Device: Xilinx
--

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
USE IEEE.STD_LOGIC_TEXTIO.ALL;
USE STD.TEXTIO.ALL;

ENTITY finaltest IS
END finaltest;

ARCHITECTURE testbench_arch OF finaltest IS
    FILE RESULTS: TEXT OPEN WRITE_MODE IS "results.txt";

    COMPONENT final
        PORT (
            I : In std_logic_vector (7 DownTo 0);
            STROBE : Out std_logic;
            A0 : Out std_logic;
            A1 : Out std_logic;
            A2 : Out std_logic;
            A3 : Out std_logic;
            DP : Out std_logic;
            Y : InOut std_logic_vector (2 DownTo 0);
            display : Out std_logic_vector (6 DownTo 0)
        );
    END COMPONENT;

    SIGNAL I : std_logic_vector (7 DownTo 0) := "00000000";
    SIGNAL STROBE : std_logic := '0';
    SIGNAL A0 : std_logic := '0';
    SIGNAL A1 : std_logic := '0';
    SIGNAL A2 : std_logic := '0';
    SIGNAL A3 : std_logic := '0';
    SIGNAL DP : std_logic := '0';
    SIGNAL Y : std_logic_vector (2 DownTo 0) := "ZZZ";
    SIGNAL display : std_logic_vector (6 DownTo 0) := "0000000";

    BEGIN
        UUT : final
        PORT MAP (
            I => I,
            STROBE => STROBE,
            A0 => A0,
            A1 => A1,
            A2 => A2,
            A3 => A3,
            DP => DP,
            Y => Y,
            display => display
        );

        PROCESS
            BEGIN
                -- -------------  Current Time:  200ns
                WAIT FOR 200 ns;
                I <= "00000001";
                -- -------------------------------------
                -- -------------  Current Time:  300ns
                WAIT FOR 100 ns;
                I <= "00000011";
                -- -------------------------------------
                -- -------------  Current Time:  400ns
                WAIT FOR 100 ns;
                I <= "00000111";
                -- -------------------------------------
                -- -------------  Current Time:  500ns
                WAIT FOR 100 ns;
                I <= "00001111";
                -- -------------------------------------
                -- -------------  Current Time:  600ns
                WAIT FOR 100 ns;
                I <= "00011111";
                -- -------------------------------------
                -- -------------  Current Time:  700ns
                WAIT FOR 100 ns;
                I <= "00111111";
                -- -------------------------------------
                -- -------------  Current Time:  800ns
                WAIT FOR 100 ns;
                I <= "01111111";
                -- -------------------------------------
                -- -------------  Current Time:  900ns
                WAIT FOR 100 ns;
                I <= "11111111";
                -- -------------------------------------
                WAIT FOR 100 ns;

            END PROCESS;

    END testbench_arch;

