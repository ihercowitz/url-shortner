(ns shortner.bootstrap
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [ring.adapter.jetty :as jetty]
            [ring.util.codec :refer [url-encode url-decode]]
            [shortner.core :as shortner]))

(defn format-url [short-url]
  {:status 200
   :body   short-url})

(defn redirect [url]
  {:status 302
   :headers {"Location" url}
   :body ""})

(defroutes shortner-routes
  (GET "/" [] "Hello world")
  (GET "/s" {params :params headers :headers} (->> (:url params)
                                                   url-encode
                                                   shortner/url-short
                                                   (str "http://" (get headers "host") "/")
                                                   format-url))
  (GET "/:short" [short] (->> (shortner/url-unshort short)
                              url-decode
                              redirect)))


(def app
  (-> (handler/api shortner-routes)))

(defn -main [& args]
  (let [port (Integer. (or (System/getenv "PORT") "8000"))]
    (jetty/run-jetty #'app {:port port})))
