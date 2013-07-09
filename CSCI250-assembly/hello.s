	# hello.s (list the name of the program on the first line)
	#
	# (NOTE: pound/sharp signs are used for comments)
	# (next, list what the program does, as follows:)
	#
	# A SPIM program that prints out "hello world" in the SPIM console
	# window.
	#
	# (next, list your register usage.  For clarity on the first
	# programs, you should not reuse registers for different
	# purposes, unless you must.
	#
	# a0 - points to a string that will be printed out
	# v0 - contains the code for the system call
	#
	# The DATA segment comes next.  This is where you define all
	# singleton variables and arrays that you will need.  You must
	# first put the ".data" directive on a single line.
	#
	.data
	str:	.asciiz "hello world\n"   # zero terminated string
	#
	# The TEXT segment comes next.  This is where you list the
	# executable statements.  You must first put the ".text" directive
	# on a single line, followed by "main:" on a single line,
	# as seen below.
	#
	.text
main:				# execution will start here
	la $a0,str		# put string address into register a0
				# NOTE: li is a pseudo instruction
	li $v0,4		# system call code (4) to print string
	syscall			# make system call to print string

	li $v0,10		# system call code (10) to exit
	syscall			# make system call to exit
