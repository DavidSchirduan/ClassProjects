	.file	"handle.c"
.globl usr_interrupt
	.data
	.align 4
	.type	usr_interrupt, @object
	.size	usr_interrupt, 4
usr_interrupt:
	.long	1
	.section	.rodata
.LC0:
	.string	"Exiting\n"
	.text
.globl usr1handler
	.type	usr1handler, @function
usr1handler:
.LFB0:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	movq	%rsp, %rbp
	.cfi_offset 6, -16
	.cfi_def_cfa_register 6
	subq	$32, %rsp
	movl	%edi, -20(%rbp)
	movl	$0, usr_interrupt(%rip)
	movl	$1, -4(%rbp)
	movl	-4(%rbp), %eax
	movl	$10, %edx
	movl	$.LC0, %esi
	movl	%eax, %edi
	call	write
	movq	%rax, -16(%rbp)
	cmpq	$10, -16(%rbp)
	je	.L3
	movl	$-999, %edi
	call	exit
.L3:
	leave
	ret
	.cfi_endproc
.LFE0:
	.size	usr1handler, .-usr1handler
	.section	.rodata
.LC1:
	.string	"Nice try.\n"
	.text
.globl ctrlchandler
	.type	ctrlchandler, @function
ctrlchandler:
.LFB1:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	movq	%rsp, %rbp
	.cfi_offset 6, -16
	.cfi_def_cfa_register 6
	subq	$32, %rsp
	movl	%edi, -20(%rbp)
	movl	$1, -4(%rbp)
	movl	-4(%rbp), %eax
	movl	$10, %edx
	movl	$.LC1, %esi
	movl	%eax, %edi
	call	write
	movq	%rax, -16(%rbp)
	cmpq	$10, -16(%rbp)
	je	.L6
	movl	$-999, %edi
	call	exit
.L6:
	leave
	ret
	.cfi_endproc
.LFE1:
	.size	ctrlchandler, .-ctrlchandler
	.section	.rodata
.LC2:
	.string	"%d\n"
.LC3:
	.string	"Still here\n"
	.text
.globl main
	.type	main, @function
main:
.LFB2:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	movq	%rsp, %rbp
	.cfi_offset 6, -16
	.cfi_def_cfa_register 6
	subq	$80, %rsp
	movl	%edi, -68(%rbp)
	movq	%rsi, -80(%rbp)
	call	getpid
	movl	%eax, -20(%rbp)
	movl	$.LC2, %eax
	movl	-20(%rbp), %edx
	movl	%edx, %esi
	movq	%rax, %rdi
	movl	$0, %eax
	call	printf
	movl	$ctrlchandler, %esi
	movl	$2, %edi
	call	signal
	movl	$usr1handler, %esi
	movl	$10, %edi
	call	signal
	jmp	.L8
.L10:
	movl	$1, -4(%rbp)
	movl	-4(%rbp), %eax
	movl	$12, %edx
	movl	$.LC3, %esi
	movl	%eax, %edi
	call	write
	movq	%rax, -16(%rbp)
	cmpq	$12, -16(%rbp)
	je	.L9
	movl	$-999, %edi
	call	exit
.L9:
	movq	$1, -48(%rbp)
	movq	$0, -40(%rbp)
	leaq	-64(%rbp), %rdx
	leaq	-48(%rbp), %rax
	movq	%rdx, %rsi
	movq	%rax, %rdi
	call	nanosleep
.L8:
	movl	usr_interrupt(%rip), %eax
	testl	%eax, %eax
	jne	.L10
	movl	$1, %eax
	leave
	ret
	.cfi_endproc
.LFE2:
	.size	main, .-main
	.ident	"GCC: (Debian 4.4.5-8) 4.4.5"
	.section	.note.GNU-stack,"",@progbits
