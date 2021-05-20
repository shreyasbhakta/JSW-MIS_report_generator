package com.example.jsw_mis_report_generator.Forms.productionDetails

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.jsw_mis_report_generator.HomeScreen.HomeScreen
import com.example.jsw_mis_report_generator.R
import com.example.jsw_mis_report_generator.models.ActualDetailsData
import com.example.jsw_mis_report_generator.usermenu.userMenuScreen
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_actual_details.*
import kotlinx.android.synthetic.main.fragment_actual_details.ordernum
import kotlinx.android.synthetic.main.fragment_actual_details.productionunit
import kotlinx.android.synthetic.main.fragment_actual_details.remarks
import kotlinx.android.synthetic.main.fragment_actual_details.tonnage

class actualDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = actualDetailsFragment()
    }

    private lateinit var viewmodel:actualDetalsViewmodel

    private lateinit var refactualdetails: DatabaseReference

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_actual_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewmodel= ViewModelProviders.of(this).get(actualDetalsViewmodel::class.java)


        gotoHomeFromActual.setOnClickListener {
            val intent= Intent(requireContext(), HomeScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            activity?.finish()
        }

        actualDetailstoUserMenu.setOnClickListener {
            val intent=Intent(requireContext(), userMenuScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            activity?.finish()
        }


        actualSubmit.setOnClickListener {

            val prodDate = productiondate.text.toString()
            val orNum = ordernum.text.toString()
            val prodUnit = productionunit.text.toString()
            val pgrade = plangrade.text.toString()
            val fgrade=finalgrade.text.toString()
            val heatNum = heatno.text.toString()
            val ton = tonnage.text.toString()
            val remark = remarks.text.toString()

            if(prodDate.isEmpty()){
                productiondate.error="Enter the date"
                productiondate.requestFocus()
            }
            else if(orNum.isEmpty()){
                ordernum.error="Enter order number"
                ordernum.requestFocus()
            }
            else if (prodUnit.isEmpty()){
                productionunit.error="Enter Production Unit"
                productionunit.requestFocus()
            }
            else if (fgrade.isEmpty()){
                finalgrade.error="Enter final grade"
                finalgrade.requestFocus()
            }
            else if (pgrade.isEmpty()){
                plangrade.error="Enter plan grade"
                plangrade.requestFocus()
            }
            else if (heatNum.isEmpty()){
                heatno.error="Enter number of heats"
                heatno.requestFocus()
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
                refactualdetails = FirebaseDatabase.getInstance().getReference("Actual Details")

                val ActualDetails= ActualDetailsData(prodDate,orNum, prodUnit,heatNum, pgrade,fgrade,ton, remark)


                refactualdetails.child(orNum).setValue(ActualDetails)
                        .addOnCompleteListener { task->
                            Toast.makeText(context,"Actual production details filled successfully",
                                    Toast.LENGTH_LONG).show()
                            val intent= Intent(requireContext(), actualDetails::class.java)
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