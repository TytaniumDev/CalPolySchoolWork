	.file	1 "test.c"
	.section .mdebug.abi32
	.previous
	.text
	.align	2
	.globl	main
	.ent	main
main:
	.frame	$fp,112,$31		# vars= 104, regs= 1/0, args= 0, gp= 0
	.mask	0x40000000,-8
	.fmask	0x00000000,0
	.set	noreorder
	.set	nomacro
	
	addiu	$sp,$sp,-112
	sw	$fp,104($sp)
	move	$fp,$sp
	sw	$0,100($fp)
	li	$2,1			# 0x1
	sw	$2,96($fp)
	li	$2,1			# 0x1
	sw	$2,92($fp)
	li	$2,3			# 0x3
	sw	$2,88($fp)
	li	$2,-2			# 0xfffffffffffffffe
	sw	$2,84($fp)
	li	$2,-5			# 0xfffffffffffffffb
	sw	$2,80($fp)
	li	$2,10
	sb	$2,79($fp)
	li	$2,-2
	sb	$2,78($fp)
	li	$2,5
	sb	$2,77($fp)
	li	$2,-1
	sb	$2,76($fp)
	lw	$3,88($fp)
	lw	$2,84($fp)
	nop
	addu	$2,$3,$2
	sw	$2,72($fp)
	lw	$2,88($fp)
	nop
	sll	$2,$2,1
	sw	$2,68($fp)
	lw	$3,96($fp)
	lw	$2,88($fp)
	nop
	slt	$2,$3,$2
	sw	$2,64($fp)
	lw	$3,88($fp)
	lw	$2,96($fp)
	nop
	slt	$2,$3,$2
	sw	$2,60($fp)
	lw	$3,96($fp)
	lw	$2,84($fp)
	nop
	slt	$2,$3,$2
	sw	$2,56($fp)
	lw	$3,84($fp)
	lw	$2,96($fp)
	nop
	slt	$2,$3,$2
	sw	$2,52($fp)
	lw	$3,80($fp)
	lw	$2,84($fp)
	nop
	slt	$2,$3,$2
	sw	$2,48($fp)
	lw	$3,84($fp)
	lw	$2,80($fp)
	nop
	slt	$2,$3,$2
	sw	$2,44($fp)
	lb	$2,79($fp)
	nop
	sw	$2,40($fp)
	lb	$2,78($fp)
	nop
	sw	$2,36($fp)
	lbu	$2,77($fp)
	nop
	sw	$2,32($fp)
	lbu	$2,76($fp)
	nop
	sw	$2,28($fp)
	lw	$3,96($fp)
	lw	$2,92($fp)
	nop
	bne	$3,$2,$L2
	nop

	li	$2,10			# 0xa
	sw	$2,24($fp)
$L2:
	lw	$3,96($fp)
	lw	$2,88($fp)
	nop
	bne	$3,$2,$L4
	nop

	li	$2,11			# 0xb
	sw	$2,20($fp)
$L4:
	lw	$3,96($fp)
	lw	$2,88($fp)
	nop
	beq	$3,$2,$L6
	nop

	li	$2,12			# 0xc
	sw	$2,16($fp)
$L6:
	lw	$3,96($fp)
	lw	$2,92($fp)
	nop
	beq	$3,$2,$L8
	nop

	li	$2,13			# 0xd
	sw	$2,12($fp)
$L8:
	lw	$2,96($fp)
	nop
	blez	$2,$L10
	nop

	li	$2,14			# 0xe
	sw	$2,8($fp)
$L10:
	lw	$2,84($fp)
	nop
	blez	$2,$L12
	nop

	li	$2,15			# 0xf
	sw	$2,4($fp)
$L12:
	lw	$2,100($fp)
	nop
	blez	$2,$L14
	nop

	li	$2,16			# 0x10
	sw	$2,0($fp)
$L14:
	lw	$2,96($fp)
	move	$sp,$fp
	lw	$fp,104($sp)
	addiu	$sp,$sp,112
	j	$31
	nop

	.set	macro
	.set	reorder
	.end	main
	.size	main, .-main
	.ident	"GCC: (GNU) 4.1.2"
