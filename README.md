# GardenPlotPlanner

## Overview

GardenPlotPlanner is a gardening assistant app designed to simplify plant care and garden planning for users of all experience levels. The app scans seed packets to extract planting information and combines it with data from the **Verdantly API** to provide accurate, personalized gardening advice.

Our goal is to help users plan, care for, and track their plants based on key factors such as environment, plant type, available space, water requirements, sunlight needs, and growth trends.

---
## Instructions

Just boot up the app, log in, take a picture of your seed packet, and you're ready to go !

**VERDANTLY API KEY REQUIRED, THERE IS A FREE TIER IF YOU WISH TO TEST OUT THE APP**


* On the website: Go to this website to start your free trial and access an api key: https://rapidapi.com/verdantly-team-verdantly-team-default/api/verdantly-gardening-api
    * Once on the website, go to the left hand side bar and look under plant varieties.
    * Select any of the options
    * Once you selected an option, you should see an area to the right that says Code Snippets
    * Pick Kotlin as your target
    * Below you should see a block of code, in there you will see "x-rapidapi-key" and "x-rapidapi-host
    * Copy those values assigned to those properties and put them into your local.properties file as shown below



* In the code:
    * Under Gradle Scripts folder, go to local.properties and put in 2 variables: *RAPID_API_KEY=(your api)*, and *RAPID_API_HOST= verdantly-gardening-api.p.rapidapi.com*
    * dont wrap these variables in quotes and you should be good to go :)
     

---

## The Team

* **Selin Bacaz:**
    * Product Manager, Frontend & Lead UI/UX developer
 
* **Brandon Nauta:**
    * Frontend Engineer and UI/UX developer
      
* **Ryan Dahlke:**
    * Frontend Engineer & quality assurance

* **Ricky Kiamilev:**
    * Frontend developer
      
---

## Project Goals

The primary goals of this project are:

* **Seed Packet Scanning**
  Scan seed packets to automatically retrieve planting and care information.

* **Personalized Planting Advice**
  Recommend optimal planting layouts and care strategies based on:

  * Environment
  * Plant type
  * Available space
  * Water requirements
  * Space requirements
  * Sunlight needs

* **Watering Reminders & Notifications**
  Provide timely reminders for watering plants. This feature was strongly supported by survey responses and is a core focus of the app.

* **Garden History & Trends**
  Include a history tab that allows users to track plant growth and view long-term trends.

* **Plant Sitter Instruction Sheets**
  Generate clear, shareable instruction sheets so users can easily communicate care instructions to plant sitters.

These goals have remained largely consistent since the original proposal. The **instruction sheet feature** was added after feedback from a group critique session.

---

## Evaluation Criteria

We will evaluate the success of this project by:

* Testing the **accuracy and reliability** of the planting and care information provided by the app
* Conducting **hands-on testing** of features such as scanning, reminders, and garden plotting
* Gathering feedback from **end users** to assess usability and usefulness

---

## Existing Solutions

While there are gardening apps with overlapping features, none of the researched solutions combine all of the following in one platform:

* Plant tracking
* Garden layout and plotting
* Notifications and timers
* Automatic garden plot generation

GardenPlotPlanner aims to unify these features into a single, easy-to-use application.

---

## Target Users

### Novice Gardeners

Casual or beginner gardeners who may not know how to read seed packets or understand planting schedules. GardenPlotPlanner helps them learn the basics, including:

* Planting seasons
* Watering schedules
* Light requirements
* General plant care

### Experienced Gardeners

Hobbyists who are highly invested in gardening and already understand plant care fundamentals. These users benefit from:

* Plant tracking
* Growth history
* Reduced manual effort for scheduling and organization

### Former Gardeners

Users who previously gardened but stopped due to specific pain points (e.g., time management, forgetfulness, complexity). GardenPlotPlanner aims to address these issues and help them re-engage with gardening.

---

## Why These Users

We selected these target groups because GardenPlotPlanner provides clear value to each:

* **Novice gardeners** gain guided learning and confidence
* **Experienced gardeners** save time and effort
* **Former gardeners** receive targeted support to overcome past frustrations

By addressing both educational and organizational needs, GardenPlotPlanner makes gardening more accessible, efficient, and enjoyable for everyone.

---

## Figma for the intended UI of the app

<img width="3990" height="1489" alt="Android design (1)" src="https://github.com/user-attachments/assets/c6e55353-b97c-438d-b9e8-5c81019b1e93" />


---


## References, Inspiration & Competitor Analysis

The design and feature set of GardenPlotPlanner were informed by existing gardening applications and planning tools. While these platforms offer valuable functionality, none fully integrate all of the features GardenPlotPlanner aims to provide in a single experience.

### Inspiration & Comparable Apps

* **Grow Veg (Paid)**
  A garden planning app focused on vegetable garden layouts, complemented by a website offering educational articles on growing vegetables.

* **Planter**
  An app and website that allows users to plan garden layouts and track planting and harvesting schedules through calendar-based tools.

* **Veg Plotter**
  A detailed garden and allotment planning tool with a strong emphasis on visual layout of grow beds and vegetables.

* **Plant Parent**
  A plant care app that provides reminders (such as watering schedules) and uses the phone camera to help identify plant diseases.

* **Veggie Garden Planner**
  A simple, user-friendly interface for planning vegetable gardens, focused on ease of use rather than advanced analytics.

* **Seed to Spoon**
  An all-purpose gardening app offering garden plotting, growing advice, growth calendars, and a built-in AI assistant for user questions.

* **Planta**
  A general plant care app that focuses on reminders (watering and maintenance) and tracking plant growth over time.

* **Plant Daddy**
  An app centered on watering reminders and the creation of plant care instructions, particularly useful for short-term plant care management.

### Key Differentiation

While many of these tools provide strong individual features—such as reminders, plotting, or plant advice—GardenPlotPlanner aims to combine:

* Seed packet scanning
* Automated garden plot generation
* Personalized care advice using the Verdantly API
* Notifications and reminders
* Growth history and trend tracking
* Shareable plant sitter instruction sheets

into one cohesive application.

### References

* *User Guide – Almanac Garden Planner*. (n.d.). Almanac Garden Planner.
* GrowVeg. (n.d.). *Vegetable Garden Planner & Garden Planning Apps*.
* Planter. (n.d.). *Garden Planner*.
* VegPlotter. (n.d.). *Vegetable Garden & Allotment Planning Software*.
* GGG Ltd. (2022). *Plant Parent: Plant Care Guide*. App Store.
* Brain Software. (2018). *Veggie Garden Planner*. App Store.
* Joe Garden. (2017). *Seed to Spoon – Garden Planner*. App Store.
* Planta AB. (2018). *Planta: Plant & Garden Care*. App Store.
* Hipwell, J. (2020). *Plant Daddy – Water Reminders*. App Store.

---

## Status

This project is actively under development. Features and scope may evolve based on testing results and user feedback.
