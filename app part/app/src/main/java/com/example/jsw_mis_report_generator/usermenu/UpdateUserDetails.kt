package com.example.jsw_mis_report_generator.usermenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jsw_mis_report_generator.LoginManagement.Signup.SignupFragment
import com.example.jsw_mis_report_generator.R

class UpdateUserDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_user_details)

        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container, updateUserDetailsFragment.newInstance()
        ).commit()
    }
}