	.file	"fib.c"
.globl MAX
	.section	.rodata
	.align 4
	.type	MAX, @object
	.size	MAX, 4
MAX:
	.long	13
.LC0:
	.string	"Usage: fib <num>\n"
	.align 8
.LC1:
	.string	"number must be between 0 and %d\n"
	.text
.globl main
	.type	main, @function
main:
.LFB1:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	movq	%rsp, %rbp
	.cfi_offset 6, -16
	.cfi_def_cfa_register 6
	subq	$32, %rsp
	movl	%edi, -20(%rbp)
	movq	%rsi, -32(%rbp)
	cmpl	$2, -20(%rbp)
	je	.L2
	movq	stderr(%rip), %rax
	movq	%rax, %rdx
	movl	$.LC0, %eax
	movq	%rdx, %rcx
	movl	$17, %edx
	movl	$1, %esi
	movq	%rax, %rdi
	call	fwrite
	movl	$-1, %edi
	call	exit
.L2:
	cmpl	$2, -20(%rbp)
	jle	.L3
	movl	$1, -4(%rbp)
.L3:
	movq	-32(%rbp), %rax
	addq	$8, %rax
	movq	(%rax), %rax
	movq	%rax, %rdi
	call	atoi
	movl	%eax, -8(%rbp)
	cmpl	$0, -8(%rbp)
	js	.L4
	movl	MAX(%rip), %eax
	cmpl	%eax, -8(%rbp)
	jle	.L5
.L4:
	movl	MAX(%rip), %edx
	movl	$.LC1, %ecx
	movq	stderr(%rip), %rax
	movq	%rcx, %rsi
	movq	%rax, %rdi
	movl	$0, %eax
	call	fprintf
	movl	$-1, %edi
	call	exit
.L5:
	movl	-8(%rbp), %eax
	movl	$1, %esi
	movl	%eax, %edi
	call	doFib
	movl	$0, %eax
	leave
	ret
	.cfi_endproc
.LFE1:
	.size	main, .-main
	.section	.rodata
.LC2:
	.string	"%d\n"
	.align 8
.LC3:
	.string	"Error, program %i ended incorrectly\n"
	.text
	.type	doFib, @function
doFib:
.LFB2:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	movq	%rsp, %rbp
	.cfi_offset 6, -16
	.cfi_def_cfa_register 6
	subq	$112, %rsp
	movl	%edi, -100(%rbp)
	movl	%esi, -104(%rbp)
	movl	$0, -84(%rbp)
	movl	$0, -16(%rbp)
	movl	$0, -12(%rbp)
	cmpl	$0, -100(%rbp)
	je	.L8
	cmpl	$1, -100(%rbp)
	jne	.L9
.L8:
	cmpl	$0, -104(%rbp)
	je	.L10
	movl	$.LC2, %eax
	movl	$1, %esi
	movq	%rax, %rdi
	movl	$0, %eax
	call	printf
	jmp	.L19
.L10:
	movl	$1, %edi
	call	exit
.L9:
	call	fork
	movl	%eax, -8(%rbp)
	cmpl	$0, -8(%rbp)
	jne	.L12
	movl	-100(%rbp), %eax
	subl	$1, %eax
	movl	$0, %esi
	movl	%eax, %edi
	call	doFib
.L12:
	cmpl	$0, -8(%rbp)
	je	.L13
	leaq	-84(%rbp), %rcx
	movl	-8(%rbp), %eax
	movl	$0, %edx
	movq	%rcx, %rsi
	movl	%eax, %edi
	call	waitpid
	movl	-84(%rbp), %eax
	movl	$0, -80(%rbp)
	movl	%eax, -80(%rbp)
	movl	-80(%rbp), %eax
	andl	$127, %eax
	testl	%eax, %eax
	jne	.L14
	movl	-84(%rbp), %eax
	movl	$0, -64(%rbp)
	movl	%eax, -64(%rbp)
	movl	-64(%rbp), %eax
	andl	$65280, %eax
	sarl	$8, %eax
	movl	%eax, -16(%rbp)
	jmp	.L13
.L14:
	call	getpid
	movl	%eax, %edx
	movl	$.LC3, %eax
	movl	%edx, %esi
	movq	%rax, %rdi
	movl	$0, %eax
	call	printf
.L13:
	call	fork
	movl	%eax, -4(%rbp)
	cmpl	$0, -4(%rbp)
	jne	.L15
	movl	-100(%rbp), %eax
	subl	$2, %eax
	movl	$0, %esi
	movl	%eax, %edi
	call	doFib
.L15:
	cmpl	$0, -4(%rbp)
	je	.L16
	leaq	-84(%rbp), %rcx
	movl	-4(%rbp), %eax
	movl	$0, %edx
	movq	%rcx, %rsi
	movl	%eax, %edi
	call	waitpid
	movl	-84(%rbp), %eax
	movl	$0, -48(%rbp)
	movl	%eax, -48(%rbp)
	movl	-48(%rbp), %eax
	andl	$127, %eax
	testl	%eax, %eax
	jne	.L17
	movl	-84(%rbp), %eax
	movl	$0, -32(%rbp)
	movl	%eax, -32(%rbp)
	movl	-32(%rbp), %eax
	andl	$65280, %eax
	sarl	$8, %eax
	movl	%eax, -12(%rbp)
	jmp	.L16
.L17:
	call	getpid
	movl	%eax, %edx
	movl	$.LC3, %eax
	movl	%edx, %esi
	movq	%rax, %rdi
	movl	$0, %eax
	call	printf
.L16:
	cmpl	$0, -104(%rbp)
	je	.L18
	movl	-12(%rbp), %eax
	movl	-16(%rbp), %edx
	addl	%eax, %edx
	movl	$.LC2, %eax
	movl	%edx, %esi
	movq	%rax, %rdi
	movl	$0, %eax
	call	printf
	jmp	.L19
.L18:
	movl	-12(%rbp), %eax
	movl	-16(%rbp), %edx
	leal	(%rdx,%rax), %eax
	movl	%eax, %edi
	call	exit
.L19:
	leave
	ret
	.cfi_endproc
.LFE2:
	.size	doFib, .-doFib
	.ident	"GCC: (Debian 4.4.5-8) 4.4.5"
	.section	.note.GNU-stack,"",@progbits
