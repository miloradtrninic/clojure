(ns joyofclojure.part2.part4.part4)

;Truncation
(let [imadeuapi 3.14159265358979323846264338327950288419716939937M]
  (println (class imadeuapi))
  imadeuapi)
; java.math.BigDecimal
;=> 3.14159265358979323846264338327950288419716939937M

;no M
(let [butieatedit 3.14159265358979323846264338327950288419716939937]
  (println (class butieatedit))
  butieatedit)
; java.lang.Double
;=> 3.141592653589793

(def clueless 9)

(class clueless)
;=> java.lang.Long default

(class (+ clueless 9000000000000000))
;=> java.lang.Long

(class (+ clueless 90000000000000000000))
;=> clojure.lang.BigInt

(class (+ clueless 9.0))
;=> java.lang.Double)

(+ Long/MAX_VALUE Long/MAX_VALUE)
;=> java.lang.ArithmeticException: integer overflow

(unchecked-add (Long/MAX_VALUE) (Long/MAX_VALUE))
;=> -2

(float 0.0000000000000000000000000000000000000000000001)
;=> 0.0

1.0E-430
;=> 0.0

(let [approx-interval (/ 209715 2097152)
      ;Patriot’s approx 0.1
      actual-interval (/ 1 10)
      hours (* 3600 100 10)
      actual-total (double (* hours actual-interval))
      approx-total
      (double (* hours approx-interval))]
  (- actual-total approx-total))
;0.34332275390625

; doubles and floats add to rounding errors
(+ 0.1M 0.1M 0.1M 0.1 0.1M 0.1M 0.1M 0.1M 0.1M 0.1M)
;=> 0.9999999999999999

;rationals
(def a (rationalize 1.0e50))
(def b (rationalize -1.0e50))
(def c (rationalize 17.0e00))

(+ (+ a b) c)
;;=> 17N
(+ a (+ b c))
;;=> 17N

(numerator (/ 123 10))
;=> 123
(denominator (/ 123 10))
;=> 10

(def population {:zombies 2700 :humans 10})

(get population :zombies)

(println (/ (get population :zombies)
            (get population :humans))
         "zombies per capita")
; 300 zombies per capita

(:zombies population)
;=> 2700
(println (/ (:zombies population)
            (:humans population))
         "zombies per capita")
; 300 zombies per capita

(defn pour [lb ub]
  (cond
    (= ub :toujours) (iterate inc lb)
    :else (range lb ub)))                                   ; :else is always true ,it is a trick

(pour 1 10)
;=> (1 2 3 4 5 6 7 8 9)

(pour 1 :toujours)
; ... runs forever

;Symbolic resolution

(identical? 'goat (symbol goat))
;=> false

(= 'goat 'goat)
;=> true

(name 'goat)
;"goat"

(let [x 'goat y x]
  (identical? x y))
; true

(let [x (with-meta 'goat {:ornery true})
      y (with-meta 'goat {:ornery false})]
  [(= x y)
   (identical? x y)
   (meta x)
   (meta y)])
;=> [true false {:ornery true} {:ornery false}]
