(ns joyofclojure.part1.part3.part3-1)

;Truthiness

(if true :true :false)                                      ;true
(if [] :truthy :falsey)                                     ;falsey
(if nil :true :false)                                       ;false
(if false :true :false)                                     ;false

(def evil-false (Boolean. "false")) ; NEVER do this

(= false evil-false)
;=> true

(if evil-false :truthy :falsey)
;=> :truthy

(when (nil? nil) "Actually nil, not false")
;=> "Actually nil, not false"

(seq [1 2 3])
;=> (1 2 3)

(seq [])
;=> nil

;prints seq
(defn print-seq [s]
  (when (seq s)
    (prn (first s))
    (recur (rest s))))

(print-seq [])
;=> nil

(print-seq [1 2])
; 1
; 2
;=> nil