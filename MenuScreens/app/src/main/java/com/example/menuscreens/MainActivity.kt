package com.example.menuscreens

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()


        val google = findViewById<FloatingActionButton>(R.id.fab_google)
        val linkedin = findViewById<FloatingActionButton>(R.id.fab_linkedin)
        val twitter = findViewById<FloatingActionButton>(R.id.fab_twitter)

        google.setOnClickListener(View.OnClickListener { gotoUrl("https://www.jsw.in/") })
        linkedin.setOnClickListener(View.OnClickListener { gotoUrl("https://www.linkedin.com/company/jswsteel/") })
        twitter.setOnClickListener(View.OnClickListener { gotoUrl("https://twitter.com/jswsteel") })
    }

    private fun gotoUrl(s: String) {
        val uri = Uri.parse(s)
        startActivity(Intent(Intent.ACTION_VIEW, uri))

    }
}