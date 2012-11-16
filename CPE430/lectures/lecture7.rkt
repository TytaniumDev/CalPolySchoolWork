#lang plai

;; A Table, like the book has
(define-type DeferedSub
  [emptySub]
  [aSub (name symbol?) (val number?) (rest DeferedSub)])

;; with a hash table
(hash-put map key value) -> map (a new one)
(hash-ref map key)
(hash)

;;evaluator
(define (eval exp defs env)
  (type-case F1WAE exp
    [varref (name)
            (hash-ref env name)]
    [with (name rhs body)
          (eval body defs 
                (hash-put env name (eval rhs defs env)))]
    [funcall (name arg)
             (type-case FunDef (lookup defs name)
               [fundef (name param body)
                       (define argval (eval arg defs env))
                       (define newenv (hash-put env name argval))
                       (eval body defs newenv)])]))

{fun f x {+ x y}}