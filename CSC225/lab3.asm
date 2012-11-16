;Tyler Holland
;10/14/2009
;Lab 3
;Pig Latin Basic Translator
;R1 is used to hold the loop counters
;R2 is used to hold the position of the next input in Store
;R3 is used to hold the opposite of Enter
;R4 is a data dump for Enter test
	.ORIG		x3000
	AND		R1,R1,#0		;Clear R1
	AND		R2,R2,#0		;Clear R2
	AND		R3,R3,#0		;Clear R3
	LEA		R2,Store		;Put the address of Store in R2
	LD		R3,Enter		;Put xFFF6 into R3
;
; Prompt Loop (idea from page 208)
;
	LEA		R1,Prompt		;Load Prompt offset
Loop1	LDR		R0,R1,#0		;Load Prompt into R0, for loop
	BRz		Input			;Jumps out when the null is hit
	OUT					;Output R0
	ADD		R1,R1,#1		;Make R1 point to next character
	BRnzp		Loop1			;Continue the loop
;
; User Input stage
;
Input	GETC					;Get a character
	OUT					;Echo to screen
	STR		R0,R2,#0		;Store R0 into Store
	ADD		R4,R0,R3		;Check if last char was Enter
	BRz		Done			;Jump out if Enter was pressed
	ADD		R2,R2,#1		;Increment R2, next space in Store
	BRnzp		Input			;Continue the loop
;
; Output text stage
;
Done	LEA		R1,Second		;Load Second offset
Loop2	LDR		R0,R1,#0		;Load Second into R0
	BRz		Last			;Jump out if null is hit
	OUT					;Output R0
	ADD		R1,R1,#1		;Increment R1
	BRnzp		Loop2			;Continue the loop
;
; Pig Latin Output
;
Last	LEA		R1,Store		;Put Store's address in R1
	ADD		R1,R1,#1		;Make first character the 2nd character
Loop3	LDR		R0,R1,#0		;Put R1 in R0
	BRz		Step2			;Make it Pig Latin if null is hit
	ADD		R4,R0,R3		;Check if Enter was hit
	BRz		Step2			;Ignore enter in Pig Latin conversion
	OUT
	ADD		R1,R1,#1		;Increment R1
	BRnzp		Loop3			;Continue the loop
Step2	LEA		R1,Store		;Put Store's address in R1
	LDR		R0,R1,#0		;Put R1 in R0
	OUT
	LEA		R1,Latin		;Put Latin's address in R1
Loop4	LDR		R0,R1,#0		;Put R1 in R0
	BRz		Finish			;Stop if null is hit
	OUT
	ADD		R1,R1,#1		;Increment R1
	BRnzp		Loop4			;Continue the loop
;
Finish	HALT
;
Store	.BLKW		#21			;User's input
Latin	.STRINGZ	"ay"			;Add on to end of word
Prompt	.STRINGZ	"English Word: " 	;Prompt
Second	.STRINGZ	"Pig-Latin Word: "	;Line after the prompt
Enter	.FILL		xFFF6			;Opposite of ASCII Enter
	.END