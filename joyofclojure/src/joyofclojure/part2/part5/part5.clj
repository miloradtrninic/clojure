(ns joyofclojure.part2.part5.part5)

(def ds (into-array [:willlie :barnabas :adam]))
(seq ds)
;=> (:willie :barnabas :adam)

(aset ds 1 :quentin)
;=> :quentin
(seq ds)
;=> (:willie :quentin :adam)

(def ds [:willie :barnabas :adam])
ds
;=> [:willie :barnabas :adam]
(def ds1 (replace {:barnabas :quentin} ds))
ds                                                          ;immutable
;=> [:willie :barnabas :adam]
ds1
;=> [:willie :quentin :adam]

(= [1 2 3] '(1 2 3))                                        ;sequences
;=> true

(= [1 2 3] #{1 2 3})                                        ;sequence and set
;=> false

(seq (hash-map :a 1))
;=> ([:a 1])

(class (seq (hash-map :a 1)))
;=> clojure.lang.PersistentHashMap$NodeSeq

(seq (keys (hash-map :a 1)))
;=> (:a)
(class (keys (hash-map :a 1)))
;=> clojure.lang.APersistentMap$KeySeq

; vectors
(vec (range 10))
;=> [0 1 2 3 4 5 6 7 8 9]

(let [my-vec [:a :b :c]]
  (into my-vec (range 10)))
;=> [:a :b :c 0 1 2 3 4 5 6 7 8 9]

(into (vector-of :int) [Math/PI 2 1.3])
;=> [3 2 1]
(into (vector-of :char) [100 101 102])
;=> [\d \e \f]
(into (vector-of :int) [1 2 623876371267813267326786327863])
; java.lang.IllegalArgumentException: Value out of range for int:  -8359803716404783817

(def a-to-j (vec (map char (range 65 75))))
a-to-j
;;=> [\A \B \C \D \E \F \G \H \I \J]

(nth a-to-j 4)
;;=> \E
(get a-to-j 4)
;;=> \E
(a-to-j 4)
;;=> \E

(seq a-to-j)
;=> (\A \B \C \D \E \F \G \H \I \J)

(rseq a-to-j)
;=> (\J \I \H \G \F \E \D \C \B \A)

(assoc a-to-j 4 "no longer E")
;=> [\A \B \C \D "no longer E" \F \G \H \I \J]

(replace {2 :a, 4 :b} [1 2 3 2 3 4])
;=> [1 :a 3 :a 3 :b]

(def matrix [[1 2 3]
             [4 5 6]
             [7 8 9]])
(get-in matrix [1 2])
;=> 6
; fn with -in suffix will go into the vector, assoc-in, update-in etc.

(def my-stack [1 2 3])

(peek my-stack)
; 3

(pop my-stack)
; [1 2]

(conj my-stack 4)
; adds to end [1 2 3 4]

(+ (peek my-stack) (peek (pop my-stack)))
; pop returns a new stack
;=>5

(defn strict-map1 [f coll]
  (loop [coll coll, acc nil]
    (if (empty? coll)
      (reverse acc)
      (recur (next coll)
             (cons (f (first coll)) acc)))))
(strict-map1 - (range 5))
;;=> (0 -1 -2 -3 -4)
; subvectors, by indices
(subvec a-to-j 3 6)
;=> [\D \E \F]

;map nodes as vectors
(first {:width 10, :height 20, :depth 15})
;=> [:depth 15]

;doseq with destructuring
(doseq [[dimension amount] {:width 10, :height 20, :depth 15}]
  (println (str (name dimension) ":") amount "inches"))
; width: 10 inches
; height: 20 inches
; depth: 15 inches
;=> nil


;lists (list -> list processing)
; add on front
(cons 1 '(2 3))
;=> (1 2 3)
(conj '(2 3) 1)
;=> (1 2 3)

(def schedule
  (conj clojure.lang.PersistentQueue/EMPTY
        :wake-up :shower :brush-teeth))
schedule
;=> <-(:wake-up :shower :brush-teeth)-<
(peek schedule)
;=> :wake-up
(pop schedule)
;=> <-(:shower :brush-teeth)-<
(rest schedule)
;=> (:shower :brush-teeth)

; persistent sets
(#{:a :b :c :d} :c)
;=> :c
(#{:a :b :c :d} :e)
;=> nil
(get #{:a 1 :b 2} :b)
;=> :b

(get #{:a 1 :b 2} :z :nothing-doing)
;=> :nothing-doing

(into #{[]} [()])
;;=> #{[]}
; no duplicates
(into #{[1 2]} '[(1 2)])
;;=> #{[1 2]}

;even though [] and () are of differing types, they’re con-
;sidered equal because their elements are equal or (in this case) empty
(into #{[] #{} {}} [()])
;;=> #{#{} {} []}

(sorted-set :b :c :a)
;=> #{:a :b :c}

(sorted-set [3 4] [1 2])
;=> #{[1 2] [3 4]}

(sorted-set :b :c :a)
;=> #{:a :b :c}
(sorted-set [3 4] [1 2])
;=> #{[1 2] [3 4]}
(sorted-set :b 2 :c :a 3 1)
; java.lang.ClassCastException:
; clojure.lang.Keyword cannot be cast to java.lang.Number

(contains? #{1 2 4 3} 4)
;=> true
(contains? [1 2 4 3] 4)
;=> false



