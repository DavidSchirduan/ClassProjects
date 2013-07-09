#lang racket
;;created by David Schirduan 9-8-11 Homework 1

;; computer square of a number
(define (square x) (* x x))

(display "Test of square 5; should result in 25 \n")
(square 5) 

;;; This is the code for homework 1.

;;calls p2 and p3
(define (p1 x y)
 (+ (p2 x y) (p3 x y)))

;;is the root of the other functions, never calls them, is only called
(define (p2 z w)
 (* z w))

;;calls p2 as well
(define (p3 a b)
 (+ (p2 a b) (p2 b a)));;I added 2 arguments to the p2 caller

;;tests the definitions
(display "Test of p1 1 2; should result in 6 \n")
(p1 1 2)

;;recursive statements
;; Returns the units digit of the integer n 
(define (units-digit n) 
  (remainder n 10))

;; Returns all but the units digit of the integer n 
(define (all-but-units-digit n) 
  (quotient n 10))

;;returns the leading and most significant digit
(define (leading-digit n)
  (if (equal? (all-but-units-digit n) 0)
      n ;;do this
      (leading-digit (all-but-units-digit n))));;else

;;returns the number of digits
(define (decimal-length n)
  (if (equal? (all-but-units-digit n) 0)
      1
      (+ 1 (decimal-length (all-but-units-digit n)))));else do this
  
;;returns the ith digit of n 
(define (ith-digit n i)
  (if (equal? (units-digit n) i)
      1
      (+ 1 (ith-digit (all-but-units-digit n) i))));else do this

;shows the number of occurences of d within n
(define (occurences d n)
  (if (equal? (units-digit n) 0)
      0 
      (if (equal? (units-digit n) d); else
          (+ 1 (occurences d (all-but-units-digit n)))
          (occurences d (all-but-units-digit n))))); else

;returns the sum of the digits in n
(define (digit-sum n)
  (if (equal? (units-digit n) 0)
      0
      (+ (units-digit n) (digit-sum (all-but-units-digit n)))));else

;applies digit sum until it's one digit //finds the root kinda
(define (digital-root n)
  (if (equal? (all-but-units-digit n) 0)
      n
      (digital-root (digit-sum n))));else

;returns the number backwards
(define (backwards n)
  (define x 10)
  (if (equal? (all-but-units-digit n) 0)
      n 
      (+ (* x (units-digit n)) (backwards (all-but-units-digit n)))));else


;;test statements
(display "Test of units-digit 12345 \n")
(units-digit 12345)

(display "Test of all-but-units-digit 12345 \n")
(all-but-units-digit 12345)

(display "Test of leading-digit 12345 \n")
(leading-digit 12345)

(display "Test of decimal-length 12345 \n")
(decimal-length 12345)

(display "Test of ith-digit 12345 2 \n")
(ith-digit 12345 2)

(display "Test of occurences 2 123451234512345 \n")
(occurences 2 123451234512345)

(display "Test of digit-sum 12345 \n")
(digit-sum 12345)

(display "Test of digital-root 123451234512345 ;;should result in 9 \n")
(digital-root 123451234512345)
      
(display "Test of backwards 12345 \n")
(backwards 12345) 
;; I had a lot of problems with this one. I needed a way to increment 10 each time, and I couldn't figure out how to add another variable to increment
;;I would have liked to have put x = x*10 in the else statement