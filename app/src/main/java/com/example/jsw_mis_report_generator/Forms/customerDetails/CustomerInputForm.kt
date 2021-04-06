package com.example.jsw_mis_report_generator.Forms.customerDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jsw_mis_report_generator.LoginManagement.Signup.SignupFragment
import com.example.jsw_mis_report_generator.R
import com.example.jsw_mis_report_generator.models.CustomerDetails
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_customer_input_form.*


class CustomerInputForm : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_input_form)

        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container, CustomerInputFormFragment.newInstance()
        ).commit()
    }
}