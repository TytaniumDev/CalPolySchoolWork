#lang plai

;recursion
{rec {loop = {fun {x} {loop x}}
           {loop 4}}}

(define-type CFAE
  [num (n number?)]
  [rec (name symbol?)
       (rhs CFAE?)
       (body CFAE?)])

;env : hash from symbols -> boxed values
(define (interp exp env)
  (type-case CFAE exp
    [fun (param body) (cloV param body env)]
    [rec (name rhs body)
      (begin
        (define newBox (box false))
        (define newEnv (hash-set env name newBox))
        (define getsVal (interp rhs newEnv))
        (set-box! newBox getsVal)
        (interp body newEnv))]))
;to replace hash-ref
(define (env-lookup env name)
  (match (unbox hash-ref env name)
    [#f (error 'env-lookup "ref ....")]
    [other other]))

;still need to add box thing to app