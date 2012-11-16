	.ORIG 	x3300
	ST	R7, SaveR7	;Save R7
	ST	R2, SaveR2	;Save R2
	ST	R3, SaveR3	;Save R3
	AND	R3,R3,#0	;Clear R3
; Start checking for ready
Ready	LDI	R2, DSR		;Check to see if display is ready
	BRzp	Ready		;Branch back if display isn't ready (15th bit check)
	AND	R3,R3,#1	;Check if R0 has been output
	BRp	Next		;Print R1
	STI	R0, DDR		;Put R0 on display
	ADD	R3,R3,#1	;Add #1 to R3 so we can print R1
	BRnzp	Ready		;Loop back to status check
Next	STI	R1, DDR		;Put R1 on display
; Restore Registers
	LD	R2, SaveR2	;Restore R2
	LD	R3, SaveR3	;Restore R3
	LD	R7, SaveR7	;Restore R7
	RET			;End trap
DSR	.FILL	xFE04
DDR	.FILL	xFE06
SaveR2	.FILL	0
SaveR3	.FILL	0
SaveR7	.FILL	0
	.END