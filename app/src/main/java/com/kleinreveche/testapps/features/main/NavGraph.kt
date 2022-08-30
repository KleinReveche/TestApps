package com.kleinreveche.testapps.features.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kleinreveche.testapps.features.age_calculator.AgeCalculatorFeatureRoute
import com.kleinreveche.testapps.features.age_calculator.AgeCalculatorLegacyFeatureRoute
import com.kleinreveche.testapps.features.age_calculator.util.AgeCalculatorComposable
import com.kleinreveche.testapps.features.age_calculator.util.AgeCalculatorLegacyComposable
import com.kleinreveche.testapps.features.cupcake.CupcakeApp
import com.kleinreveche.testapps.features.cupcake.CupcakeFeatureRoute
import com.kleinreveche.testapps.features.dessert.DessertClickerApp
import com.kleinreveche.testapps.features.dessert.DessertClickerFeatureRoute
import com.kleinreveche.testapps.features.dessert.data.Datasource
import com.kleinreveche.testapps.features.dice.DiceRollerApp
import com.kleinreveche.testapps.features.dice.DiceRollerFeatureRoute
import com.kleinreveche.testapps.features.lunch_tray.LunchTrayApp
import com.kleinreveche.testapps.features.lunch_tray.LunchTrayFeatureRoute
import com.kleinreveche.testapps.features.main.model.*
import com.kleinreveche.testapps.features.main.ui.Feature
import com.kleinreveche.testapps.features.notes.NotesActivity
import com.kleinreveche.testapps.features.notes.NotesApp
import com.kleinreveche.testapps.features.notes.NotesFeatureRoute

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = FeatureRoute
    ) {
        composable(FeatureRoute) {
            Feature(
                features = FeatureList,
                onSpecificationClick = { feature ->
                    when (feature) {
                        AgeCalculatorFeature -> navController.navigate(AgeCalculatorFeatureRoute)
                        AgeCalculatorLegacyFeature -> navController.navigate(AgeCalculatorLegacyFeatureRoute)
                        DiceRollerFeature -> navController.navigate(DiceRollerFeatureRoute)
                        DessertClickerFeature -> navController.navigate(DessertClickerFeatureRoute)
                        CupcakeFeature -> navController.navigate(CupcakeFeatureRoute)
                        LunchTrayFeature -> navController.navigate(LunchTrayFeatureRoute)
                        NotesFeature -> navController.navigate(NotesFeatureRoute)
                        else -> throw IllegalArgumentException("Unknown Feature")
                    }
                }
            )
        }
        composable(AgeCalculatorFeatureRoute) { AgeCalculatorComposable() }
        composable(AgeCalculatorLegacyFeatureRoute) { AgeCalculatorLegacyComposable() }
        composable(DiceRollerFeatureRoute) { DiceRollerApp() }
        composable(DessertClickerFeatureRoute) { DessertClickerApp(desserts = Datasource.dessertList) }
        composable(CupcakeFeatureRoute) { CupcakeApp() }
        composable(LunchTrayFeatureRoute) { LunchTrayApp() }
        composable(NotesFeatureRoute) { NotesApp() }
    }
}

private const val FeatureRoute = "feature"