(ns joyofclojure.part1.part2.part2-7)

; evaluation

(cons 1 [2 3])

; cons evals to fn, 1 to 1 and [2 3] to vect [2 3]
; list cons 1 [2 3] evals to fn call cons with arguments 1 [2 3]

;quoting, skip eval
(quote age)

(def age 9)
(quote age)
;=> age

(quote (cons 1 [2 3]))
;=> (cons 1 [2 3])

(cons 1 (2 3))
; java.lang.ClassCastException:
; java.lang.Integer cannot be cast to clojure.lang.IFn
; list requires fn first

(cons 1 (quote (2 3)))
;=> (1 2 3)
; short hand
(cons 1 '(2 3))
;=> (1 2 3)

;syntax quote ##############
`(1 2 3)
;=> (1 2 3)

`map
;=> clojure.core/map
`Integer
;=> java.lang.Integer
`(map even? [1 2 3])
;=> (clojure.core/map clojure.core/even? [1 2 3])

`(+ 10 (* 3 2))
;=> (clojure.core/+ 10 (clojure.core/* 3 2))

`(+ 10 ~(* 3 2))
;=> (clojure.core/+ 10 6)

(let [x 2] `(1 ~x 3))
;=> (1 2 3)
`(1 ~(2 3))
;; ClassCastException java.lang.Long
;; cannot be cast to clojure.lang.IFn

(let [x '(2 3)] `(1 ~x))
;=> (1 (2 3))

(let [x '(2 3)] `(1 ~@x))
;=> (1 2 3)

