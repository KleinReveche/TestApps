package com.kleinreveche.testapp.features.cafeteria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kleinreveche.testapp.ui.theme.TestAppTheme

class CafeteriaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestAppTheme {
                CafeteriaApp()
            }
        }
    }

}

const val CafeteriaFeatureRoute = "Cafeteria"
