#lang plai

;Sound: Proof system proves things that are true
;Complete: All true statements are true

;;Solving infinite recursion
;Fixed point: fix(f) is an element x such that f(x) = x
(fix
 (λ(fact)
   (λ(x)
     (if (= x 0)
         1
         (* x (fact (- x 1)))))))

;Adding things to types for fix function

M: T1 -> T1
________________________
(fix M): T


;Simplified version
(fix
 (λ (fact)
   (λ(x) (+ x (fact x)))))

;Type checking above thing
;Too much to type