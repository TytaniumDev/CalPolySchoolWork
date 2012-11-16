#lang plai

(define-type fruit
  [lemon (n number?)]
  [melon (n number?)]
  [nomel (n number?)])

;; onlyLemons : consumes a list of fruits and returns a list containing only the lemons.
;; fruit (listof fruit) -> (listof lemons)

(define (onlyLemons fruit-list)
  (match fruit-list
    [(list) empty]
    [(cons f r)
     (cond [(lemon? f) (cons f (onlyLemons r))]
           [else (onlyLemons r)])]))

;; Lists

(define l0 empty)
(define l1 (cons (lemon 1) empty))
(define l2 (cons (lemon 1) (cons (melon 2) (cons (nomel 3) (cons (lemon 4) (cons (melon 5) empty))))))
(define l3 (cons (melon 3) empty))

;; Tests

(test (onlyLemons l0) empty)
(test (onlyLemons l1) (cons (lemon 1) empty))
(test (onlyLemons l2) (cons (lemon 1) (cons (lemon 4) empty)))
(test (onlyLemons l3) empty)

;; onlyMelons : consumes a list of fruits and returns a list containing only the melons.
;; fruit (listof fruit) -> (listof melons)

(define (onlyMelons fruit-list)
  (match fruit-list
    [(list) empty]
    [(cons f r)
     (cond [(melon? f) (cons f (onlyMelons r))]
           [else (onlyMelons r)])]))

;; Lists

(define lm0 empty)
(define lm1 (cons (melon 1) empty))
(define lm2 (cons (melon 1) (cons (lemon 2) (cons (nomel 3) (cons (melon 4) (cons (lemon 5) empty))))))
(define lm3 (cons (lemon 3) empty))

;; Tests

(test (onlyMelons lm0) empty)
(test (onlyMelons lm1) (cons (melon 1) empty))
(test (onlyMelons lm2) (cons (melon 1) (cons (melon 4) empty)))
(test (onlyMelons lm3) empty)

;; onlyThis : consumes a list of fruits and returns a list containing only that fruit.
;; fruit (listof fruit), fruit f -> (listof fruit f)

(define (onlyThis fruit-list f)
  (match fruit-list
    [(list) empty]
    [(cons first r)
     (cond [(equal? f first) (cons first (onlyThis r f))]
           [else (onlyThis r f)])]))

;; Lists

(define t0 empty)
(define t1 (cons (lemon 4) empty))
(define t2 (cons (nomel 1) (cons (nomel 3) (cons (nomel 3) (cons (nomel 3) (cons (lemon 4) empty))))))
(define t3 (cons (lemon 3) empty))

;; Tests

(test (onlyThis t0 (lemon 4)) empty)
(test (onlyThis t1 (lemon 4)) (cons (lemon 4) empty))
(test (onlyThis t2 (nomel 3)) (list (nomel 3) (nomel 3) (nomel 3)))
(test (onlyThis t3 (lemon 4)) empty)
