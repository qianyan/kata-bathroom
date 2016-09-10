(ns the-earliest-available-period-of-bathroom.core)

(defn the-earliest-available-recommand [rooms]
  (letfn [(period [{:keys [periods]}]
            (-> periods
                (->> (filter #(#{:available} (:status %)))
                     ffirst)
                (or [:time ::non-available])))]
    (-> rooms
        (->> (map (fn [room]
                    (apply conj {} ((juxt first period) room))))
             (remove #(#{::non-available} (:time %)))
             (sort-by :time)
             first)
        (or :no-available-room))))
