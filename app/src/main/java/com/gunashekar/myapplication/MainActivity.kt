package com.gunashekar.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.Gravity
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        about_menu.setOnClickListener {
            val toast = Toast.makeText(this, "You clicked on menu", Toast.LENGTH_SHORT).show()
//            toast.setGravity(Gravity.TOP or Gravity.LEFT,0,0)
//            toast.show()
        }

        supportActionBar!!.hide()

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