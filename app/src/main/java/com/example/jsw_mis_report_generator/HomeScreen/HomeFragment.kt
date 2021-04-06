package com.example.jsw_mis_report_generator.HomeScreen

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.jsw_mis_report_generator.*
import com.example.jsw_mis_report_generator.Forms.customerDetails.Customer
import com.example.jsw_mis_report_generator.report.Report
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewmodel: HomeScreenViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewmodel= ViewModelProviders.of(this).get(HomeScreenViewmodel::class.java)




        homeToReportGeneration.setOnClickListener {
            val intent = Intent(requireContext(), Report::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }

        hometoUsermenu.setOnClickListener {
            val intent=Intent(requireContext(), userMenuScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            activity?.finish()
        }

       homeToAboutUs.setOnClickListener {
            val intent = Intent(requireContext(),AboutUs ::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }

        homeToCustomerdetails.setOnClickListener {
            val intent = Intent(requireContext(), Customer::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }
    }

}