;Tyler Holland
;Lab 5 Trap x26
;R7 - Holds the PC from UP1
;R1 - Holds temporary KBSR stuff
	.ORIG	x3300
	STI	R7,UP1		;Store UP1's PC in x32FF
	LD	R1,INTER	
	STI	R1,KBSR		;Enable interrupt bit in KBSR
	LD	R1,UP2		;Get ready for JMP
	JMP	R1		;Jump to UP2
;
UP1	.FILL 	x32FF		;Store UP1 here
UP2	.FILL	x3400		;PC location of UP2
INTER	.FILL	x4000		;ADD for interrupt bit enable
KBSR	.FILL	xFE00		;KBSR location
	.END