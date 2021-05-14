package com.example.jsw_mis_report_generator.usermenu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jsw_mis_report_generator.HomeScreen.HomeScreen
import com.example.jsw_mis_report_generator.LoginManagement.Login.Login
import com.example.jsw_mis_report_generator.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_user_menu_screen.*


class userMenuScreen : AppCompatActivity() {

    private lateinit var rauth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_menu_screen)
        supportActionBar?.hide()
        rauth = FirebaseAuth.getInstance()

        val google = findViewById<ImageView>(R.id.fab_google)
        val linkedin = findViewById<ImageView>(R.id.fab_linkedin)
        val twitter = findViewById<ImageView>(R.id.fab_twitter)

        val user = FirebaseAuth.getInstance().currentUser
        val username = user.email

        google.setOnClickListener{
            gotoUrl("https://www.jsw.in/")
        }
        linkedin.setOnClickListener {
            gotoUrl("https://www.linkedin.com/company/jswsteel/")
        }
        twitter.setOnClickListener{
            gotoUrl("https://twitter.com/jswsteel")
        }

        gotoHomeFromUsermenu.setOnClickListener{
            val intent = Intent(applicationContext, HomeScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        logout.setOnClickListener {
            Firebase.auth.signOut()
            val intent=Intent(applicationContext, Login::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }

        buttonEditProfile.setOnClickListener {
            val intent = Intent(applicationContext, UpdateUserDetails::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        buttonResetPassword.setOnClickListener {
            rauth.sendPasswordResetEmail(username)
                    .addOnCompleteListener() { task ->
                        if (task.isSuccessful()) {
                            Toast.makeText(applicationContext, "Passord reset link sent to the registered email.", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(applicationContext, "Fail to send reset password email!", Toast.LENGTH_SHORT).show()
                        }

                    }

        }
    }

    private fun gotoUrl(s: String) {
        val uri = Uri.parse(s)
        startActivity(Intent(Intent.ACTION_VIEW, uri))

    }
}


