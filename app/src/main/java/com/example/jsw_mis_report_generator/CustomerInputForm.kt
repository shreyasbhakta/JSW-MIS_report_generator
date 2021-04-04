package com.example.jsw_mis_report_generator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jsw_mis_report_generator.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_customer_input_form.*
import kotlinx.android.synthetic.main.actualdetails.*
import kotlinx.android.synthetic.main.fragment_signup.*

private lateinit var refcustomerdetails: DatabaseReference
//private  var firebaseUserId : String=""
class CustomerInputForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_input_form)

        supportActionBar?.hide()

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
                refcustomerdetails=FirebaseDatabase.getInstance().getReference("Customer Details")

                val cusDetails=CustomerDetails(orderno,cusEnum,cusName,proForm,steelGrade,proThickness, proWidth, prolength, orderquan, ordershipdate)

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
                            Toast.makeText(applicationContext,"Customer datails filled successfully",Toast.LENGTH_LONG).show()
                            //val intent= Intent(this,CustomerInputForm::class.java)
                            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                           // startActivity(intent)
                        }
                        .addOnFailureListener { task->
                            Toast.makeText(this,"Some Error Occurred!!!",Toast.LENGTH_SHORT).show()
                        }

            }
        }
    }
}