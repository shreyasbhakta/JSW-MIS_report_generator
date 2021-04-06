package com.example.jsw_mis_report_generator.Forms.plannedDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jsw_mis_report_generator.LoginManagement.Signup.SignupFragment
import com.example.jsw_mis_report_generator.R

class plannedDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planned_details)

        supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container, plannedDetailsFragment.newInstance()
        ).commit()
    }
}