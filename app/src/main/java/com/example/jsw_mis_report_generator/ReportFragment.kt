package com.example.jsw_mis_report_generator

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.jsw_mis_report_generator.inputForms.inputFormsActivity
import com.example.jsw_mis_report_generator.HomeScreen.HomeScreenViewmodel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_report.*

class ReportFragment : Fragment() {

    companion object {
        fun newInstance() = ReportFragment()
    }

    private lateinit var viewmodel: ReportViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_report, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewmodel= ViewModelProviders.of(this).get(ReportViewmodel::class.java)




        reportUpdateDetails.setOnClickListener {
            val intent = Intent(requireContext(), inputFormsActivity::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }

        /*reportViewDetails.setOnClickListener {
            val intent = Intent(requireContext(), ::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }*/
    }



}