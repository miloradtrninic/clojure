(ns joyofclojure.part1.part2.part2-10
  (:require [clojure.set :as s])
  (:require [clojure.string :refer (capitalize)])
  (:refer clojure.set :rename {union onion}))

(s/intersection #{1 2 3} #{3 4 5})
;=> #{3}

(map capitalize ["kilgore" "trout"])
;=> ("Kilgore" "Trout")

(onion #{1 2} #{4 5})
;=> #{1 2 4 5}