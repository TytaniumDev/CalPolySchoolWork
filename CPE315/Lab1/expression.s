# expression.s 
# Evaluate the expression (10 + 3) - (8+7) and print the result.
# Equivalent C++ statement:	cout << (10 + 9) << endl; 
# Equivalent Java statement:	System.out.println(10+9); 

# Student:	Tyler Holland	1/5/2010

# There are four parts to this program.
#      Evaluate the expression. 
#      Print the result. 
#      Print endl. 
#      Return. 

.text
.globl	main

main: 
	# Evaluate the expression.
	# Put the final result in a0 to prepare for the syscall.
	li	$t0, 10		# Put 10 in a register 
	li	$t1, 3		# Put 3 in a register 
	add	$a0, $t0, $t1	# a0 = t0 + t1 
	li	$t0, 8		# Put 8 in a register 
	li	$t1, 7		# Put 7 in a register 
	add	$v1, $t0, $t1	# v1 = t0 + t1 
	sub	$a0, $a0, $v1	# a0 = a0 - v1

	# Print the integer result in a0
	li	$v0, 1		# Load the system call number 
	syscall 

	# Print endl.
	la	$a0, endl	# Load the address of the string 
	li	$v0, 4		# Load the system call number 
	syscall 

	# Return.
	li	$v0, 0		# Load return value in v0.
	jr	$ra		# Return.

.data 

endl:	.asciiz	"\n" 

# $Id: expression.s,v 1.3 2006/05/25 13:42:10 parks Exp $
# Authors: Chris Nevison and Thomas M. Parks
