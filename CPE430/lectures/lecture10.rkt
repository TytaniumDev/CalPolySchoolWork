#lang plai

;; assign3 stuff: section 5.7
(interp (parse-exp '{target-interp
                     {pair "+"
                           {pair
                            {pair "-"}}}}))
;; The pair stuff is the parsed portion of our language?

;;Lecture notes
;;curried-add: number -> (number -> number)

;;interp: cf1wae env defs -> cf1wae
;;curried-interp cf1wae -> (env -> (defs -> cf1wae-value))
(define (interp exp env defs)
  (define (recur exp)
    (interp exp env defs)))

(define (my-and a b) (and a b))