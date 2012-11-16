#lang plai

;; represent anything and a store paired
(define-type Any*Store
  [a*s (val any/c) (store any/c)])

;; utility functions for the store monad

;; in these definitions, the contract ('a computation) is short for 
;; the contract (Store? -> Any*Store?), where the 'val' in the Any*Store is 
;; 'a, whatever 'a might happen to be.

;; bind : ('a computation) ('a -> ('b computation)) -> ('b computation)
;; connect an ('a computation) and a function from an 'a to a ('b computation)
;; to form a new ('b computation)
(define (bind a b) (lambda (store)
                     (type-case Any*Store (a store)
                       [a*s (x newstore) ((b x) newstore)])))

;; lift : 'a -> ('a computation)
(define (lift a) (lambda (store) (a*s a store)))

;; getstore : (Store computation)
(define getstore (lambda (store) (a*s store store)))

;; setstore : Store? -> (Store computation)
(define (setstore newstore) (lambda (dc) (a*s #f newstore)))

;; run : ('a computation) Store? -> (a*s 'a Store?)
;; actually run the computation, produce the result
(define (run comp sto)
  (comp sto))


;; sdo: convenience syntax for the Store monad. Imitating
;; Haskell's 'do':
(define-syntax (sdo stx)
  (syntax-case stx (<-)
    ;; base cases:
    [(_ (name <- comp)) #'comp]
    [(_ comp)           #'comp]
    ;; non-base-cases:
    [(_ (name <- comp1) clause ...)
     #`(bind comp1 (lambda (name) (sdo clause ...)))]
    [(_ comp1 clause ...)
     #`(bind comp1 (lambda (bogusname) (sdo clause ...)))]))


;; two versions of the same test case: one uses bind, one uses sdo.
(test
 (run
  (bind getstore (lambda (s) 
  (bind (lift (cons (+ 1 (list-ref s 2)) s)) (lambda (p)
  (bind (setstore p) (lambda (dc) 
  (lift 41234)))))))
  (list 3 4 5))
 (a*s 41234 (list 6 3 4 5)))

(test
 (run
  (sdo (s <- getstore)
       (p <- (lift (cons (+ 1 (list-ref s 2)) s)))
       (setstore p)
       (lift 41234))
  (list 3 4 5))
 (a*s 41234 (list 6 3 4 5)))
