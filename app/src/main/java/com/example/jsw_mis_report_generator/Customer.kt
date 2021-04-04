package com.example.jsw_mis_report_generator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Customer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)
        supportActionBar?.hide()
    }

    public override fun onStart() {
        super.onStart()
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,CustomerFragment.newInstance()
        ).commit()
    }

}