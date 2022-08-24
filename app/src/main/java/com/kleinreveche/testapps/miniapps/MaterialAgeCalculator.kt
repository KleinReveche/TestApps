package com.kleinreveche.testapps.miniapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.CompositeDateValidator
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.MaterialDatePicker
import com.kleinreveche.testapps.R
import java.text.SimpleDateFormat
import java.util.*

class MaterialAgeCalculator : AppCompatActivity() {

    private var tvSelectedDate: TextView? = null
    private var tvSelectedDateInMinutes: TextView? = null
    private var tvSelectedDateInHours: TextView? = null
    private var tvSelectedDateInDays: TextView? = null

    private val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH)
    private val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
    private val currentDateInMinutes = currentDate?.time?.div(60000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age_calculator)

        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvSelectedDateInMinutes = findViewById(R.id.tvSelectedDateInMinutes)
        tvSelectedDateInHours = findViewById(R.id.tvSelectedDateInHours)
        tvSelectedDateInDays = findViewById(R.id.tvSelectedDateInDays)

        currentDate?.let {
            val defaultDateInMinutes = currentDateInMinutes?.minus(17723520)
            val defaultDateInHours = defaultDateInMinutes?.div(60)
            val defaultDateInDays = defaultDateInHours?.div(24)

            tvSelectedDateInMinutes?.text = defaultDateInMinutes.toString()
            tvSelectedDateInHours?.text = defaultDateInHours.toString()
            tvSelectedDateInDays?.text = defaultDateInDays.toString()
        }

        val btnBirthdatePicker: Button = findViewById(R.id.btnBirthdatePicker)
        btnBirthdatePicker.setOnClickListener {
            mBtnShowDatePicker()
        }
    }

    private fun mBtnShowDatePicker() {
        val calendar = Calendar.getInstance()
        val calendarConstraintBuilder = CalendarConstraints.Builder()
        val validators = ArrayList<CalendarConstraints.DateValidator>()
        validators.add(DateValidatorPointBackward.now())
        calendarConstraintBuilder.setValidator(CompositeDateValidator.allOf(validators))

        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select your Birthdate")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .setCalendarConstraints(calendarConstraintBuilder.setEnd(System.currentTimeMillis().minus(8640000)).build())
            .build()

        datePicker.addOnPositiveButtonClickListener {
            calendar.timeInMillis = it
            val selectedDate = datePicker.selection
            Toast.makeText(
                                    this,
                                    "Selected Birthdate is " + selectedDate.toString(),
                                    Toast.LENGTH_LONG
            ).show()
        }

        datePicker.show(supportFragmentManager, datePicker.tag)
    }

}