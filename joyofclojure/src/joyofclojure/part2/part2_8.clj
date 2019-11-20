(ns joyofclojure.part2.part2-8
  (:import (java.util HashMap Date)
           (java.awt Point)))

(Math/sqrt 9)
;=> 3.0

(new Point 0 1)
;=> #<Point java.awt.Point[x=0,y=1]>

(new HashMap {"foo" 42 "bar" 9 "baz" "quux"})
;=> {"baz" "quux", "foo" 42, "bar" 9}

(HashMap. {"foo" 42 "bar" 9 "baz" "quux"})
;=> {"baz" "quux", "foo" 42, "bar" 9}

(.-x (Point. 10 20))
;=> 10

(.divide (BigDecimal. "42") 2M)
;=> 21M

(let [origin (Point. 0 0)]
  (set! (.-x origin) 15)
  (str origin))
;=> "java.awt.Point[x=15,y=0]"

;new java.util.Date().toString().endsWith("2014") /* Java code */
(.endsWith (.toString (Date.)) "2014") ; Clojure code
;=> true

(doto (java.util.HashMap.)
  (.put "HOME" "/home/me")
  (.put "SRC" "src")
  (.put "BIN" "classes"))