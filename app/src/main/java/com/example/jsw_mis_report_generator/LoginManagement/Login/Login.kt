package com.example.jsw_mis_report_generator.LoginManagement.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.jsw_mis_report_generator.MainActivity
import com.example.jsw_mis_report_generator.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


// ...
// Initialize Firebase Auth

    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        auth = Firebase.auth
        val currentUser = auth.currentUser
        if(currentUser != null){
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
        else{
            supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,LoginFragment.newInstance()
            ).commit()
        }
    }
}