package com.kleinreveche.testapps.features.age_calculator.util

import android.app.Activity
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.kleinreveche.testapps.features.age_calculator.AgeCalculatorLegacyActivity
import com.kleinreveche.testapps.features.age_calculator.MaterialAgeCalculatorActivity

@Composable
fun AgeCalculatorComposable(){
    val context = LocalContext.current
    context.startActivity(Intent(context, MaterialAgeCalculatorActivity::class.java))
    val activity = (context as? Activity)
    activity?.finish()
}

@Composable
fun AgeCalculatorLegacyComposable(){
    val context = LocalContext.current
    context.startActivity(Intent(context, AgeCalculatorLegacyActivity::class.java))
    val activity = (context as? Activity)
    activity?.finish()
}
