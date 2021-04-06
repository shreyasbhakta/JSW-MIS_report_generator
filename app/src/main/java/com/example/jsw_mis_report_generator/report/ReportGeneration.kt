package com.example.jsw_mis_report_generator.report

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jsw_mis_report_generator.Forms.productionDetails.actualDetails
import com.example.jsw_mis_report_generator.Forms.plannedDetails.plannedDetails
import com.example.jsw_mis_report_generator.HomeScreen.HomeScreen
import com.example.jsw_mis_report_generator.R
import com.example.jsw_mis_report_generator.userMenuScreen
import kotlinx.android.synthetic.main.activity_report_generation.*

class ReportGeneration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_generation)


        actuaProd.setOnClickListener {
            val intent = Intent(this, actualDetails::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        plannedprod.setOnClickListener {
            val intent = Intent(this, plannedDetails::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        homebutHomescreen.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }

        reportGentoUserMenu.setOnClickListener {
            val intent = Intent(this, userMenuScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }


    }
}