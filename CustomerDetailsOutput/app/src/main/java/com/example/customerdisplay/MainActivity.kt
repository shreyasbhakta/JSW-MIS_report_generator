package com.example.customerdisplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.customerdisplay.databinding.ActivityMainBinding
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

                Toast.makeText(this,"PLease enter the Order Number",Toast.LENGTH_SHORT).show()

            }

        }
    }

    private fun readData(orderNum: String) {

        database = FirebaseDatabase.getInstance().getReference("Customer Details")
        database.child(orderNum).get().addOnSuccessListener {

            if (it.exists()){

                val cusEnum = it.child("cusEnum").value
                val cusName = it.child("cusName").value
                val ordernoc = it.child("ordernoc").value
                val orderquan = it.child("orderquan").value
                val ordershipdate = it.child("ordershipdate").value
                val proForm = it.child("proForm").value
                val proThickness = it.child("proThickness").value
                val proWidth = it.child("proWidth").value
                val prolength = it.child("prolength").value
                val steelGrade = it.child("steelGrade").value

                Toast.makeText(this,"Successfully Read",Toast.LENGTH_SHORT).show()
                binding.cusordernoc.text.clear()
                binding.cusEnum.text = cusEnum.toString()
                binding.cusName.text = cusName.toString()
                binding.ordernoc.text = ordernoc.toString()
                binding.orderquan.text = orderquan.toString()
                binding.ordershipdate.text = ordershipdate.toString()
                binding.proForm.text = proForm.toString()
                binding.proThickness.text = proThickness.toString()
                binding.proWidth.text = proWidth.toString()
                binding.prolength.text = prolength.toString()
                binding.steelGrade.text = steelGrade.toString()


            }else{

                Toast.makeText(this,"Customer Doesn't Exist",Toast.LENGTH_SHORT).show()


            }

        }.addOnFailureListener{

            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


        }

    }
}