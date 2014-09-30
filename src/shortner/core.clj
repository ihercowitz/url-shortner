(ns shortner.core)

(def ITENS (apply str (map char (concat (range 48 58) (range 65 91) (range 97 123)))))

(def urls (atom {}))

(defn- generate-short []
  (->> #(nth ITENS (rand-int 62))
       (repeatedly 5)
       (apply str)))

(defn url-short [url]
  (loop [short (generate-short)
         url url]
    (if-not (contains? @urls (keyword short))
      (do
        (swap! urls assoc (keyword short) url)
        short)
      (recur (generate-short) url))))

(defn url-unshort [short]
  (println short)
  (println @urls)
  (if-let [url ((keyword short) @urls)]
    url
    (println "URL not found")))
