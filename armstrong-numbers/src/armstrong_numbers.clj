(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [numbers (map #(Character/getNumericValue %) (str num))]
    (let [size (count numbers)]
      (= num (reduce + (map #(exp % size) numbers)))
      )
    )
)
