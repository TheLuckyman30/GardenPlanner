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