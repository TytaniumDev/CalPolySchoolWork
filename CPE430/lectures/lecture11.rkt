#lang plai
;; Laziness

(define-type CFAE/L-Value
  [numV (n number?)]
  [cloV (param symbol?)
        (body CFAE?)
        (env hash?)]
  [promV (body CFAE?)
         (env hash?)
         (cached-val box?)])

;box example
(define a (box 5))
   (unbox a) ; = 5
   (setbox! a 6)
   (unbox a) ; = 6

;interp : CFAE? hash? -> CFAE/L-Value
(define (interp exp env)
  type-case CFAE exp
  [num (n) (numV n)]
  [add (l r) (my-add (interp l env)
                     (interp r env))]
  [app (f arg) 
       (type-case CFAE/L-Value (strict (interp f env))
         [cloV (param body cloEnv)
               (define newEnv (hash-put cloEnv param (exprV arg env (box #f)))
                 (interp body newEnv))]
         [else (error "Should never happen")])])
  
;new with
(with {{x = 9}
       {y = {+ 9 4}}}
      {+ x y})
 ;in parser:
{{fun {x y} {+ x y}}
 9
 {+ 9 4}}

;add
(define (my-add v1 v2)
  (numV (+ (numV-n (strict v1))
           (numV-n (strict v2)))))

;strict : CFAE/L-Value? -> CFAE/L-Value?
(define (strict val)
  (type-case CFAE/L-Value val
    [promise (body env cached) (cond [(unbox cached) (unbox cached)]
                                     [else (define final (strict (interp (body env)))
                                             (set-box! cached final)
                                             final)])]
    [else val]))