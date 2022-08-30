package com.kleinreveche.testapps.features.main.model

data class Features(
    val id: Int,
    val name: String,
    val artifact: String
)

private const val basePackage = "com.kleinreveche.testapps"

private const val AgeCalculatorName = "Age Calculator (Material)"
private const val AgeCalculatorArtifact = "$basePackage.features.age_calculator"

val AgeCalculatorFeature = Features(
    id = 1,
    name = AgeCalculatorName,
    artifact = AgeCalculatorArtifact
)

private const val AgeCalculatorLegacyName = "Age Calculator Legacy"
private const val AgeCalculatorLegacyArtifact = "$basePackage.features.age_calculator"

val AgeCalculatorLegacyFeature = Features(
    id = 2,
    name = AgeCalculatorLegacyName,
    artifact = AgeCalculatorLegacyArtifact
)

private const val DiceRollerName = "Dice Roller"
private const val DiceRollerArtifact = "$basePackage.features.dice"

val DiceRollerFeature = Features(
    id = 3,
    name = DiceRollerName,
    artifact = DiceRollerArtifact
)

private const val DessertClickerName = "Dessert Clicker"
private const val DessertClickerArtifact = "$basePackage.features.dessert"

val DessertClickerFeature = Features(
    id = 4,
    name = DessertClickerName,
    artifact = DessertClickerArtifact
)

private const val CupcakeName = "Cupcake Shop"
private const val CupcakeArtifact = "$basePackage.features.cupcake"

val CupcakeFeature = Features(
    id = 5,
    name = CupcakeName,
    artifact = CupcakeArtifact
)

private const val LunchTrayName = "Cafeteria"
private const val LunchTrayArtifact = "$basePackage.features.lunch_tray"

val LunchTrayFeature = Features(
    id = 6,
    name = LunchTrayName,
    artifact = LunchTrayArtifact
)

private const val NotesName = "Notes"
private const val NotesArtifact = "$basePackage.features.notes"

val NotesFeature = Features(
    id = 7,
    name = NotesName,
    artifact = NotesArtifact
)

val FeatureList = listOf(
    AgeCalculatorFeature,
    AgeCalculatorLegacyFeature,
    DiceRollerFeature,
    DessertClickerFeature,
    CupcakeFeature,
    LunchTrayFeature,
    NotesFeature
    )

