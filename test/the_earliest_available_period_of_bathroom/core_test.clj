(ns the-earliest-available-period-of-bathroom.core-test
  (:use midje.sweet)
  (:use [the-earliest-available-period-of-bathroom.core]))

(def room-1 {:room-id 1
    :periods [{:time "17:00-18:00"
               :status :available}
              {:time "18:00-19:00"
               :status :occupied}]})


(facts "about `the-earliest-avaible-period-of-bathroom`"
  (fact "should recommand if there is only one room with available period"
    (the-earliest-available-recommand rooms) => {:room-id 1 :time "17:00-18:00"}))
