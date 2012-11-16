#lang plai
;; add3s : add 3 to each elemet of a list
;; (listof number) -> (listof number)
(define (add3s a-list)
  (cond [(empty? a-list) empty]
        [else (cons (+ 3 (first a-list))
                    (add3s (rest a-list)))]))
(test (add3s empty) empty)
(test (add3s (cons 1 empty)) (cons 4 empty))
(test (add3s (cons 4 (cons 5 empty))) (cons 7 (cons 8 empty)))

;;
(define (mapp op a-list)
    (cond [(empty? a-list) empty]
          [else (cons (op (first a-list))
                      (mapp op (rest a-list)))]))

(define (add3 a-num) (+ 3 a-num))
(test (mapp add3 empty) empty)
(test (mapp add3 (cons 3 empty)) (cons 6 empty))

(define (mul10 n) (* 10 n))
(test (mapp mul10 (cons 1 (cons 2 empty))) (cons 10 (cons 20 empty)))

;; PART 2
(define-type AE
  [num (n number?)]
  [add (l AE?) (r AE?)]
  [sub (l AE?) (r AE?)])

;; ae-parse : translate a list into an AE
;; -> (ae-parse)
(define (ae-parse in)
  (cond [(number? in) (num in)]
        [(and (list? in)
              (equal? (first in) '+))
         (add (ae-parse (second in))
              (ae-parse (third in)))]
        [(and (list? in)
              (equal? (first in) '-))
         (sub (ae-parse (second in))
              (ae-parse (third in)))]))

(test (ae-parse 4) (num 4))
(test (ae-parse '(+ 1 5)) (add (num 1) (num 5)))
(test (ae-parse '(+ (- 7 3) 4)) (add (sub (num 7) (num 3)) (num 4)))
