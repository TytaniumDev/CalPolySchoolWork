	.file	1 "shang.c"
	.section .mdebug.abi32
	.previous
	.globl	g_mainSetting
	.data
	.align	2
	.type	g_mainSetting, @object
	.size	g_mainSetting, 840
g_mainSetting:
	.ascii	"                   *\000"
	.ascii	"                  **\000"
	.ascii	"       *     *  *   \000"
	.ascii	"           *   ***  \000"
	.ascii	"*   *          *  * \000"
	.ascii	"           **    * *\000"
	.ascii	"  * **  *     *     \000"
	.ascii	"            *****   \000"
	.ascii	"   **    *   * *    \000"
	.ascii	"          * *   *** \000"
	.ascii	" * *   *   *  *     \000"
	.ascii	"      **    * *  *  \000"
	.ascii	"  *  *  *     * *   \000"
	.ascii	"          *  *  ** *\000"
	.ascii	" ***   *         *  \000"
	.ascii	" *  * * *   * *     \000"
	.ascii	"   **  * *    * *   \000"
	.ascii	"  *****           * \000"
	.ascii	"  *  *   * **  *    \000"
	.ascii	"    *  *  * * * *   \000"
	.ascii	"         * ***   ** \000"
	.ascii	"     ** *  *   * *  \000"
	.ascii	"        *** * *   * \000"
	.ascii	"  ***   *  *  *     \000"
	.ascii	"       *  ** * *  * \000"
	.ascii	"   ** * * *  * *    \000"
	.ascii	"    *  *  * *** *   \000"
	.ascii	"*****         *    *\000"
	.ascii	"   **    * * ***    \000"
	.ascii	"*  * * ***    *     \000"
	.ascii	"         ***  ** * *\000"
	.ascii	"     ** *   ** * *  \000"
	.ascii	"***   * *      ***  \000"
	.ascii	"      **   ** *** * \000"
	.ascii	" * * **  *** *      \000"
	.ascii	"* *** ***   **      \000"
	.ascii	"        *** * ** ***\000"
	.ascii	" **** **       ***  \000"
	.ascii	"**   *** *   **  ** \000"
	.ascii	"*   * * *****  **  *\000"
	.text
	.align	2
	.globl	initGame
	.ent	initGame
initGame:
	.frame	$fp,16,$31		# vars= 8, regs= 1/0, args= 0, gp= 0
	.mask	0x40000000,-8
	.fmask	0x00000000,0
	.set	noreorder
	.set	nomacro
	
	addiu	$sp,$sp,-16
	sw	$fp,8($sp)
	move	$fp,$sp
	sw	$4,16($fp)
	sw	$5,20($fp)
	sw	$0,4($fp)
	j	$L2
	nop

$L3:
	sw	$0,0($fp)
	j	$L4
	nop

$L5:
	lw	$7,4($fp)
	lw	$8,0($fp)
	lw	$4,4($fp)
	lw	$5,0($fp)
	lw	$6,16($fp)
	move	$2,$4
	sll	$2,$2,2
	sll	$3,$2,2
	addu	$2,$2,$3
	addu	$2,$2,$4
	addu	$2,$2,$6
	addu	$2,$2,$5
	lb	$4,0($2)
	lw	$5,20($fp)
	move	$2,$7
	sll	$2,$2,2
	sll	$3,$2,2
	addu	$2,$2,$3
	addu	$2,$2,$7
	addu	$2,$2,$5
	addu	$2,$2,$8
	sb	$4,0($2)
	lw	$2,0($fp)
	nop
	addiu	$2,$2,1
	sw	$2,0($fp)
$L4:
	lw	$2,0($fp)
	nop
	slt	$2,$2,21
	bne	$2,$0,$L5
	nop

	lw	$2,4($fp)
	nop
	addiu	$2,$2,1
	sw	$2,4($fp)
$L2:
	lw	$2,4($fp)
	nop
	slt	$2,$2,40
	bne	$2,$0,$L3
	nop

	sw	$0,4($fp)
	j	$L8
	nop

$L9:
	lw	$5,4($fp)
	lw	$2,4($fp)
	lw	$3,16($fp)
	sll	$2,$2,2
	addu	$2,$2,$3
	lw	$4,840($2)
	lw	$3,20($fp)
	sll	$2,$5,2
	addu	$2,$2,$3
	sw	$4,840($2)
	lw	$2,4($fp)
	nop
	addiu	$2,$2,1
	sw	$2,4($fp)
$L8:
	lw	$2,4($fp)
	nop
	slt	$2,$2,20
	bne	$2,$0,$L9
	nop

	sw	$0,4($fp)
	j	$L11
	nop

