package com.example.jsw_mis_report_generator.Forms.productionDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jsw_mis_report_generator.LoginManagement.Signup.SignupFragment
import com.example.jsw_mis_report_generator.R

class actualDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actual_details)

        supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container, actualDetailsFragment.newInstance()
        ).commit()
    }
}