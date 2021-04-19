package com.example.cvdmenuscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.Toast
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()


        val rpopup = findViewById<CardView>(R.id.rpopup)

        rpopup.setOnClickListener {
            val popup = PopupMenu(this,rpopup)
            popup.inflate(R.menu.rmenu)
            popup.setOnMenuItemClickListener {
                Toast.makeText(this, "Item : " + it.title,Toast.LENGTH_SHORT).show()
                true
            }
            popup.show()

        }
    }
}