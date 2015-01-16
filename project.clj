(defproject msg/salesforce "1.0.2"
  :plugins [[s3-wagon-private "1.1.2"]]
  :description "A clojure library for accessing the salesforce api"
  :url "http://owainlewis.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-http "0.7.2"]
                 [cheshire "5.1.1"]]


  :release-tasks
  [["vcs" "assert-committed"]
   ["change" "version" "leiningen.release/bump-version" "release"]
   ["vcs" "commit"]
   ["deploy"]
   ["change" "version" "leiningen.release/bump-version"]
   ["vcs" "commit"]
   ["vcs" "push"]]
  :repositories {"releases"
                                       {:url "s3p://msg-jars/releases/"
                                        :username   ~(System/getenv "MSG_AWS_ACCESS_KEY")
                                        :passphrase ~(System/getenv "MSG_AWS_SECRET_KEY")
                                        :sign-releases false}
                 "sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"})