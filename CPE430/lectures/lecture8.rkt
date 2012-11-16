#lang plai

(define-type FWAE-value
  [numv (n number?)]
  [boolv (b boolean?)]
  [funv (param symbol?)
        (body FWAE?)]
  