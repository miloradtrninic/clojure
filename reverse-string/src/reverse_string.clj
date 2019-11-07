(ns reverse-string)

(defn reverse-string [s] ;; <- arglist goes here
  ;; your code goes here
  (apply str (reduce conj () s))
)
