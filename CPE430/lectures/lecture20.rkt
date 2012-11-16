#lang plai

;;Automated CPS
;;M = x | (lambda x M) | (M M) | num | (+ M M)
;;^ lambda calculus

;starting function
T[(lambda (num) (lambda (f) (+ n (f n))))]
;transform into CPS
(lambda (n k) (k (lambda (f k') (f n (lambda (r) (k' (+ n r)))))))

;;how to write something to do this for us automatically
;;T: exp exp -> exp
T[x] q = (q x)
T[(lambda (x) M)] q = (q (lambda (x k) T[M] k))
T[(M1 M2)] q = T[M1](lambda (fv) T[M2](lambda (av) (fv av q)))
T[num] q = (q num)
T[(+ M1 M2)] q = T[M1](lambda (lv) T[M2](lambda (rv) (q (+ lv rv))))

;applying above expressions to original starting function
T[(lambda (n) (lambda (f) (+ n (f n))))] (lambda (x) x)
;to:
((lambda (x) x)
 (lambda (n k) (k (lambda (f k')
                      ((lambda (lv) ((lambda (fv) ((lambda (av) (fv av (lambda (rv) (k'(+ lv rv)))))
                                                   n)
                                       f)
                                     
                                     n)))))))
;optimize
(lambda (n k) (k (lambda (f k')
                     (f n (lambda (rv) (k'(+ n rv)))))))
;^ and starting function CPS are alpha equivalent
;alpha equivalent = same except for the names of bound variables in a non-capturing way