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
	
	move	$8,$4
	move	$7,$0
	sll	$3,$7,4
$L20:
	sll	$2,$7,2
	addu	$2,$2,$3
	addu	$2,$2,$7
	addu	$6,$5,$2
	addu	$4,$8,$2
	move	$3,$0
$L3:
	lbu	$2,0($4)
	addiu	$3,$3,1
	sb	$2,0($6)
	li	$2,21			# 0x15
	addiu	$4,$4,1
	bne	$3,$2,$L3
	addiu	$6,$6,1

	addiu	$7,$7,1
	li	$2,40			# 0x28
	bne	$7,$2,$L20
	sll	$3,$7,4

	move	$6,$0
	li	$7,80			# 0x50
$L6:
	addu	$2,$8,$6
	lw	$4,840($2)
	addu	$3,$6,$5
	addiu	$6,$6,4
	bne	$6,$7,$L6
	sw	$4,840($3)

	move	$6,$0
	li	$7,160			# 0xa0
$L8:
	addu	$2,$6,$8
	lw	$4,920($2)
	addu	$3,$6,$5
	addiu	$6,$6,4
	bne	$6,$7,$L8
	sw	$4,920($3)

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
	
	blez	$6,$L22
	nop

	lb	$7,0($4)
	lb	$3,0($5)
	nop
	slt	$2,$7,$3
	bne	$2,$0,$L24
	nop

	slt	$2,$3,$7
	bne	$2,$0,$L26
	move	$8,$0

	j	$L33
	addiu	$8,$8,1

$L29:
	lb	$2,0($2)
	lb	$3,0($3)
	nop
	slt	$7,$3,$2
	slt	$2,$2,$3
	bne	$2,$0,$L24
	nop

	bne	$7,$0,$L26
	addiu	$8,$8,1

$L33:
	addu	$2,$4,$8
	bne	$6,$8,$L29
	addu	$3,$8,$5

$L22:
	j	$31
	move	$2,$0

$L24:
	j	$31
	li	$2,-1			# 0xffffffffffffffff

$L26:
	j	$31
	li	$2,1			# 0x1

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
	
	move	$6,$4
$L35:
	lbu	$2,0($5)
	nop
	sb	$2,0($6)
	lb	$4,1($5)
	addiu	$6,$6,1
	bne	$4,$0,$L35
	addiu	$5,$5,1

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
	.frame	$sp,560,$31		# vars= 560, regs= 0/0, args= 0, gp= 0
	.mask	0x00000000,0
	.fmask	0x00000000,0
	.set	noreorder
	.set	nomacro
	
	addiu	$sp,$sp,-560
	move	$8,$4
	move	$7,$0
	addiu	$9,$sp,160
	sll	$3,$7,4
$L72:
	sll	$2,$7,2
	addu	$2,$2,$3
	addu	$6,$9,$2
	addu	$3,$8,$7
	move	$4,$0
$L42:
	lbu	$2,0($3)
	addiu	$4,$4,1
	sb	$2,0($6)
	li	$2,20			# 0x14
	addiu	$3,$3,21
	bne	$4,$2,$L42
	addiu	$6,$6,1

	addiu	$7,$7,1
	bne	$7,$4,$L72
	sll	$3,$7,4

	move	$6,$0
	li	$7,160			# 0xa0
$L45:
	addu	$2,$8,$6
	lw	$4,920($2)
	addu	$3,$sp,$6
	addiu	$6,$6,4
	bne	$6,$7,$L45
	sw	$4,0($3)

	move	$11,$9
	addiu	$12,$5,1
	lui	$13,%hi(g_mainSetting)
$L47:
	addiu	$2,$13,%lo(g_mainSetting)
	addiu	$9,$2,1
	move	$10,$0
	move	$8,$sp
$L48:
	lw	$2,0($8)
	nop
	beq	$2,$0,$L49
	nop

	blez	$12,$L51
	nop

	lb	$4,-1($9)
	lb	$3,0($11)
	nop
	slt	$2,$4,$3
	bne	$2,$0,$L49
	slt	$2,$3,$4

	bne	$2,$0,$L49
	move	$4,$9

	j	$L55
	move	$7,$0

$L56:
	lb	$3,1($2)
	lb	$2,0($4)
	addiu	$7,$7,1
	slt	$6,$3,$2
	slt	$2,$2,$3
	bne	$2,$0,$L49
	addiu	$4,$4,1

	bne	$6,$0,$L49
	nop

$L55:
	bne	$7,$5,$L56
	addu	$2,$7,$11

$L51:
	addiu	$11,$11,20
	addiu	$2,$sp,560
	beq	$11,$2,$L71
	sll	$2,$10,2

	addu	$2,$2,$sp
	j	$L47
	sw	$0,0($2)

$L49:
	addiu	$10,$10,1
	li	$2,40			# 0x28
	addiu	$8,$8,4
	bne	$10,$2,$L48
	addiu	$9,$9,21

	move	$2,$0
	j	$31
	addiu	$sp,$sp,560

$L71:
	li	$2,1			# 0x1
	j	$31
	addiu	$sp,$sp,560

	.set	macro
	.set	reorder
	.end	CheckConstraint
	.size	CheckConstraint, .-CheckConstraint
	.align	2
	.globl	SolveGame
	.ent	SolveGame
