;Tyler Holland
;Lab 7 
;R1 - Store Character to scan for
;R2 - Store current position in memory for array
;R3 - Store Char
;R4 - misc
	.ORIG 	x3000
;Main:
	LEA	R2,String	;Starting address of String in R2
	LD	R3,Char		;Store Char
	;Data Storage: Place
	AND	R0,R0,#0	;Clear R0 and put counter in R0
	ADD	R6,R6,#-1	;Decrement R6
	STR	R0,R6,#0	;Push counter
;
charCount
	ST	R4,FCR4		;Save Registers
	ST	R7,FCR7		
	LDR	R0,R5,#0	;Load counter
	LD	R4,Place	;
	ADD	R4,R2,R4	;if (place < 20)
	BRzp	RTRN		;Return 0
	ADD	R4,R3,R2	;if(search = array)
	BRnp	ELSE		
	ADD	R0,R0,#1	;search = array, add 1
ELSE	ADD	R2,R2,#1	;increment array pointer
	JSR	charCount	;Recursion
RTRN	LD	R4,FCR4		;restore registers
	LD	R7,FCR7
	RET

;
Place	.FILL	#-20
Char	.FILL	#-116 		;Opposite of t for checking
String	.STRINGZ "thisisatestonetwo"
FCR4	.BLKW	1
FCR7	.BLKW	1
	.END