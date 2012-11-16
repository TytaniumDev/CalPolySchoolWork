#lang plai

;State and Mutation

;;Calling conventions
;Call by Value
;In most programming languages

;Call by Reference
;In C kinda
;passing a binding rather than a value, not widely used

;Call by Name
;laziness

;Call by Need
;using a box to cache a value

;;Implementing:
;box : value -> box
;unbox : box -> value
;set-box! : box value -> ?

(define-type CFAE
  [makebox (val CFAE?)]
  [getbox (box CFAE?)]
  [changebox (box CFAE?)(val CFAE?)])

{with {{b = {makebox 14}}}
      {changebox! b 15}
      {getbox b}}

