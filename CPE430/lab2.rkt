#lang plai
(define-type furniture
  [desk (width number?) (height number?) (depth number?)]
  [bookshelf (depth number?) (num-shelves number?) (shelf-width number?)])

(define desk1 (desk 1 1 1))
(define desk2 (desk 2 3 4))
(define shelf1 (bookshelf 1 1 1))
(define shelf2 (bookshelf 2 3 4))

;; furniture-footprint : computes footprint of furniture
;; desk -> number
(define (furniture-footprint f)
  (type-case furniture f
    [desk (width height depth) (* width depth)]
    [bookshelf (depth num-shelves shelf-width) (* depth shelf-width)]))
         
;;test cases for footprint
(test (furniture-footprint desk1) 1)
(test (furniture-footprint desk2) 8)
(test (furniture-footprint shelf1) 1)
(test (furniture-footprint shelf2) 8)