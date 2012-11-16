#lang plai
;;Implementing state without state
;;You can solve everything in CSC with an additional layer of indirection

[makebox (v CFAE?)]

[boxV (l location?)]

;for returning 2 values
(define-type any*store
  [a*s (v any/c)
       (sto store?)])

;plumbing   sto = store
(define (interp exp env sto)
  (type-case CFAE? exp
    [num (n) (a*s (numV n) sto)]
    [add (l r) (type-case any*store (interp l env sto)
                 [a*s (lv sto2) 
                      (type-case any*store (interp r env sto2)
                        [a*s (rv sto3)
                             (a*s (my-plus lv rv) sto3)])])]
    ))
;;operations on a store:
;set: sto location value -> sto
;get: sto location -> value
;alloc: sto -> location sto

;;Things that will modify the store
[makebox (v CFAE?)
         (type-case any*store (alloc sto)
           [a*s (loc sto2) 
                (type-case any*store (interp v env sto2)
                  [a*s (bv sto3)
                       (a*s (boxV loc) (set sto3 loc bv))])])]
[getbox (v CFAE?)
        (type-case any*store (interp v env sto)
          [a*s (val sto2)
               (type-case CFAE-Value val
                 [boxV (l) (a*s (get sto2 l) sto2)]
                 [else (signal an error, getbox on something not a box)])])]
[setbox (box newVal)
        (type-case any*store (interp box env sto)
          [a*s (bv sto2)
               (type-case any*store (interp newVal env sto2)
                 [a*s (nv sto3)
                      (type-case CFAE-Value bv
                        [boxV (l)
                              (a*s (numV 426)
                                   (set sto3 l nv))])])])]

;;Magic trick
;x = 9 now evals to a function sto -> val x sto