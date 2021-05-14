package com.example.jsw_mis_report_generator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.jsw_mis_report_generator.HomeScreen.HomeScreen
import com.example.jsw_mis_report_generator.outputDetails.ActualDetailsOutput
import com.example.jsw_mis_report_generator.outputDetails.misReportWebview
import com.example.jsw_mis_report_generator.outputDetails.plannedDetailsOutput
import com.example.jsw_mis_report_generator.usermenu.userMenuScreen
import kotlinx.android.synthetic.main.activity_actual_details_output.*
import kotlinx.android.synthetic.main.activity_menu_for_report_details.*
import kotlinx.android.synthetic.main.fragment_report.*

class menuForReportDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_for_report_details)

        supportActionBar?.hide()

        val actualproduction = findViewById<CardView>(R.id.cardviewactualproduction)
        val plannedproduction = findViewById<CardView>(R.id.cardviewplannedproduction)
        val mis = findViewById<CardView>(R.id.cardviewmis)


        actualproduction.setOnClickListener{
            val intent = Intent(applicationContext, ActualDetailsOutput::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        plannedproduction.setOnClickListener{
            val intent = Intent(applicationContext, plannedDetailsOutput::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        mis.setOnClickListener{
            val intent = Intent(applicationContext, misReportWebview::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            Toast.makeText(this,"Please wait till it loads....",Toast.LENGTH_SHORT).show()
        }
        menuReportTohome.setOnClickListener{
            val intent = Intent(applicationContext, HomeScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }

        menuReportToUsermenu.setOnClickListener{
            val intent = Intent(applicationContext, userMenuScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
}