$L12:
	lw	$5,4($fp)
	lw	$2,4($fp)
	lw	$3,16($fp)
	sll	$2,$2,2
	addu	$2,$2,$3
	lw	$4,920($2)
	lw	$3,20($fp)
	sll	$2,$5,2
	addu	$2,$2,$3
	sw	$4,920($2)
	lw	$2,4($fp)
	nop
	addiu	$2,$2,1
	sw	$2,4($fp)
$L11:
	lw	$2,4($fp)
	nop
	slt	$2,$2,40
	bne	$2,$0,$L12
	nop

	move	$sp,$fp
	lw	$fp,8($sp)
	addiu	$sp,$sp,16
	j	$31
	nop

	.set	macro
	.set	reorder
	.end	initGame
	.size	initGame, .-initGame
	.align	2
	.globl	my_strncmp
	.ent	my_strncmp
my_strncmp:
	.frame	$fp,16,$31		# vars= 8, regs= 1/0, args= 0, gp= 0
	.mask	0x40000000,-8
	.fmask	0x00000000,0
	.set	noreorder
	.set	nomacro
	
	addiu	$sp,$sp,-16
	sw	$fp,8($sp)
	move	$fp,$sp
	sw	$4,16($fp)
	sw	$5,20($fp)
	sw	$6,24($fp)
	sw	$0,0($fp)
	sw	$0,4($fp)
	j	$L16
	nop

$L17:
	lw	$2,4($fp)
	nop
	move	$3,$2
	lw	$2,16($fp)
	nop
	addu	$2,$3,$2
	lb	$4,0($2)
	lw	$2,4($fp)
	nop
	move	$3,$2
	lw	$2,20($fp)
	nop
	addu	$2,$3,$2
	lb	$2,0($2)
	nop
	slt	$2,$4,$2
	beq	$2,$0,$L18
	nop

	li	$2,-1			# 0xffffffffffffffff
	sw	$2,0($fp)
	j	$L20
	nop

$L18:
	lw	$2,4($fp)
	nop
	move	$3,$2
	lw	$2,16($fp)
	nop
	addu	$2,$3,$2
	lb	$4,0($2)
	lw	$2,4($fp)
	nop
	move	$3,$2
	lw	$2,20($fp)
	nop
	addu	$2,$3,$2
	lb	$2,0($2)
	nop
	slt	$2,$2,$4
	beq	$2,$0,$L21
	nop

	li	$2,1			# 0x1
	sw	$2,0($fp)
	j	$L20
	nop

$L21:
	lw	$2,4($fp)
	nop
	addiu	$2,$2,1
	sw	$2,4($fp)
$L16:
	lw	$2,4($fp)
	lw	$3,24($fp)
	nop
	slt	$2,$2,$3
	bne	$2,$0,$L17
	nop

$L20:
	lw	$2,0($fp)
	move	$sp,$fp
	lw	$fp,8($sp)
	addiu	$sp,$sp,16
	j	$31
	nop

	.set	macro
	.set	reorder
	.end	my_strncmp
	.size	my_strncmp, .-my_strncmp
	.align	2
	.globl	my_strcpy
	.ent	my_strcpy
my_strcpy:
	.frame	$fp,16,$31		# vars= 8, regs= 1/0, args= 0, gp= 0
	.mask	0x40000000,-8
	.fmask	0x00000000,0
	.set	noreorder
	.set	nomacro
	
	addiu	$sp,$sp,-16
	sw	$fp,8($sp)
	move	$fp,$sp
	sw	$4,16($fp)
	sw	$5,20($fp)
	sw	$0,0($fp)
$L25:
	lw	$2,0($fp)
	nop
	move	$3,$2
	lw	$2,16($fp)
	nop
	addu	$4,$3,$2
	lw	$2,0($fp)
	nop
	move	$3,$2
	lw	$2,20($fp)
	nop
	addu	$2,$3,$2
	lb	$2,0($2)
	nop
	sb	$2,0($4)
	lw	$2,0($fp)
	nop
	addiu	$2,$2,1
	sw	$2,0($fp)
	lw	$2,0($fp)
	nop
	move	$3,$2
	lw	$2,20($fp)
	nop
	addu	$2,$3,$2
	lb	$2,0($2)
	nop
	bne	$2,$0,$L25
	nop

	move	$sp,$fp
	lw	$fp,8($sp)
	addiu	$sp,$sp,16
	j	$31
	nop

	.set	macro
	.set	reorder
	.end	my_strcpy
	.size	my_strcpy, .-my_strcpy
	.align	2
	.globl	CheckConstraint
	.ent	CheckConstraint
