#counter.s
#Count number of adjacent 1's in a binary number

#Student: Tyler Holland 1/12/2010

#C Code:
#
##include <stdio.h>
#
#int main (void){
#	double input;
#	int current;
#	int lastOne = 0;
#	int adj = 0;
#	int adjtotal = 0;
#	printf("Enter a number: ");
#	scanf("%lf", &input);
#	/*Division Loop*/
#	while(input != 0)
#	{
#		current = (int)input % 2;
#		if(current == 1)
#		{
#			if(lastOne == 1)
#			{
#				if(adj == 1)
#				{
#					adjtotal++;
#				}
#				adjtotal++;
#			}
#			else
#			{
#				lastOne = 1;
#			}
#			adj++;
#		}
#		else if(current == 0)
#		{
#			adj = 0;
#			lastOne = 0;
#		}
#		input = input/2;
#	}
#	printf("Your number has %d adjacent 1's", adjtotal);
#	return 0;
#}

.globl main

main:

		la		$a0, prompt
		li		$v0, 4
		syscall				#display prompt
	
		li		$v0, 5
		syscall				#Get input into $v0
		move 	$t2, $v0	#Put input into t2

#t0 = 0, for branching
#t1 = 1, for branching
#t2 = LO = input
#t3 = HI = current
#t4 = lastOne
#t5 = adj
#t6 = adjTotal
#clear registers


		andi	$t0,$t0,0	#Clear t0
		andi	$t5,$t5,0	#Clear t5
		andi	$t6,$t6,0	#Clear t6
		andi	$t1,$t1,0	#Clear t1
		addi	$t1,$t1,1	#Put 1 in t1

while:
		andi	$t3,$t3,0	#Clear t3
		addi	$t3,$t3,2	#Put 2 in t3
		divu	$t2,$t3		#t2 = t2 / 2, t3 = t2 % 2
		mflo	$t2
		mfhi	$t3
		bne		$t3,$t1,else1	#if current == 1 continue
		bne		$t4,$t1,else2	#if lastOne == 1 continue
		addi	$t6,$t6,1		
		bne		$t5,$t1,else2	#if adj == 1 continue
		addi	$t6,$t6,1
		j		if1

#lastOne == 0
else2:
		andi	$t4,$t4,0	#Clear t4
		addi	$t4,$t4,1	#lastOne = 1
		j		if1

if1:
		addi	$t5,$t5,1
		j		loop

#current == 0
else1:
		andi	$t5,$t5,0	#adj = 0
		andi	$t4,$t4,0	#lastOne = 0
		j		loop

#loop condition check (input != 0)
loop:
		bne		$t2,$t0,while	#while input != 0 continue loop

		move	$a0, $t6
		li	 	$v0, 1
		syscall				#Print integer for result

		la		$a0, end1
		li		$v0, 4
		syscall				#Print end text

		li	$v0, 0			#Return 0

.data

prompt: .asciiz "Enter a number: "
end1: .asciiz " adjacent 1's\n" 
