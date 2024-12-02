;; food.clj
(ns food
  (:require [clojure.string :as str]))

(defn validate-map [map-content]
  (let [lines (str/split map-content #"\n")
        row-lengths (map count lines)
        first-row-length (first row-lengths)]
    (every? #(= first-row-length %) row-lengths)))  ;; Checks if all rows are the same length
