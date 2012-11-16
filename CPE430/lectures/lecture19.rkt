#lang plai

;;Steadily Getting Worse
(define (transaction)
  (define k1 name)
  (define (k2 cc-num)
    (verify name cc-num (lambda (cc-num) (charge cc-num)))
  (web-read/k "cc-num" k2)))

(define (verify name cc-num)
  (cond [(sketchy? name cc-num) (another-check (web-read "sq"))]
        [else (void)]))

;;rewrite verify
(define (verify name cc-num)
  (cond [(sketchy? name cc-num) (web-read/k "sq" (lambda (r) (another-check r)))]
        [else cc-num]))

;;rewrite verify again for charge
(define (verify/k name cc-num k)
  (cond [(sketchy? name cc-num) (web-read/k "sq" (lambda (r) (k (another-check r))))]
        [else (k #t)]))

;;list of names and list of cc-nums
(define (verify/many/k lonames loccs k)
  (cond [(empty? lonames) (k #t)]
        [else (verify/k (first lonames) (first loccs)
                        (lambda (r)
                          (cond [r (verify/many/k (rest lonames) (rest loccs) k)]
                                [else (k #f)])))]))

