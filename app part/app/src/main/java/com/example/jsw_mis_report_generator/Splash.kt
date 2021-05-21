package com.example.jsw_mis_report_generator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.jsw_mis_report_generator.Onboarding.Onboarding
import kotlinx.android.synthetic.main.activity_splash.*
import kotlin.random.Random


class Splash : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        handler = Handler()
        handler.postDelayed({

            val intent = Intent(this, Onboarding::class.java)
            startActivity(intent)
            finish()
        }, 3000)
        /*val view =inflater.inflate(R.layout.fragment_splash, container, false)*/

        val random = Random.nextInt(Constants.tagLineSize)
        splashrandomn!!.text= Constants.tagLines[random]


    }


}