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

val DefaultPlantsAdvice = listOf(Plant(
    id = "fe039c34-ef51-409c-a238-b9c30f4bbb92",
    mappingId = "613a1110-d758-4426-95db-172d0a225911",
    category = "vegetable",
    name = "Abraham Lincoln Tomato",
    type = "tomato",
    subtype = "slicer tomato",
    description = "A deep red, juicy heirloom known for its rich, sweet flavor.",
    growingRequirements = GrowingRequirements(
        minGrowingZone = 4,
        maxGrowingZone = 10,
        growingZoneRange = "4-10",
        careInstructions = "Provide strong trellising to support heavy fruit production.",
        soilPreference = "Loamy, well-draining soil with added compost",
        sunlightRequirement = "Full sun",
        waterRequirement = "Moderate",
        preferredTemperature = "70-85°F",
        spacingRequirement = "18-24 inches apart"
    ),
    growthDetails = GrowthDetails(
        growthPeriod = "Annual",
        growthType = "Vine",
        matureHeight = 72,
        matureWidth = 36
    ),
    lifecycleMilestones = LifecycleMilestones(
        avgFirstBloomDate = "Mid-spring",
        firstHarvestDate = "Mid-summer",
        lastHarvestDate = "Late summer"
    ),
    careInstructions = CareInstructions(
        plantingInstructions = PlantingInstructions(
            startIndoors = "Yes, 6-8 weeks before last frost.",
            transplantOutdoors = "After last frost date.",
            directSow = "Not recommended."
        ),
        pruningInstructions = "Prune regularly for better airflow and disease prevention.",
        harvestingInstructions = "Harvest when fruit turns deep red and slightly soft."
    ),
    commonUses = "Fresh eating, slicing, cooking",
    pestAndDiseaseRisks = "Blight, aphids, nematodes",
    highlights = "Juicy, sweet, historic heirloom.",
    history = "Abraham Lincoln tomatoes date back to the late 1920s and were one of the first popular commercial tomato varieties. Unlike modern hybrids, they offer a true old-fashioned tomato taste with a balance of sweetness and acidity. Their ability to grow in a variety of climates makes them a reliable choice for gardeners. Today, they remain one of the most prized heirloom slicers in cultivation."
))

val availablePlants = listOf(
    // Vegetables
    "Tomato", "Spinach", "Carrot", "Broccoli", "Lettuce", "Bell Pepper",
    "Cabbage", "Cauliflower", "Kale", "Zucchini", "Cucumber", "Eggplant",
    "Radish", "Beetroot", "Celery", "Asparagus", "Brussels Sprouts", "Okra",
    "Leek", "Turnip", "Parsnip", "Pumpkin", "Sweet Potato", "Garlic",

    // Fruits
    "Apple", "Strawberry", "Blueberry", "Mango", "Watermelon", "Peach",
    "Pear", "Cherry", "Grapes", "Pineapple", "Banana", "Orange",
    "Lemon", "Lime", "Plum", "Apricot", "Raspberry", "Blackberry",
    "Kiwi", "Pomegranate", "Cantaloupe", "Papaya", "Cranberry", "Fig",

    // Flowers
    "Rose", "Tulip", "Sunflower", "Daisy", "Lily", "Orchid",
    "Marigold", "Daffodil", "Lavender", "Peony", "Chrysanthemum", "Hibiscus",
    "Magnolia", "Gardenia", "Begonia", "Petunia", "Camellia", "Iris",
    "Hydrangea", "Fuchsia", "Violet", "Pansy", "Carnation", "Snapdragon",

    // More Vegetables
    "Arugula", "Bok Choy", "Swiss Chard", "Mustard Greens", "Watercress", "Rutabaga",
    "Kohlrabi", "Endive", "Radicchio", "Chayote", "Fennel", "Ginger",

    // More Fruits
    "Guava", "Lychee", "Dragon Fruit", "Starfruit", "Jackfruit", "Mulberry",
    "Tangerine", "Clementine", "Nectarine", "Passion Fruit", "Persimmon", "Quince",

    // More Flowers
    "Aster", "Calendula", "Cosmos", "Snapdragon", "Foxglove", "Bluebell",
    "Petunia", "Sweet Pea", "Morning Glory", "Zinnia", "Gladiolus", "Coneflower"
)