package com.example.gardenplanner.utils.classes

data class Plants (
    val name: String,
    val sunlight: String,
    val wateringInterval: Int,
    val harvestTime: Int,
    val summary: String
)

val DefaultPlantsAdvice = listOf(
    Plants(
        name = "Tomato",
        wateringInterval = 2,
        harvestTime = 75,
        sunlight = "Full",
        summary = "Plant in full sun, water consistently, stake or cage early, and prune lower leaves to improve airflow."
    ),
    Plants(
        name = "Corn",
        wateringInterval = 3,
        harvestTime = 90,
        sunlight = "Full",
        summary = "Grow in full sun, plant in blocks for proper pollination, keep soil evenly moist, and fertilize regularly."
    )
)