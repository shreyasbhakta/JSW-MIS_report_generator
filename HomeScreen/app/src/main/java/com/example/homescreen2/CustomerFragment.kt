package com.example.homescreen2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

class CustomerFragment : Fragment() {

    companion object {
        fun newInstance() = CustomerFragment()
    }

    private lateinit var viewmodel: CustomerViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewmodel= ViewModelProviders.of(this).get(CustomerViewmodel::class.java)
    }


}