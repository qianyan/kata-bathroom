(ns the-earliest-available-period-of-bathroom.core)

(defn the-earliest-available-recommand [rooms]
  (if (seq rooms)
    (->> rooms
         (map (fn [room]
                (let [{:keys [room-id periods]} room
                      available-periods (filter #(#{:available} (:status %)) periods)]
                  (if (seq available-periods)
                    (merge {:room-id room-id}
                           (select-keys (first available-periods) [:time]))
                    :no-available-room))))
         (sort-by :time)
         first)
    :no-available-room))
