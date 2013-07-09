#lang racket
;; code0.rkt
(define b 13)

(define (square x) (* x x))

(square b)

(define a b)

(= a b)

(if (= (* b a) (square 13))
    (< a b)
    (- a b))