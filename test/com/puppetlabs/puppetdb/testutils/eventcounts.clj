(ns com.puppetlabs.puppetdb.testutils.eventcounts
  (:require [com.puppetlabs.puppetdb.query.eventcounts :as event-counts]))

(defn event-counts-query-result
  ;; TODO docs
  ([query summarize-by]
    (event-counts-query-result query summarize-by {}))
  ([query summarize-by extra-query-params]
    (->> (event-counts/query->sql query summarize-by extra-query-params)
         (event-counts/query-event-counts)
         (set))))
