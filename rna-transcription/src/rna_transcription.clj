(ns rna-transcription)

(defn to-rna [dna] ;; <- arglist goes here
  ;; your code goes here
  (apply str (map #(cond
          (= % \G) "C"
          (= % \C) "G"
          (= % \U) "A"
          (= % \A) "T") dna))
)
