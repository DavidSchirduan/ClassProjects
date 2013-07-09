#HP.s
#David Schirduan
#adds 2 flaoting point number numbers
#
#num1 = CCC00017    =   3435134999
#num2 = AF30009C    =   791675036
#
#
#
#$t0 = temp value of numA exp
#$t1 = temp value of numA mantissa
#$t2 = temp value of numB exp
#$t3 = temp value of numB mantissa
#$t4 =      value of answer exp
#$t5 =      value of answer mantissa
#$t6 = temp value of masked bit exp
#$t7 = test bit for neg exp
#$t8 = test bit for neg exp
#$s0 = value for exp negative testing
#$s1 = value for exp negative testing
#$s2 = max value for exp overflow testing
#$s3 = max value for mant overflow testing
#$s4 = value for masking at end


	
start:

#simple test

	li	$t0,0			#test to see input
	li	$t1,3435134999
	li	$t2,0
	li	$t3,3435134999
	li 	$s0,2048
	li 	$s1,388608
	li	$s2,4095
	li 	$s3,16777215
	li 	$s4,2147483648

	
	#split into mantissa seperate
        andi $t0, $t1, 255
	andi $t0, $t3, 255

        #find out which ones are negative
        andi $s0, $t0, 1
        andi $s1, $t2, 1

        #convert the negative exponents to 2's complement
        
        beq $s0, $zero, Apos

Aneg:
        srl $t0, $t0, 1     #cuts off the sign bit
        nor $t0, $t0, $zero #changes it to two's complement
        addi $t0, $t0, 1    #adds1

Apos:
        beq $s1, $zero, Bpos

Bneg:
        srl $t2, $t2, 1     #cuts off the sign bit
        nor $t2, $t2, $zero #changes it to two's complement
        addi $t2, $t2, 1    #adds1

Bpos:

	#first need to get them with equal exponents to add

	bgt $t0, $t2, AgreaterB
	
BgreaterA:			#adds until A=B

	beq $t0, $t2, AequalB
	srl $t1, $t1, 1		#shifts mantissa
	addi $t0, $t0, 1	#adds 1 to exp
	#bgt $t0, $s2, OVERFLOW	#test for overflow
	j BgreaterA
	
AgreaterB:			#adds until B=A

	beq $t0, $t2, AequalB
	srl $t3, $t3, 1		#shifts mantissa
	addi $t2, $t2, 1	#adds 1 to exp
	#bgt $t0, $s2, OVERFLOW	#test for overflow

	j AgreaterB
	
AequalB:
	
	
	#now here's the tricky part.
	#to handle overflow, gotta srl 8 and increase exp by 8
	#temporarily using those 2 bits that we aren't allowed to use
	
	srl $t1, $t1, 8
	addi $t0, $t0, 8
	srl $t3, $t3, 8
	addi $t2, $t2, 8

	#now just add them
	add $t5, $t1, $t3
	
	#create a loop to reinitialize the mantissa
	
reinitialize:
	and $t6, $t5, $s4		#checks first bit
	bgt $t6, $zero, end		#if first bit is one, end loop, no adjustment necessary
	sll $t5, $t5, 1			#else shift left and sub from exp
	addi $t2, $t2, -1		#decrease exp
	j reinitialize

	
end:
	
	#I'm just going to mask off these bits to avoid overflow
	srl $t1, $t1, 8
	srl $t3, $t3, 8
	sll $t1, $t1, 8
	sll $t3, $t3, 8
	
	#also masking exponents just for sure
	sll $t0, $t0, 24
	sll $t2, $t2, 24
	srl $t0, $t0, 24
	srl $t2, $t2, 24
	
OVERFLOW:
	
	
	li $v0,10		#exit
	syscall			# make system call