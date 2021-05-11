package com.example.planneddetailsdisplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.planneddetailsdisplay.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var database : DatabaseReference




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.hide()

        binding.SubmitBtn.setOnClickListener{

            val orderNum : String = binding.cusordernoc.text.toString()

            if  (orderNum.isNotEmpty()){

                readData(orderNum)

            }else{

                Toast.makeText(this,"PLease enter the Order Number", Toast.LENGTH_SHORT).show()

            }

        }
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
