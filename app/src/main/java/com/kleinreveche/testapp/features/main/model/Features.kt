package com.kleinreveche.testapp.features.main.model

data class Features(
    val id: Int,
    val name: String,
    val artifact: String,
    val date: String
)

private const val basePackage = "com.kleinreveche.testapp"

val DiceRollerFeature = Features(
    id = 1,
    name = "Dice Roller",
    artifact = "$basePackage.features.dice",
    date = "08/28/2022"
)

val DessertClickerFeature = Features(
    id = 2,
    name = "Dessert Clicker",
    artifact = "$basePackage.features.dessert",
    date = "08/28/2022"
)

val CupcakeFeature = Features(
    id = 3,
    name = "Cupcake Shop",
    artifact = "$basePackage.features.cupcake",
    date = "08/30/2022"
)

val CafeteriaFeature = Features(
    id = 4,
    name = "Cafeteria",
    artifact = "$basePackage.features.cafeteria",
    date = "08/30/2022"
)

val NotesFeature = Features(
    id = 5,
    name = "Notes",
    artifact = "$basePackage.features.notes",
    date = "08/30/2022"
)

val LemonadeFeature = Features(
    id = 6,
    name = "Lemonade",
    artifact = "$basePackage.features.lemonade",
    date = "09/01/2022"
)

val UnscrambleFeature = Features(
    id = 7,
    name = "Unscramble",
    artifact = "$basePackage.features.unscramble",
    date = "09/02/2022"
)

val FeatureList = listOf(
    DiceRollerFeature,
    DessertClickerFeature,
    CupcakeFeature,
    CafeteriaFeature,
    NotesFeature,
    LemonadeFeature,
    UnscrambleFeature
    )

