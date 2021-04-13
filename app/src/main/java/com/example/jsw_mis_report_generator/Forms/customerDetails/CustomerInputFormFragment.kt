package com.example.jsw_mis_report_generator.Forms.customerDetails

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
import com.example.jsw_mis_report_generator.models.CustomerDetails
import com.example.jsw_mis_report_generator.usermenu.userMenuScreen
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_customer_input_form.*


class CustomerInputFormFragment : Fragment() {

    private lateinit var viewmodel: CustomerInputViewmodel
    companion object {
        fun newInstance() = CustomerInputFormFragment()
    }

    private lateinit var refcustomerdetails: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_input_form, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewmodel= ViewModelProviders.of(this).get(CustomerInputViewmodel::class.java)

        gotoHomeFromcustomerDetails.setOnClickListener {
            val intent=Intent(requireContext(), HomeScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            activity?.finish()
        }

        cusDetailstoUserMenu.setOnClickListener {
            val intent=Intent(requireContext(), userMenuScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            activity?.finish()
        }

        SubmitCustomerInputForm.setOnClickListener {
            val orderno = ordernoc.text.toString()
            val cusEnum = cen.text.toString()
            val cusName = cname.text.toString()
            val proForm = pform.text.toString()
            val steelGrade = steelgrade.text.toString()
            val proThickness = pthick.text.toString()
            val proWidth = pwidth.text.toString()
            val prolength = plength.text.toString()
            val orderquan = oquantity.text.toString()
            val ordershipdate = oshipment.text.toString()


            if (orderno.isEmpty()) {
                ordernoc.error = "Order no. empty"
                ordernoc.requestFocus()
            } else if (cusEnum.isEmpty()) {
                cen.error = "Customer No. Empty"
                cen.requestFocus()
            } else if (cusName.isEmpty()) {
                cname.error = "Customer Name Empty"
                cname.requestFocus()
            } else if (proForm.isEmpty()) {
                pform.error = "Product Form Empty"
                pform.requestFocus()
            } else if (steelGrade.isEmpty()) {
                steelgrade.error = "Steel Grade Empty"
                steelgrade.requestFocus()
            } else if (proThickness.isEmpty()) {
                pthick.error = "Product Thickness Empty"
                pthick.requestFocus()
            } else if (proWidth.isEmpty()) {
                pwidth.error = "Product width empty"
                pwidth.requestFocus()
            } else if (prolength.isEmpty()) {
                plength.error = "Product Length Empty"
                plength.requestFocus()
            } else if (orderquan.isEmpty()) {
                oquantity.error = "Order quantity empty"
                oquantity.requestFocus()
            } else if (ordershipdate.isEmpty()) {
                oshipment.error = "Order Shipment Date Empty"
                oshipment.requestFocus()
            }else{
                refcustomerdetails = FirebaseDatabase.getInstance().getReference("Customer Details")

                val cusDetails= CustomerDetails(orderno,cusEnum,cusName,proForm,steelGrade,proThickness, proWidth, prolength, orderquan, ordershipdate)

                // val customerDetailsHashMap=HashMap<String,Any>()

                /*customerDetailsHashMap["orderno"]=ordernoc
                customerDetailsHashMap["cusEnum"]=cusEnum
                customerDetailsHashMap["cusName"]=cusName
                customerDetailsHashMap["proForm"]=proForm
                customerDetailsHashMap["SteelGrade"]=steelGrade
                customerDetailsHashMap["proThickness"]=proThickness
                customerDetailsHashMap["proWidth"]=proWidth
                customerDetailsHashMap["prolength"]=prolength
                customerDetailsHashMap["orderquan"]=orderquan
                customerDetailsHashMap["ordershipdate"]=ordershipdate*/

                refcustomerdetails.child(orderno).setValue(cusDetails)
                    .addOnCompleteListener { task->
                        Toast.makeText(context,"Customer datails filled successfully",
                            Toast.LENGTH_LONG).show()
                        val intent= Intent(requireContext(),CustomerInputForm::class.java)
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