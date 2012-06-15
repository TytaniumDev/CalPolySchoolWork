	.file	1 "shang.c"
	.section .mdebug.abi32
	.previous
	.text
	.align	2
	.globl	initGame
	.ent	initGame
initGame:
	.frame	$sp,0,$31		# vars= 0, regs= 0/0, args= 0, gp= 0
	.mask	0x00000000,0
	.fmask	0x00000000,0
	.set	noreorder
	.set	nomacro
	
	j	$L2
	move	$8,$0

$L3:
	lbu	$2,0($7)
	nop
	sb	$2,0($6)
	addiu	$3,$3,1
	addiu	$7,$7,1
	li	$2,21			# 0x15
	bne	$3,$2,$L3
	addiu	$6,$6,1

	addiu	$8,$8,1
	li	$2,40			# 0x28
	bne	$8,$2,$L20
	sll	$2,$8,2

	move	$6,$0
	move	$9,$4
	move	$8,$5
	li	$7,80			# 0x50
$L6:
	addu	$2,$6,$5
	addu	$3,$4,$6
	lw	$3,840($3)
	addiu	$6,$6,4
	bne	$6,$7,$L6
	sw	$3,840($2)

	move	$4,$0
	li	$5,160			# 0xa0
	addu	$2,$4,$8
$L19:
	addu	$3,$4,$9
	lw	$3,920($3)
	addiu	$4,$4,4
	beq	$4,$5,$L21
	sw	$3,920($2)

	j	$L19
	addu	$2,$4,$8

$L2:
	sll	$2,$8,2
$L20:
	sll	$3,$8,4
	addu	$2,$2,$3
	addu	$2,$2,$8
	addu	$7,$4,$2
	addu	$6,$5,$2
	j	$L3
	move	$3,$0

$L21:
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
	.frame	$sp,0,$31		# vars= 0, regs= 0/0, args= 0, gp= 0
	.mask	0x00000000,0
	.fmask	0x00000000,0
	.set	noreorder
	.set	nomacro
	
	blez	$6,$L34
	move	$2,$0

	lb	$7,0($4)
	lb	$3,0($5)
	nop
	slt	$2,$7,$3
	bne	$2,$0,$L25
	nop

	slt	$2,$3,$7
	bne	$2,$0,$L27
	move	$8,$0

	j	$L35
	addiu	$8,$8,1

$L30:
	addu	$2,$4,$8
	lb	$7,0($2)
	addu	$2,$5,$8
	lb	$3,0($2)
	nop
	slt	$2,$7,$3
	bne	$2,$0,$L25
	nop

	slt	$2,$3,$7
	bne	$2,$0,$L27
	addiu	$8,$8,1

$L35:
	bne	$6,$8,$L30
	move	$2,$0

	j	$L34
	nop

$L25:
	j	$31
	li	$2,-1			# 0xffffffffffffffff

$L27:
	j	$31
	li	$2,1			# 0x1

$L34:
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
	.frame	$sp,0,$31		# vars= 0, regs= 0/0, args= 0, gp= 0
	.mask	0x00000000,0
	.fmask	0x00000000,0
	.set	noreorder
	.set	nomacro
	
$L37:
	move	$2,$5
	lbu	$3,0($5)
	nop
	sb	$3,0($4)
	addiu	$5,$5,1
	lb	$2,1($2)
	nop
	bne	$2,$0,$L37
	addiu	$4,$4,1

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
	.frame	$sp,608,$31		# vars= 560, regs= 7/0, args= 16, gp= 0
	.mask	0x803f0000,-8
	.fmask	0x00000000,0
	.set	noreorder
	.set	nomacro
	
	addiu	$sp,$sp,-608
	sw	$31,600($sp)
	sw	$21,596($sp)
	sw	$20,592($sp)
	sw	$19,588($sp)
	sw	$18,584($sp)
	sw	$17,580($sp)
	sw	$16,576($sp)
	move	$21,$5
	j	$L43
	move	$7,$0

$L44:
	lbu	$2,0($6)
	nop
	sb	$2,0($3)
	addiu	$5,$5,1
	addiu	$6,$6,21
	li	$2,20			# 0x14
	bne	$5,$2,$L44
	addiu	$3,$3,1

	addiu	$7,$7,1
	bne	$7,$5,$L69
	addu	$6,$4,$7

	move	$5,$0
	addiu	$7,$sp,416
	li	$6,160			# 0xa0
	addu	$2,$7,$5
$L68:
	addu	$3,$5,$4
	lw	$3,920($3)
	addiu	$5,$5,4
	beq	$5,$6,$L66
	sw	$3,0($2)

	j	$L68
	addu	$2,$7,$5

$L49:
	lw	$2,0($16)
	nop
	beq	$2,$0,$L50
	move	$4,$18

	move	$5,$19
	jal	my_strncmp
	addiu	$6,$21,1

	bne	$2,$0,$L70
	addiu	$17,$17,1

	addiu	$17,$17,-1
	addiu	$20,$20,20
	addiu	$2,$sp,416
	beq	$2,$20,$L59
	sll	$2,$17,2

	addu	$2,$sp,$2
	j	$L56
	sw	$0,416($2)

