#lang racket

(define (zeros x)
  (cond
    ((null? x) 0)
    ((zero? (car x)) (+ (zeros (cdr x)) 1)) ;;if zero, add 1 and go down a level
    (else (zeros (cdr x)))))

(zeros '(1 2 0 3 0 4 6 7 0 0))