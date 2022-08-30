package com.kleinreveche.testapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.kleinreveche.testapps.features.main.NavGraph
import com.kleinreveche.testapps.ui.theme.TestAppsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            TestAppsTheme {
                // A surface container using the 'background' color from the theme
          
                    NavGraph()
               
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestAppsTheme {
        NavGraph()
    }
}