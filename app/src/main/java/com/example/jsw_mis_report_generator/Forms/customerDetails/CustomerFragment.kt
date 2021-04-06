package com.example.jsw_mis_report_generator.Forms.customerDetails

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.jsw_mis_report_generator.HomeScreen.HomeScreen
import com.example.jsw_mis_report_generator.R
import com.example.jsw_mis_report_generator.userMenuScreen
import kotlinx.android.synthetic.main.fragment_customer.*


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

        customerUpdateDetails.setOnClickListener {
            val intent = Intent(requireContext(), CustomerInputForm::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }

        /*customerViewDetails.setOnClickListener {
            val intent = Intent(requireContext(), ::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }*/

        cusFragmentToUsermenu.setOnClickListener {
            val intent = Intent(requireContext(), userMenuScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        gotoHomeFromcusFrag.setOnClickListener {
            val intent = Intent(requireContext(), HomeScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            activity?.finish()
        }
    }


}