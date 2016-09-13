(ns the-earliest-available-period-of-bathroom.core)

(defn the-earliest-available-recommand [rooms]
  (letfn [(period [{:keys [periods]}]
            (-> periods
                (->> (filter #(#{:available} (:status %))))
                (first)
                (select-keys [:time])))]
    (-> rooms
        (->> (map (juxt first period))
             (map #(into {} %))
             (remove (complement :time))
             (sort-by :time)
             (first))
        (or :no-available-room))))
