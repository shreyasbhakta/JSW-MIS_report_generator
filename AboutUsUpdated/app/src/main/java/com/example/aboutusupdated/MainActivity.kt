package com.example.aboutusupdated

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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
