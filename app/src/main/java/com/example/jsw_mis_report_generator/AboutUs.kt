package com.example.jsw_mis_report_generator

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.jsw_mis_report_generator.HomeScreen.HomeScreen
import com.example.jsw_mis_report_generator.outputDetails.misReportWebview
import com.example.jsw_mis_report_generator.usermenu.userMenuScreen
import kotlinx.android.synthetic.main.activity_about_us.*

class AboutUs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        about_menu.setOnClickListener {
            val intent = Intent(applicationContext, userMenuScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        about_home.setOnClickListener {
            val intent = Intent(applicationContext, misReportWebview::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        supportActionBar?.hide()

        val twitter = findViewById<ImageButton>(R.id.twitter)
        val facebook = findViewById<ImageButton>(R.id.facebook)
        val youtube = findViewById<ImageButton>(R.id.youtube)
        val linkedin = findViewById<ImageButton>(R.id.linkedin)


        twitter.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://twitter.com/thejswgroup")
            startActivity(intent)
        }

        facebook.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.facebook.com/JSWSteelOfficial")
            startActivity(intent)
        }

        youtube.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.youtube.com/channel/UCMauB1IhqTxH982vZmdJoVw")
            startActivity(intent)
        }

        linkedin.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.linkedin.com/company/jsw")
            startActivity(intent)
        }
    }
}