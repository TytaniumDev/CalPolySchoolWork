--------------------------------------------------------------------------------
-- Copyright (c) 1995-2007 Xilinx, Inc.  All rights reserved.
--------------------------------------------------------------------------------
--   ____  ____
--  /   /\/   /
-- /___/  \  /    Vendor: Xilinx
-- \   \   \/     Version: J.33
--  \   \         Application: netgen
--  /   /         Filename: Procedure3_timesim.vhd
-- /___/   /\     Timestamp: Wed May 20 17:04:58 2009
-- \   \  /  \ 
--  \___\/\___\
--             
-- Command	: -intstyle ise -s 4 -pcf Procedure3.pcf -rpw 100 -tpw 0 -ar Structure -tm Procedure3 -insert_pp_buffers false -w -dir netgen/par -ofmt vhdl -sim Procedure3.ncd Procedure3_timesim.vhd 
-- Device	: 3s500efg320-4 (PRODUCTION 1.26 2006-10-19)
-- Input file	: Procedure3.ncd
-- Output file	: C:\Documents and Settings\s169s4b1\Desktop\Experiment7\netgen\par\Procedure3_timesim.vhd
-- # of Entities	: 1
-- Design Name	: Procedure3
-- Xilinx	: C:\Xilinx\ISE91
--             
-- Purpose:    
--     This VHDL netlist is a verification model and uses simulation 
--     primitives which may not represent the true implementation of the 
--     device, however the netlist is functionally correct and should not 
--     be modified. This file cannot be synthesized and should only be used 
--     with supported simulation tools.
--             
-- Reference:  
--     Development System Reference Guide, Chapter 23
--     Synthesis and Simulation Design Guide, Chapter 6
--             
--------------------------------------------------------------------------------

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
library SIMPRIM;
use SIMPRIM.VCOMPONENTS.ALL;
use SIMPRIM.VPACKAGE.ALL;

entity Procedure3 is
  port (
    CarryOut : out STD_LOGIC; 
    Sum : out STD_LOGIC_VECTOR ( 3 downto 0 ); 
    A : in STD_LOGIC_VECTOR ( 3 downto 0 ); 
    B : in STD_LOGIC_VECTOR ( 3 downto 0 ) 
  );
end Procedure3;

architecture Structure of Procedure3 is
  signal A_0_IBUF_0 : STD_LOGIC; 
  signal A_1_IBUF_1 : STD_LOGIC; 
  signal A_2_IBUF_2 : STD_LOGIC; 
  signal A_3_IBUF_3 : STD_LOGIC; 
  signal B_0_IBUF_4 : STD_LOGIC; 
  signal B_1_IBUF_5 : STD_LOGIC; 
  signal B_2_IBUF_6 : STD_LOGIC; 
  signal B_3_IBUF_7 : STD_LOGIC; 
  signal C2 : STD_LOGIC; 
  signal C3 : STD_LOGIC; 
  signal A_0_INBUF : STD_LOGIC; 
  signal A_1_INBUF : STD_LOGIC; 
  signal A_2_INBUF : STD_LOGIC; 
  signal A_3_INBUF : STD_LOGIC; 
  signal B_0_INBUF : STD_LOGIC; 
  signal B_1_INBUF : STD_LOGIC; 
  signal B_2_INBUF : STD_LOGIC; 
  signal B_3_INBUF : STD_LOGIC; 
  signal Sum_0_O : STD_LOGIC; 
  signal Sum_1_O : STD_LOGIC; 
  signal Sum_2_O : STD_LOGIC; 
  signal Sum_3_O : STD_LOGIC; 
  signal CarryOut_O : STD_LOGIC; 
  signal Sum_2_OBUF_8 : STD_LOGIC; 
  signal C2_pack_1 : STD_LOGIC; 
  signal Sum_1_OBUF_9 : STD_LOGIC; 
  signal Sum_0_OBUF_10 : STD_LOGIC; 
  signal CarryOut_OBUF_11 : STD_LOGIC; 
  signal C3_pack_1 : STD_LOGIC; 
  signal Sum_3_OBUF_12 : STD_LOGIC; 
  signal VCC : STD_LOGIC; 
