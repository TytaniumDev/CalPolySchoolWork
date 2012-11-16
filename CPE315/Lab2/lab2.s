#lab2.s
#Divide using no arithmetic instructions

#Student: Tyler Holland 1/21/2010

.globl main

main:

prompts:
		la		$a0, prompt1
		li		$v0, 4
		syscall				#display prompt1
	
		li		$v0, 5
		syscall				#Get input1 into $v0
		move 	$t0, $v0	#Put input1 into t0

		la		$a0, prompt2
		li		$v0, 4
		syscall				#display prompt2
	
		li		$v0, 5
		syscall				#Get input2 into $v0
		move 	$t1, $v0	#Put input2 into t1

#t0 = input1
#t1 = input2
#t2 = adder sum
#t3 = adder carry
#t4 = yes/no for continue

adder:
		xor 	$t2, $t1, $t0

		la		$a0, end1
		li		$v0, 4
		syscall				#Print end text

		move	$a0, $t2
		li	 	$v0, 1
		syscall				#Print integer for result

		la		$a0, prompt3
		li		$v0, 4
		syscall				#Print Again?

		la 		$a0, inchar
		li		$a1, 1
		li		$v0, 8
		syscall				#get y/n

		la		$t4, inchar
		la		$t5, chary
		slt		$t5, $t4, $t5
		andi	$t4, $t4, 1
		beq 	$t4, $t5, prompts

		li	$v0, 0			#Return 0

.data

prompt1: .asciiz "Enter Number 1: "
prompt2: .asciiz "Enter Number 2: "
prompt3: .asciiz "\nAgain (y/n)? "
chary: .asciiz "y"
inchar: .space 2
end1: .asciiz "Quotient is: " 
