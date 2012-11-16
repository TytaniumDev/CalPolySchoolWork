#lang plai

;Store monad

;;Finishing mutation
;last time
[add (l r)
     (type-case any*store (interp l env sto)
       [a*s (lv sto2)
            (type-case any*store (iinterp r env sto2)
              [a*s (rv sto3)
                   (a*s (my-plus lv rv) sto3)])])]
;new
[add (l r)
     (sdo [lv <- (interp l env)]
          [rv <- (interp r env)]
          [(lift (myplus lv rv))])]

;Big Idea:
;values become sto -> value * sto
;                 Value Computation
;interp: CFAE? hash? -> Value Computation
(define (interp exp env)
  (type-case CFAE? exp
    ;[num (n) (lambda (sto) (a*s (numV n) sto))]))
    [num (n) (lift (numV n ))]
    [add (l r) 
         (bind (interp l env)(lambda (lv) 
         (bind (interp r env)(lambda (rv)
         (lift (myplus lv rv))))))]))

;lift: value -> value computation
(define (lift v)
  (lambda (sto) (a*s v sto)))

;bind: alpha computation -> (alpha -> (beta computation)) -> beta computation)
(define (bind a b)
  (lambda (sto) 
    (type-case any*store (a sto)
      [a*s (v sto2)
           ((b v) sto2)])))

;getbox
[getbox (box)
        (bind (interp box env) (lambda (bv)
        (type-case CFAE-Value bv
          [boxV (loc)
                (bind getstore (lambda (sto)
                (lift (hash-ref sto loc))))]
          [else ...])))]

;getstore: store computation
(define getstore
  (lambda (sto) (a*s sto sto)))
  ;(getstore sto) (a*s sto sto))

;setstore: sto -> boolean computation
(define (setstore sto)
  (lambda (oldsto) (a*s #t sto)))