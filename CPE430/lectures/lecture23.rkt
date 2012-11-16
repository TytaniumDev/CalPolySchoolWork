#lang plai

;;Doing what we did in last lecture in a language without closures
(define-type Iks
  [app1ks (arg CFAE?) (env hash?) (k Iks?)]
  [app2ks (x symbol?) (body CFAE?) (cloEnv hash?) (k Iks?)]
  [base])

;old style
[varref (x) (apply-k k (hash-ref env x))]
[fundef (x body) (k (cloV x body env))]
[letcc (x body) (interp/k body (hash-set env x (contV k))k)]
[app (fun arg) (interp/k fun env (app1ks arg env k))]
;new, with helper function (since in above, k isn't a function)
(define (apply-k k rv)
  (type-case Iks k
    [app1ks (arg env k)
            (type-case CFAE-Value rv
              [cloV (x body cloEnv) (interp/k arg env (app2ks x body cloEnv k))]
              [contV (interp/k arg env k)])]
    [app2ks (x body cloEnv k) (interp/k body (hash-set cloEnv x rv) k)]
    [base() rv]))

;using registers to call functions without using arguments
(define r1 #f) ;exp or k
(define r2 #f) ;env or rv
(define r3 #f) ;k/i

(define (interp/k)
  [varref (x) (begin (set! r2 (hash-ref r2 x))(set! r1 r3)(apply/k))]
  [fundef (x body) (begin (set! r2 (cloV x body x r2)) (set! r1 r3)(apply/k))]
  [letcc (x body) (begin (set! r1 body)(set! r2 (hash-set env x (contV r3))) (interp/l))]
  [app (fun arg) (begin (set r1 fun)(set! arg r2 r3) (interp/k))]