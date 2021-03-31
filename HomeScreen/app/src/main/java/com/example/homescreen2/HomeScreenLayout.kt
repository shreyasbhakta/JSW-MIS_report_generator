package com.example.homescreen2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView

class HomeScreenLayout : Fragment(), View.OnClickListener{

    var card1: CardView? = null
    var card2: CardView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_screen_layout, container, false)

        card1 = view.findViewById(R.id.reportgeneration) as CardView
        card2 = view.findViewById(R.id.customerdetails) as CardView
        card1!!.setOnClickListener(this)
        card2!!.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View) {
        val i: Intent
        when (v?.id) {
            R.id.reportgeneration -> {

            }
            R.id.customerdetails -> {
                i = Intent(this, CustomerFragment::class.java)
                startActivity(i)
            }
        }
    }


}