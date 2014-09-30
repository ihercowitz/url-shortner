(defproject shortner "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.9"]
                 [ring/ring-core "1.3.1"]
                 [ring/ring-codec "1.0.0"]
                 [ring/ring-jetty-adapter "1.3.1"]]

  :profile {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]]}}
  :main shortner.bootstrap)
