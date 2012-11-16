#lang plai

(define-type F1WAE
 [num (n number?)]
 [add (l F1WAE?) (r F1WAE?)]
 [sub (l F1WAE?) (r F1WAE?)]
 [with (name symbol?) (gets F1WAE?) (body F1WAE?)]
 [varref (name symbol?)]
 [call (name symbol?) (arg F1WAE?)])

(define-type FunDef
  [fundef (name symbol?) (param symbol?) (body F1WAE?)])

;; examples
(with 'x (add (num 5) (num 2))
 (sub (varref 'x)
      (num 3)))

(fundef 'marcusfun 'a (add (varref 'a) (num 4)))

(call 'marcusfun (num 2))

;; eval : F1WAE (listof FunDef) -> number
(define (eval exp funs)
 (type-case F1WAE exp
   [num (n) n]
   [add (l r) (+ (eval l) (eval r))]
   [sub (l r) (- (eval l) (eval r))]
   [with (name gets body)
         (eval (subst name (eval gets) body))]
   [varref (name) (error "bad!")]
   [call (name arg)
         (type-case FunDef (find-named name funs)
           [fundef (funname param body)
                   (eval (subst param
                          (eval arg funs)
                          body))])]))

;; subst : replaces instances of a variable with
;; a value.
;; symbol? number? F1WAE?
(define (subst from to in)
 (type-case F1WAE in
   [num (n) (num n)]
   [add (l r)
        (add (subst from to l)
             (subst from to r))]
   [sub (l r)
        (sub (subst from to l)
             (subst from to r))]
   [with (name gets body)
         (cond [(equal? name from)
                (with name
                      (subst from to gets)
                      body)]
               [else
                (with name
                      (subst from to gets)
                      (subst from to body))])]
   [varref (name)
           (cond [(equal? name from) (num to)]
                 [else in])]
   [call (name arg)
         (call subst from to arg)]))

(test (eval (with 'a (num 5)
                  (with 'a (add (num 4) (varref 'a))
                        (add (varref 'a) (num 8))))) 17)
(test (subst 'x 1 (num 34)) (num 34))
(test (subst 'x 1 (varref 'x)) (num 1))
(test (subst 'x 1 (add (varref 'x) (varref 'x)))
     (add (num 1) (num 1)))
(test (subst 'x 1 (varref 'y))
     (varref 'y))
(subst 'x 1 (with 'x (num 4) (add (varref 'x)
                                       (num 2))))
(test (subst 'x 1 (with 'x (num 4) (add (varref 'x)
                                       (num 2))))
     (with 'x (num 4) (add (varref 'x)
                           (num 2))))
