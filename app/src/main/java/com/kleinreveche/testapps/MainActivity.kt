package com.kleinreveche.testapps

import android.content.Intent
import android.widget.Button
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.kleinreveche.testapps.databinding.ActivityMainBinding
import com.kleinreveche.testapps.features.age_calculator.MaterialAgeCalculator
import com.kleinreveche.testapps.features.age_calculator.AgeCalculator
import com.kleinreveche.testapps.features.dice.DiceRoller
import com.kleinreveche.testapps.features.dessert.Dessert

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAnchorView(R.id.fab)
                    .setAction("Action", null).show()
        }
        
        val startAgeCalc: Button = findViewById(R.id.btnAgeCalc)
        startAgeCalc.setOnClickListener { Intent(this, MaterialAgeCalculator::class.java).also {startActivity(it)}}
        
        val startAgeCalcLegacy: Button = findViewById(R.id.btnAgeCalcLegacy)
                startAgeCalcLegacy.setOnClickListener { Intent(this, AgeCalculator::class.java).also {startActivity(it)} }
        
        val startDiceRoller: Button = findViewById(R.id.btnDiceRoller)
                startDiceRoller.setOnClickListener { Intent(this, DiceRoller::class.java).also {startActivity(it)} }
                        
        val startDessertClicker: Button = findViewById(R.id.btnDessertClicker)
                rollButton.setOnClickListener { Intent(this, DessertClicker::class.java).also {startActivity(it)} }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
    
    
    
}
