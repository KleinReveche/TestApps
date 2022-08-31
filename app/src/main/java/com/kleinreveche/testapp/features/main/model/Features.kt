package com.kleinreveche.testapp.features.main.model

data class Features(
    val id: Int,
    val name: String,
    val artifact: String,
    val date: String
)

private const val basePackage = "com.kleinreveche.testapp"

private const val AgeCalculatorName = "Age Calculator (Material)"
private const val AgeCalculatorArtifact = "$basePackage.features.age_calculator"

val AgeCalculatorFeature = Features(
    id = 1,
    name = AgeCalculatorName,
    artifact = AgeCalculatorArtifact,
    date = "08/25/2022"
)

private const val AgeCalculatorLegacyName = "Age Calculator Legacy"
private const val AgeCalculatorLegacyArtifact = "$basePackage.features.age_calculator"

val AgeCalculatorLegacyFeature = Features(
    id = 2,
    name = AgeCalculatorLegacyName,
    artifact = AgeCalculatorLegacyArtifact,
    date = "08/19/2022"
)

private const val DiceRollerName = "Dice Roller"
private const val DiceRollerArtifact = "$basePackage.features.dice"

val DiceRollerFeature = Features(
    id = 3,
    name = DiceRollerName,
    artifact = DiceRollerArtifact,
    date = "08/28/2022"
)

private const val DessertClickerName = "Dessert Clicker"
private const val DessertClickerArtifact = "$basePackage.features.dessert"

val DessertClickerFeature = Features(
    id = 4,
    name = DessertClickerName,
    artifact = DessertClickerArtifact,
    date = "08/28/2022"
)

private const val CupcakeName = "Cupcake Shop"
private const val CupcakeArtifact = "$basePackage.features.cupcake"

val CupcakeFeature = Features(
    id = 5,
    name = CupcakeName,
    artifact = CupcakeArtifact,
    date = "08/30/2022"
)

private const val CafeteriaName = "Cafeteria"
private const val CafeteriaArtifact = "$basePackage.features.lunch_tray"

val CafeteriaFeature = Features(
    id = 6,
    name = CafeteriaName,
    artifact = CafeteriaArtifact,
    date = "08/30/2022"
)

private const val NotesName = "Notes"
private const val NotesArtifact = "$basePackage.features.notes"

val NotesFeature = Features(
    id = 7,
    name = NotesName,
    artifact = NotesArtifact,
    date = "08/30/2022"
)

val FeatureList = listOf(
    AgeCalculatorFeature,
    AgeCalculatorLegacyFeature,
    DiceRollerFeature,
    DessertClickerFeature,
    CupcakeFeature,
    CafeteriaFeature,
    NotesFeature
    )
