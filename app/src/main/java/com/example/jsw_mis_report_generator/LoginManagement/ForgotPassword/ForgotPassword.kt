package com.example.jsw_mis_report_generator.LoginManagement.ForgotPassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jsw_mis_report_generator.LoginManagement.Signup.SignupFragment
import com.example.jsw_mis_report_generator.R

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container, ForgotPasswordFragment.newInstance()
        ).commit()
    }
}