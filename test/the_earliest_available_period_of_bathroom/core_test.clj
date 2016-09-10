(ns the-earliest-available-period-of-bathroom.core-test
  (:use midje.sweet)
  (:use [the-earliest-available-period-of-bathroom.core]))

(def room-1 {:room-id 1
             :periods [{:time "17:00-18:00"
                        :status :available}
                       {:time "18:00-19:00"
                        :status :occupied}]})

(def room-2 {:room-id 2
             :periods [{:time "17:00-18:00"
                        :status :occupied}
                       {:time "18:00-19:00"
                        :status :available}]})

(def room-3 {:room-id 3
             :periods [{:time "17:00-18:00"
                        :status :occupied}
                       {:time "18:00-19:00"
                        :status :available}
                       {:time "19:00-20:00"
                        :status :available}]})

(facts "about `the-earliest-avaible-period-of-bathroom`"
  (fact "should recommand the available if there is only one room with one available period"
    (the-earliest-available-recommand [room-1]) => {:room-id 1 :time "17:00-18:00"}
    (the-earliest-available-recommand [room-2]) => {:room-id 2 :time "18:00-19:00"})
  (fact "should recommand the earliest one if there is only one room with multiple available periods"
    (the-earliest-available-recommand [room-3]) => {:room-id 3 :time "18:00-19:00"}))
