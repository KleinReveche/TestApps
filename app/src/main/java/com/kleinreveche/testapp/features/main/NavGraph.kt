package com.kleinreveche.testapp.features.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kleinreveche.testapp.features.main.ui.feature_lists.age_calculator.AgeCalculatorListNavGraph
import com.kleinreveche.testapp.features.main.ui.feature_lists.age_calculator.AgeCalculatorsFeatureListRoute
import com.kleinreveche.testapp.features.main.ui.feature_lists.age_calculator.AgeCalculatorFeatureRoute
import com.kleinreveche.testapp.features.cupcake.CupcakeApp
import com.kleinreveche.testapp.features.cupcake.CupcakeFeatureRoute
import com.kleinreveche.testapp.features.dessert.DessertClickerApp
import com.kleinreveche.testapp.features.dessert.DessertClickerFeatureRoute
import com.kleinreveche.testapp.features.dessert.data.Datasource
import com.kleinreveche.testapp.features.dice.DiceRollerApp
import com.kleinreveche.testapp.features.dice.DiceRollerFeatureRoute
import com.kleinreveche.testapp.features.cafeteria.CafeteriaApp
import com.kleinreveche.testapp.features.cafeteria.CafeteriaFeatureRoute
import com.kleinreveche.testapp.features.main.model.*
import com.kleinreveche.testapp.features.main.ui.Feature
import com.kleinreveche.testapp.features.notes.NotesApp
import com.kleinreveche.testapp.features.notes.NotesFeatureRoute
import com.kleinreveche.testapp.features.lemonade.LemonApp
import com.kleinreveche.testapp.features.lemonade.LemonadeFeatureRoute
import com.kleinreveche.testapp.features.unscramble.ui.UnscrambleGameScreen
import com.kleinreveche.testapp.features.unscramble.ui.UnscrambleFeatureRoute

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = FeatureRoute
    ) {
        composable(FeatureRoute) {
            Feature(
                featureLists = FeatureListsOf,
                onFeatureListClick = { featureList ->
                    when (featureList) {
                        AgeCalculatorsFeatureList -> navController.navigate(AgeCalculatorsFeatureListRoute)
                    }
                },
                features = FeatureList,
                onFeatureClick = { feature ->
                    when (feature) {
                        DiceRollerFeature -> navController.navigate(DiceRollerFeatureRoute)
                        DessertClickerFeature -> navController.navigate(DessertClickerFeatureRoute)
                        CupcakeFeature -> navController.navigate(CupcakeFeatureRoute)
                        CafeteriaFeature -> navController.navigate(CafeteriaFeatureRoute)
                        NotesFeature -> navController.navigate(NotesFeatureRoute)
                        LemonadeFeature -> navController.navigate(LemonadeFeatureRoute)
                        UnscrambleFeature -> navController.navigate(UnscrambleFeatureRoute)
                        else -> throw IllegalArgumentException("Unknown Feature")
                    }
                }
            )

        }
        composable(AgeCalculatorFeatureRoute) { AgeCalculatorListNavGraph() }
        composable(DiceRollerFeatureRoute) { DiceRollerApp() }
        composable(DessertClickerFeatureRoute) { DessertClickerApp(desserts = Datasource.dessertList) }
        composable(CupcakeFeatureRoute) { CupcakeApp() }
        composable(CafeteriaFeatureRoute) { CafeteriaApp() }
        composable(NotesFeatureRoute) { NotesApp() }
        composable(LemonadeFeatureRoute) { LemonApp() }
        composable(UnscrambleFeatureRoute) { UnscrambleGameScreen() }
    }
}

private const val FeatureRoute = "feature"
