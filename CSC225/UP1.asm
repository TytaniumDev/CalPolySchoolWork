	.ORIG	x3000

	TRAP	x26  ; get char
	TRAP	x21  ; print char to screen
	TRAP	x26  ; get char
	TRAP	x21  ; print char to screen
	TRAP	x26  ; get char
	TRAP	x21  ; print char to screen
	TRAP	x26  ; get char
	TRAP	x21  ; print char to screen
	TRAP	x26  ; get char
	TRAP	x21  ; print char to screen

	HALT

        .END