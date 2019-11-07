(ns bob)
(use 'clojure.string)

(defn response-for [s] ;; <- arglist goes here
  ;; your code goes here
  (cond
    (and  (ends-with? s "?") true)   "Sure."
    (ends-with? s "!") "Whatever."
    (ends-with? s "!") "Whoa, chill out!."
    (and  (ends-with? s "?") false)  "Calm down, I know what I'm doing!"
    ()
    )
  )

(defn isShout [s]
  (subs 0 (- (count s) 1))
  )
