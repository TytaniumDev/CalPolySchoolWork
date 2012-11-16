#lang plai

;;Things we have
;Seperation between parser and interpreter
;evaluation is a traversal of an expression tree
;function application is based on substitution
;environments can be equivalent to substitution
;functions can be first class values
;-and recursive
;-and laziness is insteresting

;;Things to add to the language
;loops
;if
;multiple values
;classes and structures <-----
;type systems
;modules
;mutation and state

;cafes: CFAE with structures
(define-type Cafes
  [newexp (type symbol?)
       (fields (listof Cafes?))]
  )
;Cafes values
(define-type Cafes-Value
  [objectV (type symbol?)
           (fields (listof Cafes-Value?))]
  )
;interpreter
(define (interp exp env)
  [newexp (type fields)
       (objectV type (map (recur fields)))]
  )

;create points
{new point 7 4}
{new zebra "furry" "cambria" 342}

;access fields
{fun {{zebra name hometown weight}}
     {or {equal? hometown miami}
         {< 400 weight}}}
   