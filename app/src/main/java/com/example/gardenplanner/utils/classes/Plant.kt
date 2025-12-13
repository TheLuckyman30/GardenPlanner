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
    val history: String
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
    val spacingRequirement: String
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
    val harvestingInstructions: String
)

data class PlantingInstructions(
    val startIndoors: String,
    val transplantOutdoors: String,
    val directSow: String
)

val DefaultPlantsAdvice = listOf(
    Plant(
        id = "107b8dbb-9fc1-4417-adff-2f647f274969",
        mappingId = "85ccf041-12ca-4748-ac51-dda0cd14251f",
        category = "vegetable",
        name = "Sungold Tomato",
        type = "tomato",
        subtype = "cherry tomato",
        description = "A cherry tomato variety known for its exceptionally sweet and tangy flavor, bright orange color, and early harvest.",
        growingRequirements = GrowingRequirements(
            minGrowingZone = 3,
            maxGrowingZone = 10,
            growingZoneRange = "3-10",
            careInstructions = "Stake or cage for support. Water regularly to prevent cracking.",
            soilPreference = "Well-drained, fertile soil with high organic matter",
            sunlightRequirement = "Full sun",
            waterRequirement = "Medium to high",
            preferredTemperature = "70-85°F",
            spacingRequirement = "18-24 inches between plants"
        ),
        growthDetails = GrowthDetails(
            growthPeriod = "Annual",
            growthType = "Indeterminate",
            matureHeight = 60,
            matureWidth = 24
        ),
        lifecycleMilestones = LifecycleMilestones(
            avgFirstBloomDate = "50-60 days after sowing",
            firstHarvestDate = "65 days after transplanting",
            lastHarvestDate = "Until first frost"
        ),
        careInstructions = CareInstructions(
            plantingInstructions = PlantingInstructions(
                startIndoors = "6-8 weeks before last frost",
                transplantOutdoors = "After last frost when soil is warm",
                directSow = "Not recommended"
            ),
            pruningInstructions = "Remove suckers to improve airflow",
            harvestingInstructions = "Harvest when fruit turns deep golden orange"
        ),
        commonUses = "Fresh eating, salads, snacking",
        pestAndDiseaseRisks = "Aphids, whiteflies, tomato blight",
        highlights = "Extremely sweet, early-producing cherry tomato",
        history = "Bred in Japan for exceptional flavor"
    ),

    Plant(
        id = "d23a2c8e-31f7-4e98-9db4-11f8d93b1a12",
        mappingId = "3b2f6f1a-7c2d-4f09-a6c0-88a94f01aabc",
        category = "vegetable",
        name = "Spinach",
        type = "leafy green",
        subtype = "spinacia oleracea",
        description = "A fast-growing leafy green known for its nutritional value and cool-season tolerance.",
        growingRequirements = GrowingRequirements(
            minGrowingZone = 2,
            maxGrowingZone = 9,
            growingZoneRange = "2-9",
            careInstructions = "Keep soil consistently moist. Prefers cool weather.",
            soilPreference = "Moist, well-drained soil rich in nitrogen",
            sunlightRequirement = "Full sun to partial shade",
            waterRequirement = "Medium",
            preferredTemperature = "50-70°F",
            spacingRequirement = "6-8 inches between plants"
        ),
        growthDetails = GrowthDetails(
            growthPeriod = "Annual",
            growthType = "Leafy",
            matureHeight = 12,
            matureWidth = 8
        ),
        lifecycleMilestones = LifecycleMilestones(
            avgFirstBloomDate = "Rarely flowers before harvest",
            firstHarvestDate = "30-40 days after sowing",
            lastHarvestDate = "Before bolting in warm weather"
        ),
        careInstructions = CareInstructions(
            plantingInstructions = PlantingInstructions(
                startIndoors = "Optional, 3-4 weeks before last frost",
                transplantOutdoors = "Early spring or fall",
                directSow = "Recommended as soon as soil is workable"
            ),
            pruningInstructions = "Not required",
            harvestingInstructions = "Harvest outer leaves first for continuous growth"
        ),
        commonUses = "Salads, cooking, smoothies",
        pestAndDiseaseRisks = "Leaf miners, downy mildew",
        highlights = "Cold-hardy, fast-growing leafy green",
        history = "Cultivated for over 2,000 years originating in Persia"
    )
)