package com.example.jsw_mis_report_generator.outputDetails
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jsw_mis_report_generator.HomeScreen.HomeScreen
import com.example.jsw_mis_report_generator.databinding.ActivityCustomerDetailsOutputBinding
import com.example.jsw_mis_report_generator.usermenu.userMenuScreen
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_actual_details_output.*
import kotlinx.android.synthetic.main.activity_customer_details_output.*

class CustomerDetailsOutput : AppCompatActivity() {

    private lateinit var binding : ActivityCustomerDetailsOutputBinding
    private lateinit var database : DatabaseReference




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerDetailsOutputBinding.inflate(layoutInflater)
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
        binding.cusDetailsToHome.setOnClickListener{
            val intent = Intent(applicationContext, HomeScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }

        /*binding.cusDetailsToUsermenu.setOnClickListener{
            val intent = Intent(applicationContext, userMenuScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }*/
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