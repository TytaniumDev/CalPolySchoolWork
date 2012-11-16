#lang plai

;;let/cc, abort
(define (web-read/k prompt k)
  (printf ...)
  (set-box! k-box k))

;abort
(define (abort k)
  'junk)

;grab-k
(define (grab-k v k)
  (v k k))

;From last time
(+ (+ 3 4) (+ (abort 13) 6))
T[(abort M)] q = T[M](lambda (x) x)

(let/cc k 
  (+ 3 (k 6))) ; = 6
T[(let/cc x M)] q = ((lambda (x) T[M] q)(lambda (r) (abort (q r))))

(define (web-read prompt)
  (printf ...)
  (let/cc k
    (set-box! k-box k)
    (abort 13)))

(define (transaction)
  (check (web-read "name")
         (web-read "cc #")))

;generators
(define (list-gen l)
  (let/cc exit
    (...
     (let/cc resume (
                     (exit (list 14 resume)))))))

;resume is too good, fixes:
(define (list-gen l exit)
  (let/cc exit
    (...
     (set! exit)
     (let/cc resume (
                     (exit (list 14 resume)))))))