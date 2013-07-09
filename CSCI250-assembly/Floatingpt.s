	#schirduan_floatingpt.s
	#
	#a MIPS program that adds together 
	#two different formats of binary floating point
	#
	#$t0 is num1
	#$t1 is num2
	#$t2 is used for overflowtest
	#$t4 is the results of the masking
	#$t5 is simply 1, for testing purposes
	#$t6 is the final answer
	#$v0 holds the inputed values
	#$a0 is the accepted output register

	.data
	str:		.asciiz "enter the two numbers to be added in DEC PDP-8 format:\n"
	str2:		.asciiz "error: overflow"

	.text
	
input:
	la $a0,str		#inputs the string into t3
	li $v0,4
	syscall

	li,$v0,5 		#inputs the two values
	syscall			#calls the system
	add $t0,$zero,$v0	#saves the value in t0

	li,$v0,5 		#inputs the two values
	syscall			#calls the system
	add $t1,$zero,$v0	#saves the value in t1

	addi $t5, $zero, 1	#sets t5 to 1
	
negtest: 	
	andi $t4, $t0, 1 	#masking
	beq $t5,$t4, negative 	#if the value is 1, branch
	j loop			#skips over the neg addition

negative:
	add $t6, $t6, $t1 	#adds to the answser

loop:
	srl $t0,$t0, 1		#shifts num1 right		
	sll $t1,$t1, 1		#shifts num2 left
	
	add $t2, $t1, $t0 	#tests for overflow
	blt $t2, $t1, error	#if the added value is less then, then it branches to error
	blt $t2, $t0, error	#if the added value is less then, then it branches to error
	
	beq $t0,$zero, fin	#if num1 == 0, leave loop
	j negtest	

fin:
	add $a0, $t6, $zero	#moves the answer to a0 	
	li $v0,1		#call to print value
	syscall

	li $v0,10		#exit
	syscall			# make system call

error:
	la $a0,str2		#inputs the string into a0
	li $v0,4
	syscall






