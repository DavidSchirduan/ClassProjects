	# length.s
	#
	# A SPIM program that prints out the length of the string, str,
	# in the SPIM console window.
	#
	# a0 - points to a string that will be printed out OR
	#    - contains the integer/char that will be printed out
	# v0 - contains the code for the system calls
	# t0 - contains each successive character from string, str
	# t1 - counter for the length
	# t2 - running pointer through the string
	#
	.data
	str:		.asciiz "hello world"
	msg:		.asciiz "Length is "
	#
	.text
main:				# execution will start here
	la $t2,str		# put string address into register t2
	li $t1,0		# initialize length counter to zero
nextCh:
	lb $t0,($t2)		# get next char from the string
	beqz $t0,strEnd		# zero (or NULL char) means end of string
	addi $t1,$t1,1		# increment the counter
	addi $t2,$t2,1		# advance the pointer one more character
	j nextCh		# loop again
	
strEnd:
	la $a0,msg		# put string, msg, address into register a0
	li $v0,4		# system call code (4) to print string
	syscall			# make system call to print string
				# NOTE: move is a pseudo instruction
	move $a0,$t1		# put integer length into register a0
	li $v0,1		# system call code (1) to print integer
	syscall			# make system call to print length
	
	li $v0,10		# system call code (10) to exit
	syscall			# make system call to exit
