# factorial.s 
# Compute n! recursively.

.text
.globl factorial

# Preconditions:	
#   1st parameter (a0) non-negative integer, n
# Postconditions:
#   result (v0) n factorial

.globl main

# Prompt for a non-negative integer
# and invoke the factorial function.

main:
	sll $t2, $t0, 4
	or $t2, $t2, $t1

.data

prompt: .asciiz "Enter a non-negative integer: "
endl:	.asciiz "\n"

# $Id: factorial.s,v 1.3 2006/05/25 13:42:10 parks Exp $
# Authors: Chris Nevison and Thomas M. Parks
