(ns app.core
  (:require ["@tauri-apps/api/tauri" :as tauri]
            ["@mui/joy" :as jy]
            [reagent.dom.client :as rdc]
            [reagent.dom :as rd]
            [reagent.core :as r]))

(defn some-component []
  [:div
   [:h3 "I am a component!"]
   [:> jy/Sheet 
    {:sx {:width 300
          :mx "auto"
          :my 4
          :py 3
          :px 2
          :display "flex"
          :flexDirection "column"
          :gap 2
          :borderRadius "sm"
          :boxShadow "md"}}
    "Welcome!"]
    
   [:> jy/Button
      {:variant "solid"}
      "Hello"]
   [:p.someclass
    "I have " [:strong "bold"]
    [:span {:style {:color "red"}} " and red"]
    " text."]])

(defonce root (rdc/create-root (js/document.getElementById "root")))

(defn ^:dev/after-load mountit []
  (rdc/render root [some-component]))

(defn ^:export main []
  (mountit))