begin
  A_0_IBUF : X_BUF
    generic map(
      LOC => "IPAD103",
      PATHPULSE => 798 ps
    )
    port map (
      I => A(0),
      O => A_0_INBUF
    );
  A_0_IFF_IMUX : X_BUF
    generic map(
      LOC => "IPAD103",
      PATHPULSE => 798 ps
    )
    port map (
      I => A_0_INBUF,
      O => A_0_IBUF_0
    );
  A_1_IBUF : X_BUF
    generic map(
      LOC => "IPAD98",
      PATHPULSE => 798 ps
    )
    port map (
      I => A(1),
      O => A_1_INBUF
    );
  A_1_IFF_IMUX : X_BUF
    generic map(
      LOC => "IPAD98",
      PATHPULSE => 798 ps
    )
    port map (
      I => A_1_INBUF,
      O => A_1_IBUF_1
    );
  A_2_IBUF : X_BUF
    generic map(
      LOC => "IPAD108",
      PATHPULSE => 798 ps
    )
    port map (
      I => A(2),
      O => A_2_INBUF
    );
  A_2_IFF_IMUX : X_BUF
    generic map(
      LOC => "IPAD108",
      PATHPULSE => 798 ps
    )
    port map (
      I => A_2_INBUF,
      O => A_2_IBUF_2
    );
  A_3_IBUF : X_BUF
    generic map(
      LOC => "IPAD112",
      PATHPULSE => 798 ps
    )
    port map (
      I => A(3),
      O => A_3_INBUF
    );
  A_3_IFF_IMUX : X_BUF
    generic map(
      LOC => "IPAD112",
      PATHPULSE => 798 ps
    )
    port map (
      I => A_3_INBUF,
      O => A_3_IBUF_3
    );
  B_0_IBUF : X_BUF
    generic map(
      LOC => "IPAD78",
      PATHPULSE => 798 ps
    )
    port map (
      I => B(0),
      O => B_0_INBUF
    );
  B_0_IFF_IMUX : X_BUF
    generic map(
      LOC => "IPAD78",
      PATHPULSE => 798 ps
    )
    port map (
      I => B_0_INBUF,
      O => B_0_IBUF_4
    );
  B_1_IBUF : X_BUF
    generic map(
      LOC => "IPAD83",
      PATHPULSE => 798 ps
    )
    port map (
      I => B(1),
      O => B_1_INBUF
    );
  B_1_IFF_IMUX : X_BUF
    generic map(
      LOC => "IPAD83",
      PATHPULSE => 798 ps
    )
    port map (
      I => B_1_INBUF,
      O => B_1_IBUF_5
    );
  B_2_IBUF : X_BUF
    generic map(
      LOC => "IPAD88",
      PATHPULSE => 798 ps
    )
    port map (
      I => B(2),
      O => B_2_INBUF
    );
  B_2_IFF_IMUX : X_BUF
    generic map(
      LOC => "IPAD88",
      PATHPULSE => 798 ps
    )
    port map (
      I => B_2_INBUF,
      O => B_2_IBUF_6
    );
  B_3_IBUF : X_BUF
    generic map(
      LOC => "IPAD93",
      PATHPULSE => 798 ps
    )
    port map (
      I => B(3),
      O => B_3_INBUF
    );
  B_3_IFF_IMUX : X_BUF
    generic map(
      LOC => "IPAD93",
      PATHPULSE => 798 ps
    )
    port map (
      I => B_3_INBUF,
      O => B_3_IBUF_7
    );
  Sum_0_OBUF : X_OBUF
    generic map(
      LOC => "PAD84"
    )
    port map (
      I => Sum_0_O,
      O => Sum(0)
    );
  Sum_1_OBUF : X_OBUF
    generic map(
      LOC => "PAD85"
    )
    port map (
      I => Sum_1_O,
      O => Sum(1)
    );
  Sum_2_OBUF : X_OBUF
    generic map(
      LOC => "PAD90"
    )
    port map (
      I => Sum_2_O,
      O => Sum(2)
    );
  Sum_3_OBUF : X_OBUF
    generic map(
      LOC => "PAD89"
    )
    port map (
      I => Sum_3_O,
      O => Sum(3)
    );
  CarryOut_OBUF : X_OBUF
    generic map(
      LOC => "PAD181"
    )
    port map (
      I => CarryOut_O,
      O => CarryOut
    );
  Sum_2_OBUF_YUSED : X_BUF
    generic map(
      LOC => "SLICE_X66Y29",
      PATHPULSE => 798 ps
    )
    port map (
      I => C2_pack_1,
      O => C2
    );
  F1_Carry1 : X_LUT4
    generic map(
      INIT => X"E8C0",
      LOC => "SLICE_X66Y29"
    )
    port map (
      ADR0 => B_0_IBUF_4,
      ADR1 => A_1_IBUF_1,
      ADR2 => B_1_IBUF_5,
      ADR3 => A_0_IBUF_0,
      O => C2_pack_1
    );
  H1_Mxor_Sum_Result1 : X_LUT4
    generic map(
      INIT => X"3C3C",
      LOC => "SLICE_X67Y40"
    )
    port map (
      ADR0 => VCC,
      ADR1 => B_0_IBUF_4,
      ADR2 => A_0_IBUF_0,
      ADR3 => VCC,
      O => Sum_0_OBUF_10
    );
  CarryOut_OBUF_YUSED : X_BUF
    generic map(
      LOC => "SLICE_X54Y28",
      PATHPULSE => 798 ps
    )
    port map (
      I => C3_pack_1,
      O => C3
    );
  F2_Carry1 : X_LUT4
    generic map(
      INIT => X"FCC0",
      LOC => "SLICE_X54Y28"
    )
    port map (
      ADR0 => VCC,
      ADR1 => B_2_IBUF_6,
      ADR2 => C2,
      ADR3 => A_2_IBUF_2,
      O => C3_pack_1
    );
  F3_Mxor_Sum_xo_1_1 : X_LUT4
    generic map(
      INIT => X"9966",
      LOC => "SLICE_X64Y28"
    )
    port map (
      ADR0 => B_3_IBUF_7,
      ADR1 => A_3_IBUF_3,
      ADR2 => VCC,
      ADR3 => C3,
      O => Sum_3_OBUF_12
    );
  F2_Mxor_Sum_xo_1_1 : X_LUT4
    generic map(
      INIT => X"9696",
      LOC => "SLICE_X66Y29"
    )
    port map (
      ADR0 => A_2_IBUF_2,
      ADR1 => B_2_IBUF_6,
      ADR2 => C2,
      ADR3 => VCC,
      O => Sum_2_OBUF_8
    );
  F1_Mxor_Sum_xo_1_1 : X_LUT4
    generic map(
      INIT => X"936C",
      LOC => "SLICE_X67Y40"
    )
    port map (
      ADR0 => B_0_IBUF_4,
      ADR1 => B_1_IBUF_5,
      ADR2 => A_0_IBUF_0,
      ADR3 => A_1_IBUF_1,
      O => Sum_1_OBUF_9
    );
  F3_Carry1 : X_LUT4
    generic map(
      INIT => X"EE88",
      LOC => "SLICE_X54Y28"
    )
    port map (
      ADR0 => B_3_IBUF_7,
      ADR1 => A_3_IBUF_3,
      ADR2 => VCC,
      ADR3 => C3,
      O => CarryOut_OBUF_11
    );
  Sum_0_OUTPUT_OFF_OMUX : X_BUF
    generic map(
      LOC => "PAD84",
      PATHPULSE => 798 ps
    )
    port map (
      I => Sum_0_OBUF_10,
      O => Sum_0_O
    );
  Sum_1_OUTPUT_OFF_OMUX : X_BUF
    generic map(
      LOC => "PAD85",
      PATHPULSE => 798 ps
    )
    port map (
      I => Sum_1_OBUF_9,
      O => Sum_1_O
    );
  Sum_2_OUTPUT_OFF_OMUX : X_BUF
    generic map(
      LOC => "PAD90",
      PATHPULSE => 798 ps
    )
    port map (
      I => Sum_2_OBUF_8,
      O => Sum_2_O
    );
  Sum_3_OUTPUT_OFF_OMUX : X_BUF
    generic map(
      LOC => "PAD89",
      PATHPULSE => 798 ps
    )
    port map (
      I => Sum_3_OBUF_12,
      O => Sum_3_O
    );
  CarryOut_OUTPUT_OFF_OMUX : X_BUF
    generic map(
      LOC => "PAD181",
      PATHPULSE => 798 ps
    )
    port map (
      I => CarryOut_OBUF_11,
      O => CarryOut_O
    );
  NlwBlock_Procedure3_VCC : X_ONE
    port map (
      O => VCC
    );
  NlwBlockROC : X_ROC
    generic map (ROC_WIDTH => 100 ns)
    port map (O => GSR);
  NlwBlockTOC : X_TOC
    port map (O => GTS);

end Structure;