CheckConstraint:
	.frame	$fp,600,$31		# vars= 576, regs= 2/0, args= 16, gp= 0
	.mask	0xc0000000,-4
	.fmask	0x00000000,0
	.set	noreorder
	.set	nomacro
	
	addiu	$sp,$sp,-600
	sw	$31,596($sp)
	sw	$fp,592($sp)
	move	$fp,$sp
	sw	$4,600($fp)
	sw	$5,604($fp)
	sw	$0,20($fp)
	j	$L29
	nop

$L30:
	sw	$0,16($fp)
	j	$L31
	nop

$L32:
	lw	$7,20($fp)
	lw	$8,16($fp)
	lw	$4,16($fp)
	lw	$5,20($fp)
	lw	$6,600($fp)
	move	$2,$4
	sll	$2,$2,2
	sll	$3,$2,2
	addu	$2,$2,$3
	addu	$2,$2,$4
	addu	$2,$2,$6
	addu	$2,$2,$5
	lb	$4,0($2)
	move	$2,$7
	sll	$3,$2,2
	sll	$2,$3,2
	addu	$2,$3,$2
	addiu	$3,$fp,16
	addu	$2,$2,$3
	addu	$2,$2,$8
	sb	$4,8($2)
	lw	$2,16($fp)
	nop
	addiu	$2,$2,1
	sw	$2,16($fp)
$L31:
	lw	$2,16($fp)
	nop
	slt	$2,$2,20
	bne	$2,$0,$L32
	nop

	lw	$2,20($fp)
	nop
	addiu	$2,$2,1
	sw	$2,20($fp)
$L29:
	lw	$2,20($fp)
	nop
	slt	$2,$2,20
	bne	$2,$0,$L30
	nop

	sw	$0,20($fp)
	j	$L35
	nop

$L36:
	lw	$5,20($fp)
	lw	$2,20($fp)
	lw	$3,600($fp)
	sll	$2,$2,2
	addu	$2,$2,$3
	lw	$4,920($2)
	sll	$2,$5,2
	addiu	$3,$fp,16
	addu	$2,$2,$3
	sw	$4,408($2)
	lw	$2,20($fp)
	nop
	addiu	$2,$2,1
	sw	$2,20($fp)
$L35:
	lw	$2,20($fp)
	nop
	slt	$2,$2,40
	bne	$2,$0,$L36
	nop

	sw	$0,20($fp)
	j	$L38
	nop

$L39:
	sw	$0,16($fp)
	j	$L40
	nop

$L41:
	lw	$2,16($fp)
	nop
	sll	$2,$2,2
	addiu	$3,$fp,16
	addu	$2,$2,$3
	lw	$2,408($2)
	nop
	beq	$2,$0,$L42
	nop

	lw	$4,16($fp)
	nop
	move	$2,$4
	sll	$2,$2,2
	sll	$3,$2,2
	addu	$2,$2,$3
	addu	$2,$2,$4
	move	$3,$2
	lui	$2,%hi(g_mainSetting)
	addiu	$2,$2,%lo(g_mainSetting)
	addu	$2,$3,$2
	move	$4,$2
	lw	$2,20($fp)
	nop
	sll	$3,$2,2
	sll	$2,$3,2
	addu	$2,$3,$2
	move	$3,$2
	addiu	$2,$fp,24
	addu	$2,$2,$3
	move	$3,$2
	lw	$2,604($fp)
	nop
	addiu	$2,$2,1
	move	$5,$3
	move	$6,$2
	jal	my_strncmp
	nop

	bne	$2,$0,$L42
	nop

	lw	$2,16($fp)
	nop
	sll	$2,$2,2
	addiu	$3,$fp,16
	addu	$2,$2,$3
	sw	$0,408($2)
	j	$L45
	nop

$L42:
	lw	$2,16($fp)
	nop
	addiu	$2,$2,1
	sw	$2,16($fp)
$L40:
	lw	$2,16($fp)
	nop
	slt	$2,$2,40
	bne	$2,$0,$L41
	nop

$L45:
	lw	$2,16($fp)
	nop
	slt	$2,$2,40
	bne	$2,$0,$L46
	nop

	sw	$0,584($fp)
	j	$L48
	nop

$L46:
	lw	$2,20($fp)
	nop
	addiu	$2,$2,1
	sw	$2,20($fp)
$L38:
	lw	$2,20($fp)
	nop
	slt	$2,$2,20
	bne	$2,$0,$L39
	nop

	li	$2,1			# 0x1
	sw	$2,584($fp)
$L48:
	lw	$2,584($fp)
	move	$sp,$fp
	lw	$31,596($sp)
	lw	$fp,592($sp)
	addiu	$sp,$sp,600
	j	$31
	nop

	.set	macro
	.set	reorder
	.end	CheckConstraint
	.size	CheckConstraint, .-CheckConstraint
	.align	2
	.globl	SolveGame
	.ent	SolveGame
