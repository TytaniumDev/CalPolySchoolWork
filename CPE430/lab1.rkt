#lang plai
(+ 3 4)
(test (* 4 13) 52)
(test (or false true) true)
; add nums : number? number? -> number?
(define (add-nums a b)
  (+ a b))
(test (add-nums 10 12) 22)

; 2.2.1
(define (Fahrenheit->Celsius t)
  (* (- t 32) 5/9))
(test (Fahrenheit->Celsius 32) 0)
(test (Fahrenheit->Celsius 95) 35)

; 2.3.2
(define (sum-coins p n d q)
  (+(+(+ p (* n 5)) (* d 10)) (* q 25)))
(test (sum-coins 1 1 1 1) 41)
(test (sum-coins 5 1 4 2) 100)