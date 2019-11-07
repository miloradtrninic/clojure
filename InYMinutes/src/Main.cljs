(ns Main)

(str "Hello" " " "World")

(+ 1 1)

(- 2 1)

(* 2 1)

(/ 2 4)

(= 1 1)

(= 2 1)

(not (= 2 1))

(+ 1 (- 3 2))

(class 1)

(class 1.)

(class "")

(class false)

(class nil)

(+ 1 2)

(eval (+ 1 2))

; Collections and sequences

(class [1 2 3])

(class '(1 2 3))

(class (list 1 2 3))

(coll? '(1 2 3))

(coll? [1 2 3])

(seq? '(1 2 3))

(seq? [1 2 3])

(range 4)

(range 10)

(take 4 (range))

(cons 4 [1 2 3])

(cons 4 '(1 2 3))

(conj [1 2 3] 4)

(conj '(1 2 3) 4)

(map inc [1 2 3])

(filter even? [1 2 3])

(reduce * [1 2 3 4])

(reduce conj [] '(1 2 3 4))

(fn [] "hello world")

(def x 1)

(str "" x)

(def hello (fn [] "Hello world"))

(hello)

(defn hello
  "docstring"
  []
  "hello w short")

(hello)

((defn hello
  [name]
  (str "Hello " name)) "mile")


(helloYou "mile")

(def hello2 #(str "Hello " %1))

(hello2 "MIle")

(defn hello3
      ([] "Hello world 3")
      ([name] (str "Hello 3 " name)))

(hello3)
(hello3 "Mike")

(defn count-args [& args]
      (str "You passed " (count args) " args: " args))
(count-args 1 2 3)

(defn hello-count [name & args]
      (str "Hello " name " ,you passed " (count args) " extra args"))
(hello-count "Finn" 1 2 3)

(class {:a 1 :b 2 :c 3})

(class (hash-map :a 1 :b 2 :c 3))

(class :a)

(def stringmap {"a" 1 "b" 2 "c" 3})
(print stringmap)


(def keymap {:a 1 :b 2 :c 3})
(print keymap)

(stringmap "a")

(keymap :a)

(:b keymap)

(def newKeyMap (assoc keymap :d 4))

(print newKeyMap)

(print (dissoc newKeyMap :a :b))

(class #{1 2 3})

(set [1 2 3 4 56 6])

(conj #{12 2 3} 4)

(disj #{1 2 3} 1)

(#{1 2 3} 1)

(#{1 2 3} 4)

(if (= 0 1) "a" "b")

(if (= 0 1) "a")

(let [a 1 b 2] (> a b))

(do (print "Hello") "World")

(defn print-and-say-hello [name]
      (print "Saying hello to " name)
      (str "Hello " name))
(print-and-say-hello "Jeff")

(let [name "Urkel"] (print "Saying hello to " name) )

(-> {:a 1 :b 2}
    (assoc :c 3)
    (dissoc :b))

(->> (range 10)
     (map inc)
     (filter odd?)
     (into []))

(as-> [1 2 3] input
      (map inc input)
      (nth input 2)
      (conj [4 5 6] input [8 9 10]))

(def my-atom (atom {}))

