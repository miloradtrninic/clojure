(ns joyofclojure.part1.part2.part2-9)

;Exceptional circumstances

;Throwing and catching
(throw (Exception. "I done throwed"))
;=> java.lang.Exception: I done throwed ...

(defn throw-catch [f]
  [(try
     (f)
     (catch ArithmeticException e "No dividing by zero!")
     (catch Exception e (str "You are so bad " (.getMessage e)))
     (finally (println "returning... ")))])

(throw-catch #(/ 10 5))
; returning...
;=> [2]

(throw-catch #(/ 10 0))
; returning...
;=> ["No dividing by zero!"]

(throw-catch #(throw (Exception. "Crybaby")))
; returning...
;=> ["You are so bad Crybaby"]