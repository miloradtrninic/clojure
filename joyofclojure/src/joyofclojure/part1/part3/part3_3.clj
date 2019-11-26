(ns joyofclojure.part1.part3.part3-3)

;Destructuring
; last name, middle name
(def guys-whole-name ["Guy" "Lewis" "Steele"])

(str (nth guys-whole-name 2) ", "
     (nth guys-whole-name 0) " "
     (nth guys-whole-name 1))
;=> "Steele, Guy Lewis"

(let [[f-name m-name l-name] guys-whole-name]
  (str l-name ", " f-name " " m-name))

(let [[a b c & more] (range 10)]
  (println "a b c are:" a b c)
  (println "more is:" more))
; a b c are: 0 1 2
; more is: (3 4 5 6 7 8 9)
;=> nil

(let [range-vec (vec (range 10))
      [a b c & more :as all] range-vec]
  (println "a b c are:" a b c)
  (println "more is:" more)
  (println "all is:" all))
; a b c are: 0 1 2
; more is: (3 4 5 6 7 8 9)
; all is: [0 1 2 3 4 5 6 7 8 9]
;=> nil

(def guys-name-map {:f-name "Guy" :m-name "Lewis" :l-name "Steele"})

(let [{f-name :f-name, m-name :m-name, l-name :l-name} guys-name-map]
  (str l-name ", " f-name " " m-name))

; keys will look up map with given keys and assign the value
(let [{:keys [f-name m-name l-name]} guys-name-map]
  (str l-name ", " f-name " " m-name))

(let [{f-name :f-name, :as whole-name} guys-name-map]
  (println "First name is" f-name)
  (println "Whole name is below:")
  whole-name)
;; First name is Guy
;; Whole name is below:
;;=> {:f-name "Guy", :m-name "Lewis", :l-name "Steele"}

; fill in with or if it is not found in the map
(let [{:keys [title f-name m-name l-name],
       :or {title "Mr."}} guys-name-map]
  (println title f-name m-name l-name))
; Mr. Guy Lewis Steele
;=> nil

(defn whole-name [& args]
  (let [{:keys [f-name m-name l-name]} args]
    (str l-name ", " f-name " " m-name)))
;(whole-name :f-name "Guy" :m-name "Lewis" :l-name "Steele")
;;=> "Steele, Guy Lewis"

; associative destructing
(let [{first-thing 0, last-thing 3} [1 2 3 4]]
  [first-thing last-thing])
;=> [1 4]

; des in fn args
(defn print-last-name [{:keys [l-name]}]
  (println l-name))
(print-last-name guys-name-map)
; Steele