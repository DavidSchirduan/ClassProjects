#lang racket
;;This program was written solely by David Schirduan
;;Homework 2 part 1
;;9-21-11
;;5) count-zeros
(define (count-zeros x)
  (cond
    ((null? x) 0)
    ((zero? (car x)) (+ (count-zeros (cdr x)) 1)) ;;if zero, add 1 and go down a level
    (else (count-zeros (cdr x)))))

(display "test of count-zeros function. Should return 6 \n")
(count-zeros '(1 2 0 3 0 4 6 7 0 0 0 9 7 8 0))

;;6) large-small
;;write 2 methods to return the largest and smallest elements in the list
(define (large-small lis)
  (list (largest lis) (smallest lis)))
  
  (define (largest lis)
    (cond
      ((null? (cdr lis)) (car lis));if you reach the end of the list
      ((< (car lis) (largest (cdr lis))) (largest (cdr lis)))
      ((> (car lis) (largest (cdr lis))) (car lis))))
  
  (define (smallest lis)
    (cond
      ((null? (cdr lis)) (car lis));if you reach the end of the list
      ((< (car lis) (smallest (cdr lis))) (car lis))
      ((> (car lis) (smallest (cdr lis))) (smallest (cdr lis)))))
  
  
(display "test of large-small function. Should return '(23 1) \n")
(large-small '(5 3 8 9 1 23 4))
      
;;7) delete-top
;;creates a new list while leaving out the old elements
(define (delete-top x lis)
 (cond
   ((null? (cdr lis)) lis);;when the list is empty, do nothing 
   ((equal? (car lis) x) (delete-top x (cdr lis))) ;;if element is equal to x don't add it to the list
   (else (cons (car lis) (delete-top x (cdr lis))))));;else add it to the new list

(display "test of delete-top function. Should return '(1 3 4 5 6 7) \n")
(delete-top 2 '(1 2 3 4 2 5 6 2 7))
      
;;8) remove-last
(define (remove-last lis)
  (cond
    ((null? (cdr lis)) '())
    (else (cons (car lis) (remove-last (cdr lis))))))

(display "test of remove-last function. Should return '(1 2 3) \n")
(remove-last '( 1 2 3 4))


;9) repeat-list
;;creates a new list while leaving out the old elements
(define (repeat-list x lis)
     (cond 
       ((null? (cdr lis)) lis);;when the list is empty, just return the list
       ((equal? (car lis) x) (repeat-list x (cdr lis))) ;;if element is equal to x don't add it to the list
       (else (cons (car lis) (repeat-list x (cdr lis))))));;else add it to the new list

(display "test of repeat-list function. Should return '(1 2 3 4 2 5 6 2 7) \n")
(repeat-list (list 1 2) (list 1 2 3 4 (list 1 2) 2 5 6 2 7))


;11) reverse-param
;;returns a list in reverse order
(define (reverse-param lis)
  (if (null? (cdr lis));;if empty, it returns the list version of the last element
      (list (car lis))
      (append (reverse-param (cdr lis)) (list (car lis)))));;then sticks the other elements behind it

(display "test of reverse-param function. Should return '(1 2 3 4 2 5 6 2 7) \n")
(reverse-param '(1 2 3 4 5))
  
;12) struc-eq
;test if they are structurally equivalent
;;works for top level, need to adjust so that it goes into each list
(define (struc-eq lis1 lis2)
  (cond                 ;;are both lists null?
    ((and (null? (cdr lis1)) (not (null? (cdr lis2)))) "they DO NOT have the same structure") ;test if only one is null
    ((and (not (null? (cdr lis1))) (null? (cdr lis2))) "they DO NOT have the same structure") ;test if only one is null
    ((and (null? (cdr lis1)) (null? (cdr lis2))) "they have the same structure");;return this if both lists are null, base case
    ((equal? (list? (car lis1)) (list? (car lis2))) (struc-eq (cdr lis1) (cdr lis2)))
    (else "they DO NOT have the same structure")))
          
(display "test of struc-eq function. only works on top level for now\n")
(define test1 (list 6 2 2 (list 7 5) 3 4 1))
(define test2 (list 6 2 2 (list 7 5) 3 1))
(struc-eq test1 test2)

;14) occurrences
;number 7 but multi-level
(define (occurences x lis)
 (cond
   ((null? (cdr lis)) lis);;when the list is empty, do nothing
   ((list? (car lis)) (occurences x (car lis)))
   ((equal? (car lis) x) (occurences x (cdr lis))) ;;if element is equal to x don't add it to the list
   (else (cons (car lis) (occurences x (cdr lis))))));;else add it to the new list

(display "test of occurences function. Should return '(1 3 4 1 4) \n")
(occurences 2 (list 1 2 3 4 (list 1 2 4) 2 5 6 2 7))

;16) list-ascending
;returns a list of numbers ordered ascendingly
(define (list-ascending lis)
  (if (null? (cdr lis))
      (car lis)
      (cons (smallest lis) (list-ascending (delete-top (smallest lis) lis)))))

(display "test of list-ascending function.\n")
(list-ascending (list 1 4 6 3 5))