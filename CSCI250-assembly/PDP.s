#PDP.s
#David Schirduan
#adds 2 flaoting point number numbers
#test is -7.875 + 0.203125 = -7.671875
#-7.875 in binary:
#	-0111.111 => -.111111 x 2^3 (since no hidden 1) => exp: 0x003 mantissa: (inverse of 0xF30000) 1CFFFF
# 	I guess I can store the mantissa seperate from the exponent: $t0 = expA,$t1 = mantA.
#	$t0 = 3,$t1 = 1900543
#
# 0.203125 in binary:
#	+ 0.001101 => .1101 x 2^-2 => exp: 0xFFE mantissa: 0xD00000
# 	I guess I can store the mantissa seperate from the exponent: $t2 = expB,$t3 = mantB.
#	$t2 = 4094,$t3 = 13631488
#
#




#$t0 = temp value of numA exp
#$t1 = temp value of numA mantissa
#$t2 = temp value of numB exp
#$t3 = temp value of numB mantissa
#$t4 =      value of answer exp
#$t5 =      value of answer mantissa
#$t6 = temp value of masked bit
#$t7 = temp value of masked bit
#$s0 = max value for exp negative testing
#$s1 = max value for mant negative testing
#$s2 = max value for exp overflow testing
#$s3 = max value for mant overflow testing
#$s4 = value for masking at end


	
start:

#	li	$t0,3			#test to see input
#	li	$t1,1900543
#	li	$t2,4094	
#	li	$t3,13631488	
#	li 	$s0,2048
#	li 	$s1,388608
#	li	$s2,4095
#	li 	$s3,16777215
#	li 	$s4,2147483648

#simple test

	li	$t0,-7			#test to see input
	li	$t1,16
	li	$t2,4	
	li	$t3,32	
	li 	$s0,2048
	li 	$s1,388608
	li	$s2,4095
	li 	$s3,16777215
	li 	$s4,2147483648

	
	#shift mantissa to account for bit limit
	sll $t1, $t1, 8
	sll $t3, $t3, 8
	

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
	
	#now that their exponents are equal
	#Should I round now or round later? 
	#I'm just going to mask off these bits
	srl $t1, $t1, 8
	srl $t3, $t3, 8
	sll $t1, $t1, 8
	sll $t3, $t3, 8
	
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