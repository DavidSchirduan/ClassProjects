#lang racket
;;This program was written solely by David Schirduan
;;Homework 2 part 2
;;9-21-11
;;For some reason, I am unable to put function calls within the definitions area for part 2.
;I have no idea why, but it always gives me an error. 


;;composition
;create a function to next another function
;;assumes x is the variable
(define (composition fun1 fun2);;need an x variable, otherwise it won't let me input a function
  (lambda (y) (fun1 (eval (fun2 y)))))

(define (tes1 x)
  (+ x x))

(define (tes2 y)
  (* y y))

(define (tes3 y)
  (- y y))

(define (tes4 y)
  (/ y y))
  
(display "Test of composition ;for some reason, it won't let me execute from within definitions. it runs fine though..\n")
(display "enter >(check 5)\n")
(define check (composition tes1 tes2))

;;construction
(define (construction lis a)
  (if (null? (cdr lis))
      (eval ((car lis) a));if empty, return the last answer
      (cons (eval ((car lis) a)) (construction (cdr lis) a))));else
      
(display "Test of construction. Should return (10 25 0 1)\n")
(define functions (list tes1 tes2 tes3 tes4))
(display "enter >(construction functions 5)")

;;applyToAll
(define (applyToAll funct lis)
  (if (null? (cdr lis))
      (funct (car lis));if list is empty, return last answer
      (cons (funct (car lis)) (applyToAll funct (cdr lis)))))
  
(display "Test of applyToAll. Should return (1 4 9 16 25)\n")
(define args (list 1 2 3 4 5))
(display "enter >(applyToAll tes2 args)")