SolveGame:
	.frame	$sp,1704,$31		# vars= 1648, regs= 10/0, args= 16, gp= 0
	.mask	0xc0ff0000,-4
	.fmask	0x00000000,0
	.set	noreorder
	.set	nomacro
	
	addiu	$sp,$sp,-1704
	li	$2,20			# 0x14
	sw	$18,1672($sp)
	sw	$17,1668($sp)
	sw	$31,1700($sp)
	sw	$fp,1696($sp)
	sw	$23,1692($sp)
	sw	$22,1688($sp)
	sw	$21,1684($sp)
	sw	$20,1680($sp)
	sw	$19,1676($sp)
	sw	$16,1664($sp)
	move	$17,$5
	beq	$5,$2,$L74
	move	$18,$4

	sll	$2,$5,2
	sw	$2,1656($sp)
	lw	$3,1656($sp)
	sll	$2,$5,4
	addu	$2,$3,$2
	addu	$2,$2,$5
	addiu	$16,$sp,576
	lui	$fp,%hi(g_mainSetting)
	addu	$23,$16,$2
	addiu	$20,$5,1
	addiu	$22,$fp,%lo(g_mainSetting)
	move	$21,$0
	move	$19,$0
$L76:
	addu	$2,$18,$19
	lw	$3,920($2)
	nop
	beq	$3,$0,$L78
	move	$6,$0

	sll	$3,$6,4
$L131:
	sll	$2,$6,2
	addu	$2,$2,$3
	addu	$2,$2,$6
	addu	$5,$16,$2
	addu	$4,$18,$2
	move	$3,$0
$L79:
	lbu	$2,0($4)
	addiu	$3,$3,1
	sb	$2,0($5)
	li	$2,21			# 0x15
	addiu	$4,$4,1
	bne	$3,$2,$L79
	addiu	$5,$5,1

	addiu	$6,$6,1
	li	$2,40			# 0x28
	bne	$6,$2,$L131
	sll	$3,$6,4

	move	$5,$0
	li	$6,80			# 0x50
$L83:
	addu	$2,$5,$18
	lw	$4,840($2)
	addu	$3,$5,$16
	addiu	$5,$5,4
	bne	$5,$6,$L83
	sw	$4,840($3)

	move	$5,$0
	li	$6,160			# 0xa0
$L85:
	addu	$2,$5,$18
	lw	$4,920($2)
	addu	$3,$5,$16
	addiu	$5,$5,4
	bne	$5,$6,$L85
	sw	$4,920($3)

	lw	$3,1656($sp)
	addiu	$11,$sp,16
	addu	$2,$3,$11
	addu	$3,$19,$16
	sw	$21,1400($2)
	sw	$0,920($3)
	move	$5,$22
	move	$6,$23
$L87:
	lbu	$2,0($5)
	nop
	sb	$2,0($6)
	lb	$4,1($5)
	addiu	$6,$6,1
	bne	$4,$0,$L87
	addiu	$5,$5,1

	move	$6,$0
	addiu	$7,$sp,176
	sll	$3,$6,4
$L132:
	sll	$2,$6,2
	addu	$2,$2,$3
	addu	$5,$7,$2
	addu	$3,$16,$6
	move	$4,$0
$L89:
	lbu	$2,0($3)
	addiu	$4,$4,1
	sb	$2,0($5)
	li	$2,20			# 0x14
	addiu	$3,$3,21
	bne	$4,$2,$L89
	addiu	$5,$5,1

	addiu	$6,$6,1
	bne	$6,$4,$L132
	sll	$3,$6,4

	move	$5,$0
	li	$6,160			# 0xa0
$L93:
	addu	$2,$5,$16
	lw	$4,920($2)
	addu	$3,$11,$5
	addiu	$5,$5,4
	bne	$5,$6,$L93
	sw	$4,0($3)

	move	$10,$7
$L95:
	addiu	$2,$fp,%lo(g_mainSetting)
	addiu	$9,$2,1
	move	$8,$0
	move	$7,$11
$L96:
	lw	$2,0($7)
	nop
	beq	$2,$0,$L97
	nop

	blez	$20,$L133
	sll	$2,$8,2

	lb	$4,-1($9)
	lb	$3,0($10)
	nop
	slt	$2,$4,$3
	bne	$2,$0,$L97
	slt	$2,$3,$4

	bne	$2,$0,$L97
	move	$4,$9

	j	$L103
	move	$6,$0

$L104:
	lb	$3,1($2)
	lb	$2,0($4)
	addiu	$6,$6,1
	slt	$5,$3,$2
	slt	$2,$2,$3
	bne	$2,$0,$L97
	addiu	$4,$4,1

	bne	$5,$0,$L97
	nop

$L103:
	bne	$17,$6,$L104
	addu	$2,$6,$10

	sll	$2,$8,2
$L133:
	addu	$2,$2,$11
	addiu	$10,$10,20
	bne	$10,$16,$L95
	sw	$0,0($2)

	move	$4,$16
	jal	SolveGame
	move	$5,$20

	bne	$2,$0,$L107
	li	$2,1			# 0x1

$L78:
	addiu	$21,$21,1
	li	$2,40			# 0x28
$L130:
	addiu	$19,$19,4
	bne	$21,$2,$L76
	addiu	$22,$22,21

	move	$2,$0
$L107:
	lw	$31,1700($sp)
	lw	$fp,1696($sp)
	lw	$23,1692($sp)
	lw	$22,1688($sp)
	lw	$21,1684($sp)
	lw	$20,1680($sp)
	lw	$19,1676($sp)
	lw	$18,1672($sp)
	lw	$17,1668($sp)
	lw	$16,1664($sp)
	j	$31
	addiu	$sp,$sp,1704

$L97:
	addiu	$8,$8,1
	li	$2,40			# 0x28
	addiu	$7,$7,4
	bne	$8,$2,$L96
	addiu	$9,$9,21

	j	$L130
	addiu	$21,$21,1

$L74:
	j	$L107
	li	$2,1			# 0x1

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
	addiu	$4,$sp,1096
	li	$3,1			# 0x1
$L135:
	sw	$3,0($2)
	addiu	$2,$2,4
	bne	$2,$4,$L135
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
