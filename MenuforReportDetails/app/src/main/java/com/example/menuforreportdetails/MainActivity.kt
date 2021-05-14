package com.example.menuforreportdetails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val actualproduction = findViewById<CardView>(R.id.cardviewactualproduction)
        val plannedproduction = findViewById<CardView>(R.id.cardviewplannedproduction)
        val mis = findViewById<CardView>(R.id.cardviewmis)

        actualproduction.setOnClickListener {
            val intent = Intent(this, ActualProduction::class.java)
            startActivity(intent)
        }

        plannedproduction.setOnClickListener {
            val intent = Intent(this, PlannedProduction::class.java)
            startActivity(intent)
        }

        mis.setOnClickListener {
            val intent = Intent(this, MISReport::class.java)
            startActivity(intent)
        }
    }
}