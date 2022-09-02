package com.kleinreveche.testapp.features.main.ui.feature_lists.age_calculator

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.kleinreveche.testapp.features.main.ui.FeatureTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgeCalculatorListScaffold(
    topBarTitle: String,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = { FeatureTopAppBar(title = topBarTitle) },
        content = content
    )

}