(ns shortner.bootstrap
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [ring.adapter.jetty :as jetty]
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
  (GET "/s" [url] (->> (shortner/url-short url)
                                       (str "http://clshortme.herokuapp.com/")
                                       format-url))
  (GET "/:short" [short] (->> (shortner/url-unshort short)
                              redirect)))


(def app
  (-> (handler/api shortner-routes)))

(defn -main [& args]
  (let [port (Integer. (or (System/getenv "PORT") "8000"))]
    (jetty/run-jetty #'app {:port port})))
