#lang plai
(define-type MyList
  [Empty]
  [NonEmpty (first any/c) (rest MyList?)])

; examples
(Empty)
(NonEmpty 3 (Empty))
(NonEmpty 12 (NonEmpty 124 (NonEmpty "abc" (Empty))))

(define l0 empty)

(define l1 (cons 3 (cons 4 empty)))

(define l2 (cons 5 (cons 2 (cons 1 empty))))

;; new Node(new Integer(5), new Node(new Integer(2)....

;; contains? : determine whether a list contains a given value
;; any/c (listof any/c) -> location of element
(define (contains? val a-list)
  (match a-list
    [(list) (error "element not found")]
    [(cons f r) 
     (cond [(equal? f val) 0]
           [else (+ 1 (contains? val r))])]))

;;(test/exn (contains? 5 empty) )
;;(test (contains? 5 (cons 3 empty)) )
(test (contains? 5 (cons 5 empty)) 0)
(test (contains? 5 (cons 3 (cons 4 (cons 5 (cons 6 empty))))) 2)

;; size : how many elements are in the list
;; (listof any/c) -> number
(define (size a-list)
 (cond [(empty? a-list) 0]
       [(cons? a-list) (+ 1 (size (rest a-list)))])
 (match a-list
   [(list) 0]
   [(cons f r) (+ 1 (size r))]))

(test(size l0) 0)
(test(size l2) 3)