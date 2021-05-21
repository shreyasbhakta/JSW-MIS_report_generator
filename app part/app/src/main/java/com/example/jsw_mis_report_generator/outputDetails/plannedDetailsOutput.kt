package com.example.jsw_mis_report_generator.outputDetails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jsw_mis_report_generator.HomeScreen.HomeScreen
import com.example.jsw_mis_report_generator.databinding.ActivityActualDetailsOutputBinding.inflate
import com.example.jsw_mis_report_generator.databinding.ActivityActualDetailsOutputBinding
import com.example.jsw_mis_report_generator.databinding.ActivityCustomerDetailsOutputBinding
import com.example.jsw_mis_report_generator.databinding.ActivityPlannedDetailsOutputBinding
import com.example.jsw_mis_report_generator.usermenu.userMenuScreen
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_actual_details_output.*
import kotlinx.android.synthetic.main.activity_planned_details_output.*

class plannedDetailsOutput : AppCompatActivity() {
    private lateinit var binding : ActivityPlannedDetailsOutputBinding
    private lateinit var database : DatabaseReference




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlannedDetailsOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.hide()

        binding.SubmitBtn.setOnClickListener {

            val orderNum: String = binding.cusordernoc.text.toString()

            if (orderNum.isNotEmpty()) {

                readData(orderNum)

            } else {

                Toast.makeText(this, "PLease enter the Order Number", Toast.LENGTH_SHORT).show()

            }
        }
            binding.pdetailsOutputTohome.setOnClickListener{
                val intent = Intent(applicationContext, HomeScreen::class.java)
                startActivity(intent)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()
            }

            /* pdetailsOutputTouser.setOnClickListener{
                 val intent = Intent(applicationContext, userMenuScreen::class.java)
                 startActivity(intent)
                 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                 startActivity(intent)
             }
     */



    }

    private fun readData(orderNum: String) {

        database = FirebaseDatabase.getInstance().getReference("Planned Details")
        database.child(orderNum).get().addOnSuccessListener {

            if (it.exists()){

                val plandate = it.child("plandate").value
                val ordernum = it.child("ordernum").value
                val productionunit = it.child("productionunit").value
                val grade = it.child("grade").value
                val noofheats = it.child("noofheats").value
                val tonnage = it.child("tonnage").value
                val remarks = it.child("remarks").value

                Toast.makeText(this,"Successfully Read", Toast.LENGTH_SHORT).show()
                binding.cusordernoc.text.clear()
                binding.plandate.text = plandate.toString()
                binding.ordernum.text = ordernum.toString()
                binding.productionunit.text = productionunit.toString()
                binding.grade.text = grade.toString()
                binding.noofheats.text = noofheats.toString()
                binding.tonnage.text = tonnage.toString()
                binding.remarks.text = remarks.toString()


            }else{

                Toast.makeText(this,"Order Doesn't Exist", Toast.LENGTH_SHORT).show()


            }

        }.addOnFailureListener{

            Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()


        }


    }
}