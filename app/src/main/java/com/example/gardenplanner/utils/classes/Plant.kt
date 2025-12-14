package com.example.gardenplanner.utils.classes

data class PlantApiResponse(
    val data: List<Plant>
)

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
    val species: Species,
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

data class Species(
    val id: String,
    val commonName: String,
    val scientificName: String,
    val taxonomy: Taxonomy,
    val growthDetails: SpeciesGrowthDetails,
    val distribution: Distribution,
    val nativeStatus: String
)

data class Taxonomy(
    val family: String,
    val genus: String,
    val species: String,
    val familyCommonName: String,
    val category: String
)

data class SpeciesGrowthDetails (
    val growthHabit: String,
    val duration: String,
    val activeGrowthPeriod: String,
)

data class Distribution(
    val stateAndProvince: String,
)


val availablePlants = listOf("Tomato", "Corn", "Spinach")