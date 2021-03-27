package com.example.jsw_mis_report_generator.LoginManagement.Signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jsw_mis_report_generator.LoginManagement.Login.LoginFragment
import com.example.jsw_mis_report_generator.R

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container, SignupFragment.newInstance()
        ).commit()
    }
}