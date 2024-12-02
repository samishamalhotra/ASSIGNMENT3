;; -------------
;; This is the menu template for the Fido app. You can use it as a starting
;; point for the assignment
;; ------------

(ns fido
  (:require [clojure.string :as str])
  (:require [clojure.java.io :as io])
  (:require [food])) ;; Correctly require the 'food' namespace

  ; this is where you would include/require the food module


;;-------------------
;; THE MENU FUNCTIONS
;; ------------------

;; Display the menu and ask the user for the option
(defn showMenu
  []
  (println "\n\n*** Let's Feed Fido ***")
  (println     "-----------------------\n")
  (println "1. Display list of map files")
  (println "2. Display a map for Fido")
  (println "3. Exit")
  (do 
    (print "\nEnter an option? ") 
    (flush) 
    (read-line)))


;; Display all files in the current folder
(defn option1
  []
  (println "Map List:")
   (doseq [file (file-seq (io/file "."))]
     (when (and (.isFile file) (.endsWith (.getName file) ".txt"))
       (println (str "* " (.getPath file)))))
   (println "\nPress any key to continue")
   (flush)
   (read-line) 
   (print (str (char 27) "[2J"))
   (flush))
    
;; Get the map specified by the user and start looking for the food
;;
(defn option2
  []
  (print "\nPlease enter a file name => ")
  (flush)
  (let [file-name (read-line) ; Read user input for the file name
        file (io/file file-name)] ; Create a file object
    (if (.exists file) ; Check if the file exists
      (let [map-content (slurp file)] ; Read the file's content
        (println "\nThis is Fido's challenge:\n")
        (println map-content) ; Display the map
        (if (food/validate-map map-content) ; Call validate-map from food.clj
          (println "\nThe map is valid! Fido can start searching for food.")
          (println "\nUnfortunately, this is not a valid food map for Fido.")))
      (println (str "\nOops: The file " file-name " does not exist. Please try again.")))))


; If the menu selection is valid, call the relevant function to 
; process the selection
(defn processOption [option] 
  (if( = option "1")(option1)
   (if( = option "2") (option2)
     (println "Invalid menu option"))))


; Display the menu and get a menu item selection. Process the
; selection and then loop again to get the next menu selection
(defn menu
  [] ; parm(s) can be provided here, if needed
  (let [option (str/trim (showMenu))]
    (if (= option "3")
      (println "\nGood Bye\n")
      (do 
         (processOption option)
         (recur )))))   



; ------------------------------
; Run the program.
(menu)
