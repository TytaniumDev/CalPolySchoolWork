          .ORIG x3000

          LD   R0,T

          LD   R1,H

          TRAP x26

          HALT

T    .FILL x54

H    .FILL x48

          .END