#lang plai

;;Add let/cc to interpreter
(define (interp exp env)
  (type-case CFAE exp
    [varref (x) (hash-ref env x)]
    [fundef (x body) (cloV x body env)]
    [letcc (x body)
      (let/cc k
        (interp body (hash-set env x (contV k))))]
    [app (fun arg)
         (type-case CFAE-Value (interp fun env)
           [cloV (x body cloEnv) (interp body (hash-set cloEnv x (interp arg env)))]
           [contV (k) (k (interp arg env))])]))
;;Need new CFAE value
(define-type CFAE-Value
  [cloV ...]
  [contV (k procedure?)])

;;If we don't have let/cc in parent language
(define (interp/k exp env k)
  (type-case CFAE exp
    [varref (x) (k (hash-ref env x))]
    [fundef (x) (k (cloV x body env))]
    [letcc (x body)
      (interp/k body (hash-set env x (contV k)) k)]
    [app (fun arg)
         (interp/k fun env
                   (λ (fv)
                     (type-case CFAE-Value fv
                       [cloV (x body cloEnv) (interp/k arg env (λ (av) (interp/k body (hash-set cloEnv x av) k)))]
                       [contV (nk) (interp/k arg env nk)])))]))

;;In a language that doesn't have closures
(define (interp/k exp env k)
  (type-case CFAE exp
    [varref (x) (k (hash-ref env x))]
    [fundef (x body) (k (cloV x body env))]
    [app (fun arg)
         (interp/k fun env (app1k arg env k))]))
;λ (fv) thing
(define (app1k arg env k)
  (λ (fv)
    (type-case CFAE-Value fv
      [cloV (x body cloEnv) (interp/k arg env (app2k body cloEnv x k))]
      [contV (nk) (interp/k arg env nk)])))
;λ (av) thing
(define (app2k body cloEnv x k)
  (λ (av)
    (interp/k body (hash-set cloEnv x av) k)))

;;In a language without using closures
(define-type Iks
  [app1ks (arg symbol?) (env hash?) (k Iks?)]
  [app2ks (body CFAE?) (cloEnv hash?) (x symbol?) (k Iks?)]
  [base ()])