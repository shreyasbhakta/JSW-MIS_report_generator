package com.example.jsw_mis_report_generator.Forms.plannedDetails

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.jsw_mis_report_generator.Forms.customerDetails.CustomerInputForm
import com.example.jsw_mis_report_generator.Forms.customerDetails.CustomerInputViewmodel
import com.example.jsw_mis_report_generator.Forms.productionDetails.actualDetailsFragment
import com.example.jsw_mis_report_generator.HomeScreen.HomeScreen
import com.example.jsw_mis_report_generator.LoginManagement.Login.Login
import com.example.jsw_mis_report_generator.R
import com.example.jsw_mis_report_generator.models.PlannedDetailsData
import com.example.jsw_mis_report_generator.userMenuScreen
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.gotoHomeFromplanned
import kotlinx.android.synthetic.main.fragment_home.plannedDetailstoUserMenu
import kotlinx.android.synthetic.main.fragment_planned_details.*


class plannedDetailsFragment : Fragment() {
    companion object {
        fun newInstance() = plannedDetailsFragment()
    }

    private lateinit var viewmodel: plannedDetailesViewmodel
    private lateinit var refplanneddetails: DatabaseReference

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_planned_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewmodel= ViewModelProviders.of(this).get(plannedDetailesViewmodel::class.java)


        plannedDetailstoUserMenu.setOnClickListener {
            val intent= Intent(requireContext(), userMenuScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            activity?.finish()
        }

        gotoHomeFromplanned.setOnClickListener {
            val intent=Intent(requireContext(),HomeScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            activity?.finish()
        }


        submitPlannedDetails.setOnClickListener {
            val planneddate = plandate.text.toString()
            val orNum = ordernum.text.toString()
            val prodUnit = productionunit.text.toString()
            val Grade = grade.text.toString()
            val NoofHeats = noofheats.text.toString()
            val ton = tonnage.text.toString()
            val remark = remarks.text.toString()

            if(planneddate.isEmpty()){
                plandate.error="Enter the date"
                plandate.requestFocus()
            }
            else if(orNum.isEmpty()){
                ordernum.error="Enter order number"
                ordernum.requestFocus()
            }
            else if (prodUnit.isEmpty()){
                productionunit.error="Enter Production Unit"
                productionunit.requestFocus()
            }
            else if (Grade.isEmpty()){
                grade.error="Enter Grade"
                grade.requestFocus()
            }
            else if (NoofHeats.isEmpty()){
                noofheats.error="Enter number of heats"
                noofheats.requestFocus()
            }
            else if (ton.isEmpty()){
                tonnage.error="Enter Tonnage"
                tonnage.requestFocus()
            }
            else if (remark.isEmpty()){
                remarks.error="Enter remarks"
                remarks.requestFocus()
            }
            else{
                refplanneddetails = FirebaseDatabase.getInstance().getReference("Planned Details")

                val planDetails=PlannedDetailsData(planneddate,orNum, prodUnit, Grade, NoofHeats,ton, remark)


                refplanneddetails.child(orNum).setValue(planDetails)
                    .addOnCompleteListener { task->
                        Toast.makeText(context,"Planned details filled successfully",
                            Toast.LENGTH_LONG).show()
                        val intent= Intent(requireContext(), plannedDetails::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        startActivity(intent)
                    }
                    .addOnFailureListener { task->
                        Toast.makeText(context,"Some Error Occurred!!!", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }


}