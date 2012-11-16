;Tyler Holland
;Lab 5 - Interrupt Service Routine
;R0 - holds character from KBDR
;R1 - holds temporary values for data movement
;
	.ORIG x3500
	LDI	R0,KBDR		;Load data from KBDR to R0
	AND	R1,R1,#0	;Clear R1
	STI	R1,KBSR		;Clear the KBSR
	LDI	R1,UP1		;Put the PC of UP1 into R1
	STR	R1,R6,#0	;Put UP1 in the place of UP2
	RTI
;
KBDR	.FILL	xFE02
KBSR	.FILL	xFE00
UP1	.FILL	x32FF
	.END
