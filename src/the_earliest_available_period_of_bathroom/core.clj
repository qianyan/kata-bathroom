(ns the-earliest-available-period-of-bathroom.core)

(defn the-earliest-available-recommand [rooms]
  (let [{:keys [room-id periods]} (first rooms)
        available-periods (filter #(#{:available} (:status %)) periods)]
    (if (seq available-periods)
      (merge {:room-id room-id}
             (select-keys (first available-periods) [:time]))
      :no-available-room)))
