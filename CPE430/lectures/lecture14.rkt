#lang plai

;;Structures II
;classroom:
{new classroom 246 35 "donut"}
;fun:
{with {{willTheyFit = {fun {numPpl {classroom room capacity nickname}}
                           {<= numPpl capacity}}}}
      {willTheyFit 5 {new classroom 246 35 "donut"}}}

;now implement
(define-type Cafes
  [new ]
  [fun (params (listof Pattern?))
       (body Cafes)]
  )

(define-type Pattern
  [paramPat (p symbol?)]
  [structPat (type symbol?)
             (fields (listof Pattern))]
  )
;interp
(define (interp exp env)
  (type-case
      [fun (params body) (closureV params body env)]
      [app (fun args) 
           (type-case Cafes-Value (interp fun env)
             [cloV (params body cloEnv)
                   (interp body (match-and-extend cloEnv params (map-recur args)))])]))
;match-and-extend : hash? (listof Pattern?) (listof Cafes-Value?)
(define (match-and-extend env params argvals)
  (cond [(empty? params) env]
        [else (match-and-extend (m-a-e/1 env (first params)
                                             (first argvals)
                                             (rest params)
                                             (rest argvals)))]))
;m-a-e/1
(define (m-a-e/1 pat val env)
  (type-case Pattern pat
    [paramPat (p) (hash-set env p val)]
    [structPat (nP fsP)
       (type-case Cafes-Value val
         [structV (n fs)
            (cond [(equal? nP n) (match-and-extend env fsP fs)]
                  [else (error "bad")])]
         [else (error "also bad")])]))