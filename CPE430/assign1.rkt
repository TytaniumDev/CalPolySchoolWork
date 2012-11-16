#lang plai
;; 2.1: Problem 2.3.3 from textbook
;; total-profit : computes total profit for the theater based on attendance
;; number -> number
(define (total-profit attend)
  (- (* 5 attend) (+ 20 (* .5 attend))))

(test (total-profit 0) -20)
(test (total-profit 5) 2.5)
(test (total-profit 10) 25)

;; 2.1: Problem 3.3.5 from textbook
;; height : computes the height that a rocket reaches in a given amount of time
;; time -> number
(define (height time)
  (* 0.5 (* time (* 9.8 time))))

(test (height 0) 0)
(test (height 10) 490)

;; 2.2 Income; Represent a writing implement
(define-type writer
  ; ink volume in ml, how-full a number in the range 0.0 to 1.0
  [pen (ink-volume number?) (how-full number?)]
  ; length in cm
  [pencil (length number?)])
;; how-far-to-write : accepts a writing implement and returns the distance (in meters) that the implement will write before it’s done.
;; writer -> number
(define (how-far-to-write w)
  (type-case writer w
    [pen (ink percent) (* 150 (* ink percent))]
    [pencil (length) (* 56 length)]))

(test (how-far-to-write (pen 10 1)) 1500)
(test (how-far-to-write (pen 40 0.5)) 3000)
(test (how-far-to-write (pencil 10)) 560)
(test (how-far-to-write (pencil 0)) 0)

;; 2.3 Low-degree Polynomials
(define-type polynomial
  [linear (A number?) (B number?)]
  [quadratic (A number?) (B number?) (C number?)])
;; eval : accepts a polynomial and a value for the variable and produces the result of plugging in the value for the variable
;; polynomial, number -> number
(define (eval poly x)
  (type-case polynomial poly
    [linear (A B) (+ (* A x) B)]
    [quadratic (A B C) (+ (* A (* x x)) (* B x) C)]))

(test (eval (linear 5 10) 2) 20)
(test (eval (quadratic 2 4 5) 5) 75)

;; 2.4 Derivative
;; derivative : accepts a polynomial and returns another polynomial that represents its derivative
;; polynomial -> polynomial
(define (derivative poly)
  (type-case polynomial poly
    [linear (A B) (linear 0 A)]
    [quadratic (A B C) 
    (cond
      [(equal? A 0) (linear 0 B)]
      [else (linear (* A 2) B)])]))

(test (derivative (linear 5 6)) (linear 0 5))
(test (derivative (quadratic 0 5 6)) (linear 0 5))
(test (derivative (quadratic 2 8 6)) (linear 4 8))

;; 2.5 Binary Tree
(define-type btree
  [leaf (data any/c)]
  [node (left btree?) (right btree?)])
;; examples of binary trees
(define bt1 (leaf 5))
(define bt2 (node (leaf 4) (leaf 65)))
(define bt3 (node (leaf 1) (node (leaf 2) (node (leaf 3) (leaf 4)))))

;; 2.6 Mirror
;; mirror: accepts a binary tree and produces a new binary tree that is the left-right mirror image of the first one
;; btree -> btree
(define (mirror tree)
  (type-case btree tree
    [leaf (data) tree]
    [node (left right) (node (mirror right)(mirror left))]))
    
(test (mirror bt1) bt1)
(test (mirror bt2) (node (leaf 65) (leaf 4)))
(test (mirror bt3) (node (node (node (leaf 4) (leaf 3)) (leaf 2)) (leaf 1)) )

;; 2.7 Containment
;; contains? : accepts a binary tree and a symbol and returns true exactly when the given tree contains the given symbol at one of its leaves
;; btree, any/c -> boolean
(define (contains? tree value)
  (type-case btree tree
    [leaf (data) (cond [(equal? value data) #t]
                       [else #f])]
    [node (left right) (cond [(equal? (contains? left value) #t) #t]
                             [(equal? (contains? right value) #t) #t]
                             [else #f])]))

(test (contains? bt1 5) #t)
(test (contains? bt2 1) #f)
(test (contains? bt3 4) #t)
(test (contains? bt3 3) #t)