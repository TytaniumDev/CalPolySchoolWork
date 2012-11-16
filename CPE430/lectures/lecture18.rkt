#lang plai

;;Continuations and Web Programming
(define (transaction)
  (validate (get-name)
            (get-cc-num)))
;above doesn't work for web
(define (transaction)
  (validate (web-read "name")
            (web-read "cc num")))
;how to store rest of stuff
(lambda (r1) (validate r1
                       (web-read "cc num")))

(define kont (box #f))
(define (web-read/k prompt k)
  (printf "~a\n" prompt)
  (printf "type (resume (x)) to continue\n")
  (set-box! kont k))

(define (resume v)
  ((unbox kont) v))

;new transaction with new stuff
(define (transaction)
  (validate (web-read/k "name"
                        (lambda (r1) 
                          (web-read/k "cc num"
                                      (lambda (r2) 
                                        (validate r1 r2)))))))

;;Make it so user stores stuff instead of the server
(define (k2 r2 hidden)
  (validate (lookup 'r1 hidden) r2))

(define (k1 r1 hidden)
  (web-read/r "cc num" "k2" '((r1, r1))))

(define (transaction)
  (web-read/r "name" "k1" '()))

(define (web-read/r prompt k-name hidden)
  (printf "~a\n" prompt)
  (printf "type (~a <x> ~a) to continue\n"
          k-name
          hidden))