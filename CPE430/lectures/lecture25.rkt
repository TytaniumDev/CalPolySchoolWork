#lang plai

;M = num | (+ M M) | (λ (x:T) M) | (M M)| x
;T = Int | T -> T

;Sound: my statements are true
;Complete: I make all true statements (I can prove anything that's true)
