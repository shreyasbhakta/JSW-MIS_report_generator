package com.example.jsw_mis_report_generator.HomeScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.jsw_mis_report_generator.R

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        supportActionBar?.hide()
    }

    public override fun onStart() {
        super.onStart()
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container, HomeFragment.newInstance()
        ).commit()
    }
}