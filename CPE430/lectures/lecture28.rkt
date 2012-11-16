#lang plai

;;Macros
;The idea of abbreviation
(let ([a 6]) (+ a 15))
=
((λ (a) (+ a 15)) 6)

;writing racket and as a function
(and M1 M2)
;turn into: (so it's not a function)
(if M1
    (if M2 
        #t 
        #f)
    #f)
;Doesn't work, evals M1 twice
;use let instead
(let ([t1 M1])
  (if t1 t1
      (let ([t2 M2])
        (if t2 t2 #f))))