SolveGame:
	.frame	$fp,1120,$31		# vars= 1096, regs= 2/0, args= 16, gp= 0
	.mask	0xc0000000,-4
	.fmask	0x00000000,0
	.set	noreorder
	.set	nomacro
	
	addiu	$sp,$sp,-1120
	sw	$31,1116($sp)
	sw	$fp,1112($sp)
	move	$fp,$sp
	sw	$4,1120($fp)
	sw	$5,1124($fp)
	lw	$3,1124($fp)
	li	$2,20			# 0x14
	bne	$3,$2,$L52
	nop

	li	$2,1			# 0x1
	sw	$2,1104($fp)
	j	$L54
	nop

$L52:
	sw	$0,20($fp)
	j	$L55
	nop

$L56:
	lw	$2,20($fp)
	lw	$3,1120($fp)
	sll	$2,$2,2
	addu	$2,$2,$3
	lw	$2,920($2)
	nop
	beq	$2,$0,$L57
	nop

	addiu	$2,$fp,24
	lw	$4,1120($fp)
	move	$5,$2
	jal	initGame
	nop

	lw	$2,1124($fp)
	nop
	sll	$2,$2,2
	addiu	$3,$fp,16
	addu	$2,$2,$3
	lw	$3,20($fp)
	nop
	sw	$3,848($2)
	lw	$2,20($fp)
	nop
	sll	$2,$2,2
	addiu	$3,$fp,16
	addu	$2,$2,$3
	sw	$0,928($2)
	lw	$4,1124($fp)
	nop
	move	$2,$4
	sll	$2,$2,2
	sll	$3,$2,2
	addu	$2,$2,$3
	addu	$2,$2,$4
	move	$3,$2
	addiu	$2,$fp,24
	addu	$2,$2,$3
	move	$5,$2
	lw	$4,20($fp)
	nop
	move	$2,$4
	sll	$2,$2,2
	sll	$3,$2,2
	addu	$2,$2,$3
	addu	$2,$2,$4
	move	$3,$2
	lui	$2,%hi(g_mainSetting)
	addiu	$2,$2,%lo(g_mainSetting)
	addu	$2,$3,$2
	move	$4,$5
	move	$5,$2
	jal	my_strcpy
	nop

	addiu	$2,$fp,24
	move	$4,$2
	lw	$5,1124($fp)
	jal	CheckConstraint
	nop

	beq	$2,$0,$L57
	nop

	lw	$2,1124($fp)
	nop
	addiu	$3,$2,1
	addiu	$2,$fp,24
	move	$4,$2
	move	$5,$3
	jal	SolveGame
	nop

	beq	$2,$0,$L57
	nop

	li	$2,1			# 0x1
	sw	$2,1104($fp)
	j	$L54
	nop

$L57:
	lw	$2,20($fp)
	nop
	addiu	$2,$2,1
	sw	$2,20($fp)
$L55:
	lw	$2,20($fp)
	nop
	slt	$2,$2,40
	bne	$2,$0,$L56
	nop

	sw	$0,1104($fp)
$L54:
	lw	$2,1104($fp)
	move	$sp,$fp
	lw	$31,1116($sp)
	lw	$fp,1112($sp)
	addiu	$sp,$sp,1120
	j	$31
	nop

	.set	macro
	.set	reorder
	.end	SolveGame
	.size	SolveGame, .-SolveGame
	.align	2
	.globl	main
	.ent	main
main:
	.frame	$fp,1112,$31		# vars= 1088, regs= 2/0, args= 16, gp= 0
	.mask	0xc0000000,-4
	.fmask	0x00000000,0
	.set	noreorder
	.set	nomacro
	
	addiu	$sp,$sp,-1112
	sw	$31,1108($sp)
	sw	$fp,1104($sp)
	move	$fp,$sp
	sw	$0,20($fp)
	j	$L64
	nop

$L65:
	lw	$2,20($fp)
	nop
	sll	$2,$2,2
	addiu	$3,$fp,16
	addu	$2,$2,$3
	li	$3,1			# 0x1
	sw	$3,928($2)
	lw	$2,20($fp)
	nop
	addiu	$2,$2,1
	sw	$2,20($fp)
$L64:
	lw	$2,20($fp)
	nop
	slt	$2,$2,40
	bne	$2,$0,$L65
	nop

	addiu	$2,$fp,24
	move	$4,$2
	move	$5,$0
	jal	SolveGame
	nop

	sw	$2,16($fp)
	lw	$2,16($fp)
	move	$sp,$fp
	lw	$31,1108($sp)
	lw	$fp,1104($sp)
	addiu	$sp,$sp,1112
	j	$31
	nop

	.set	macro
	.set	reorder
	.end	main
	.size	main, .-main
	.ident	"GCC: (GNU) 4.1.2"
