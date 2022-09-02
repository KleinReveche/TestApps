package com.kleinreveche.testapp.features.main.ui.feature_lists.age_calculator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kleinreveche.testapp.features.age_calculator.AgeCalculatorLegacyFeatureRoute
import com.kleinreveche.testapp.features.age_calculator.model.AgeCalculatorFeature
import com.kleinreveche.testapp.features.age_calculator.model.AgeCalculatorLegacyFeature
import com.kleinreveche.testapp.features.age_calculator.model.AgeCalculatorList

@Composable
fun AgeCalculatorListNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AgeCalculatorsFeatureListRoute
    ) {
        composable(AgeCalculatorsFeatureListRoute) {
            AgeCalculatorListComponent(
                ageCalculatorFeatureList = AgeCalculatorList,
                onSpecificationClick = { feature ->
                    when (feature) {
                        AgeCalculatorFeature -> navController.navigate(AgeCalculatorFeatureRoute)
                        AgeCalculatorLegacyFeature -> navController.navigate(
                            AgeCalculatorLegacyFeatureRoute
                        )
                        else -> throw IllegalArgumentException("Unknown Feature")
                    }
                }
            )
        }
        composable(AgeCalculatorFeatureRoute) { AgeCalculatorComposable() }
        composable(AgeCalculatorLegacyFeatureRoute) { AgeCalculatorLegacyComposable() }
    }
}

const val AgeCalculatorsFeatureListRoute = "ageCalculatorList"