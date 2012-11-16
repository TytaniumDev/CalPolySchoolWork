#lang plai

;;Type systems:
;What:                    Why:
;Values belong to types   -catch errors (in finite time)
;                         -helping the compiler lay out values
;
;Expressions have types

;M = n              ;T = integer
;M = n | (+ M M)    ;T = integer

;M = n | (+ M M)          ;T = Even | Odd
;M = n | (+ M M) | (h M)  ;T = Even | Odd
;M = ne | no | (+ M M) | (h M)  ;T = Even | Odd
;This breaks when halving, don't know type of output

;M = n | (+ M M) | String  ;T = Int | Str
;
; : = has type
;
 _______
  n:Int
______________
  String:Str

 M1:Int   M2:Int
 _______________
   (+ M1 M2)
   
blah
;M = n | (+ M M) | (λ (x) M) | (M M)  ;T = Int | Fun(T)


      M:T
_______________
(λ(x) M): Fun(T)


;broken, don't know type of (M M)
M1:Fun   M2:T
______________
(M1 M2):

;M = n | (+ M M) | (λ (x) M) | (M M)  ;T = Int | T -> T
(λ (x) (+ x 3)):Int->Int
(λ (x) (+ (x 4) 3)):(Int->Int) -> Int

M1:T1->T2   M2:T1
______________
(M1 M2):T2

      M:T1
_______________
(λ(x) M): ?->T1