--------------------------------------------------------------------------------
-- Copyright (c) 1995-2003 Xilinx, Inc.
-- All Right Reserved.
--------------------------------------------------------------------------------
--   ____  ____ 
--  /   /\/   / 
-- /___/  \  /    Vendor: Xilinx 
-- \   \   \/     Version : 9.1.03i
--  \   \         Application : ISE
--  /   /         Filename : encoderfinal.vhw
-- /___/   /\     Timestamp : Wed May 13 17:36:55 2009
-- \   \  /  \ 
--  \___\/\___\ 
--
--Command: 
--Design Name: encoderfinal
--Device: Xilinx
--

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
USE IEEE.STD_LOGIC_TEXTIO.ALL;
USE STD.TEXTIO.ALL;

ENTITY encoderfinal IS
END encoderfinal;

ARCHITECTURE testbench_arch OF encoderfinal IS
    FILE RESULTS: TEXT OPEN WRITE_MODE IS "results.txt";

    COMPONENT encoder
        PORT (
            I : In std_logic_vector (7 DownTo 0);
            Y : Out std_logic_vector (2 DownTo 0);
            STROBE : Out std_logic
        );
    END COMPONENT;

    SIGNAL I : std_logic_vector (7 DownTo 0) := "00000000";
    SIGNAL Y : std_logic_vector (2 DownTo 0) := "000";
    SIGNAL STROBE : std_logic := '0';

    BEGIN
        UUT : encoder
        PORT MAP (
            I => I,
            Y => Y,
            STROBE => STROBE
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
                WAIT FOR 1600 ns;

            END PROCESS;

    END testbench_arch;

