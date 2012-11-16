;Tyler Holland
;Lab 5 User Program 2
;R1 - Asterisk counter register
;
	.ORIG 	x3400
Begin	AND	R1,R1,#0	;Clear R1
Loop	ADD	R1,R1,#1	;Add 1 to R1
	BRzp	Loop		;Loop until negative
	AND	R1,R1,#0	;Get ready to store R0
	ADD	R1,R0,R1	;Store R0 in R1 temporarily
	LD	R0,Word		;Put * in R0 for output
	OUT			;Print * to screen
	AND	R0,R0,#0	;Clear R0
	ADD	R0,R0,R1	;Put old R0 into R0
	BRnzp	Begin		;Loop it
	HALT			;End Program
;
Word	.FILL	x002A		;Hex for *
	.END