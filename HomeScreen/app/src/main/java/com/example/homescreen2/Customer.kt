package com.example.homescreen2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



class Customer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)
    }

    public override fun onStart() {
        super.onStart()
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,CustomerFragment.newInstance()
        ).commit()
    }

}