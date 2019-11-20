(ns joyofclojure.part2.part2_6)

;Locals, loops, and blocks

; only last expression returned
(defn block [x y]
  ((do
  (def x 5)
  (def y 4)
  (+ x y)
  [x y])))

;locals
(defn locals []
  (let [r
        5
        pi
        3.1415
        r-squared (* r r)]
    (println "radius is" r)
    (* pi r-squared))
  )

;recur prints the integers from x to 1, counting backward
(defn print-down-from [x]
  (when (pos? x)
    (println x)
    (recur (dec x))))
;loop
(defn sum-down-from [initial-x]
  (loop [sum 0, x initial-x]
    (if (pos? x)
      (recur (+ sum x) (dec x))
      sum)))
;tail
(defn absolute-value [x]
  (if (pos? x)
    x ; "then" clause
    (- x))) ; "else" clause

;tail error
(defn tailErr [x] (recur x) (println x))
