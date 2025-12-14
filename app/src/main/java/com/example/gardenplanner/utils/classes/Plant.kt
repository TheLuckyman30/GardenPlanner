package com.example.gardenplanner.utils.classes

data class Plant(
    val id: String,
    val mappingId: String,
    val category: String,
    val name: String,
    val type: String,
    val subtype: String,
    val description: String,
    val growingRequirements: GrowingRequirements,
    val growthDetails: GrowthDetails,
    val lifecycleMilestones: LifecycleMilestones,
    val careInstructions: CareInstructions,
    val commonUses: String,
    val pestAndDiseaseRisks: String,
    val highlights: String,
    val history: String,
)

data class GrowingRequirements(
    val minGrowingZone: Int,
    val maxGrowingZone: Int,
    val growingZoneRange: String,
    val careInstructions: String,
    val soilPreference: String,
    val sunlightRequirement: String,
    val waterRequirement: String,
    val preferredTemperature: String,
    val spacingRequirement: String,
)

data class GrowthDetails(
    val growthPeriod: String,
    val growthType: String,
    val matureHeight: Int,
    val matureWidth: Int
)

data class LifecycleMilestones(
    val avgFirstBloomDate: String,
    val firstHarvestDate: String,
    val lastHarvestDate: String
)

data class CareInstructions(
    val plantingInstructions: PlantingInstructions,
    val pruningInstructions: String,
    val harvestingInstructions: String,
)

data class PlantingInstructions(
    val startIndoors: String,
    val transplantOutdoors: String,
    val directSow: String,
)


val availablePlants = listOf("Tomato", "Corn", "Spinach")