$L50:
	addiu	$17,$17,1
$L70:
	addiu	$16,$16,4
	li	$2,40			# 0x28
	bne	$17,$2,$L49
	addiu	$18,$18,21

	j	$L55
	move	$2,$0

$L43:
	addu	$6,$4,$7
$L69:
	sll	$2,$7,2
	sll	$3,$7,4
	addu	$2,$2,$3
	addiu	$3,$sp,16
	addu	$3,$3,$2
	j	$L44
	move	$5,$0

$L66:
	addiu	$20,$sp,16
$L56:
	move	$19,$20
	lui	$2,%hi(g_mainSetting)
	addiu	$18,$2,%lo(g_mainSetting)
	move	$17,$0
	j	$L49
	addiu	$16,$sp,416

$L59:
	li	$2,1			# 0x1
$L55:
	lw	$31,600($sp)
	lw	$21,596($sp)
	lw	$20,592($sp)
	lw	$19,588($sp)
	lw	$18,584($sp)
	lw	$17,580($sp)
	lw	$16,576($sp)
	j	$31
	addiu	$sp,$sp,608

	.set	macro
	.set	reorder
	.end	CheckConstraint
	.size	CheckConstraint, .-CheckConstraint
	.align	2
	.globl	SolveGame
	.ent	SolveGame
SolveGame:
	.frame	$sp,1136,$31		# vars= 1080, regs= 10/0, args= 16, gp= 0
	.mask	0xc0ff0000,-4
	.fmask	0x00000000,0
	.set	noreorder
	.set	nomacro
	
	addiu	$sp,$sp,-1136
	sw	$31,1132($sp)
	sw	$fp,1128($sp)
	sw	$23,1124($sp)
	sw	$22,1120($sp)
	sw	$21,1116($sp)
	sw	$20,1112($sp)
	sw	$19,1108($sp)
	sw	$18,1104($sp)
	sw	$17,1100($sp)
	sw	$16,1096($sp)
	move	$21,$4
	li	$2,20			# 0x14
	beq	$5,$2,$L72
	move	$20,$5

	sll	$2,$5,2
	sll	$3,$5,4
	addu	$2,$2,$3
	addu	$2,$2,$5
	addiu	$3,$sp,16
	addu	$23,$3,$2
	lui	$2,%hi(g_mainSetting)
	addiu	$19,$2,%lo(g_mainSetting)
	move	$18,$0
	move	$17,$0
	move	$fp,$3
	sll	$22,$5,2
$L74:
	addu	$2,$21,$17
	lw	$2,920($2)
	nop
	beq	$2,$0,$L75
	move	$4,$21

	jal	initGame
	move	$5,$fp

	addu	$2,$22,$fp
	sw	$18,840($2)
	addu	$2,$17,$fp
	sw	$0,920($2)
	move	$4,$23
	jal	my_strcpy
	move	$5,$19

	move	$4,$fp
	jal	CheckConstraint
	move	$5,$20

	beq	$2,$0,$L75
	move	$4,$fp

	jal	SolveGame
	addiu	$5,$20,1

	bne	$2,$0,$L83
	li	$2,1			# 0x1

$L75:
	addiu	$18,$18,1
	addiu	$17,$17,4
	li	$2,40			# 0x28
	bne	$18,$2,$L74
	addiu	$19,$19,21

	j	$L79
	move	$2,$0

$L72:
	li	$2,1			# 0x1
$L79:
$L83:
	lw	$31,1132($sp)
	lw	$fp,1128($sp)
	lw	$23,1124($sp)
	lw	$22,1120($sp)
	lw	$21,1116($sp)
	lw	$20,1112($sp)
	lw	$19,1108($sp)
	lw	$18,1104($sp)
	lw	$17,1100($sp)
	lw	$16,1096($sp)
	j	$31
	addiu	$sp,$sp,1136

	.set	macro
	.set	reorder
	.end	SolveGame
	.size	SolveGame, .-SolveGame
	.align	2
	.globl	main
	.ent	main
main:
	.frame	$sp,1104,$31		# vars= 1080, regs= 1/0, args= 16, gp= 0
	.mask	0x80000000,-8
	.fmask	0x00000000,0
	.set	noreorder
	.set	nomacro
	
	addiu	$sp,$sp,-1104
	sw	$31,1096($sp)
	addiu	$2,$sp,936
	li	$4,1			# 0x1
	addiu	$3,$sp,1096
$L85:
	sw	$4,0($2)
	addiu	$2,$2,4
	bne	$2,$3,$L85
	nop

	addiu	$4,$sp,16
	jal	SolveGame
	move	$5,$0

	lw	$31,1096($sp)
	nop
	j	$31
	addiu	$sp,$sp,1104

	.set	macro
	.set	reorder
	.end	main
	.size	main, .-main
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
	.ident	"GCC: (GNU) 4.1.2"
