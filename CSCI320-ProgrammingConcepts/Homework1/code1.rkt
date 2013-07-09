#lang racket
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
(p1 1 2)
;;results in 6