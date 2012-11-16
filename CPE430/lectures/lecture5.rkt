#lang plai

(define-type WAE
  [num (n number?)]
  [add (l WAE?) (r WAE?)]
  [sub (l WAE?) (r WAE?)]
  [with (name symbol?) (rhs WAE?) (body WAE?)]
  [varref (name symbol?)])

;; examples
(with 'x
      (add (num 3)(num 9))
      (add (varref 'x) (num 3)))

#;(define (eval exp)
  (type-case WAE exp
    [num (n) n]
    [add (l r) (+ (eval 1) (eval r))]
    [sub (l r) (- (eval 1) (eval r))]
    [with (name rhs body) ...]
    [varref (name) ...]))

;;(test (eval (with 'x (num 2) (add varref x) (num 4))) 6)

;; subst : replace every from with to in in
;; subst : symbol? number? WAE? -> WAE?
(define (subst from to in)
  (type-case WAE in
    [num (n) (num n)]
    [add (l r) (add (subst from to l) (subst from to r))]
    [sub (l r) (sub (subst from to l) (subst from to l))]
    [with (name rhs body)
          (cond [(equal? name from) in]
                [else
                 (with name
                (subst from to rhs)
                (subst from to body))]
    [varref (name) (cond [(equal? from name) (num to)]
                         [else (varref name)])])]))

(test (subst 'x 1 (num 15)) (num 15))
(test (subst 'x 1 (varref 'x)) (num 1))
(test (subst 'x 1 (add (varref 'x) (num 4))) (add (num 1) (num 4)))
(test (subst 'x 1 (varref 'y)) (varref 'y))
(test (subst 'x 9 (with 'y (num 5)
                        (add (varref 'x)
                             (varref 'y))))
      (with 'y (num 5)
            (add (num 9) (varref 'y))))
(test (subst 'x 9 (with 'x (num 5)
                        (add (varref 'x) (varref 'x)))) 
      (with 'x (num 5)
            (add (varref 'x) (varref 'x))))