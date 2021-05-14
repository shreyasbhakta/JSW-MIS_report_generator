package com.example.jsw_mis_report_generator.usermenu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.jsw_mis_report_generator.HomeScreen.HomeScreen
import com.example.jsw_mis_report_generator.LoginManagement.Signup.SignupFragment
import com.example.jsw_mis_report_generator.LoginManagement.Signup.SignupViewmodel
import com.example.jsw_mis_report_generator.R
import com.example.jsw_mis_report_generator.Users
import com.example.jsw_mis_report_generator.ValueListenerAdapter
import com.example.jsw_mis_report_generator.asUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.firestore.auth.User
import kotlinx.android.synthetic.main.fragment_signup.*
import kotlinx.android.synthetic.main.fragment_signup.sigupName
import kotlinx.android.synthetic.main.fragment_update_user_details.*
import java.util.jar.Attributes

class updateUserDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = updateUserDetailsFragment()
    }

    private lateinit var uUser: Users
    private lateinit var mUser: Users
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDatabase: DatabaseReference
    private lateinit var ureference:DatabaseReference


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_user_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mAuth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference
        ureference = FirebaseDatabase.getInstance().reference.child("Users").child(mAuth.currentUser!!.uid)


        fun currentUserReference(): DatabaseReference =
                mDatabase.child("Users").child(mAuth.currentUser!!.uid)

        currentUserReference().addListenerForSingleValueEvent(
                ValueListenerAdapter{
                    mUser = it.asUser()!!
                    updateNameEntry.setText(mUser.Name)
                    userNameEntry.setText(mUser.Email)
                    EmpCodeEntry.setText(mUser.Empcode)


                }
        )


        
        updateProfile.setOnClickListener {
            val name = updateNameEntry.text.toString()
            val empcode =EmpCodeEntry.text.toString()

            val uHashmap = HashMap<String, Any>()

            //uHashmap["uid"] = mAuth.currentUser!!.uid
            uHashmap["Name"] = name
            //uHashmap["Email"] = email
            uHashmap["Empcode"] = empcode
            ureference.updateChildren(uHashmap)
                    .addOnCompleteListener { task ->
                        Toast.makeText(context, "Updated Successfully", Toast.LENGTH_LONG).show()
                    }




               /* if (!name.equals(reference.child("Name"))){
                    reference.child(mAuth.currentUser!!.uid)
                            .child("Name").setValue(name)
                }
                if (!empcode.equals(reference.child("Empcode"))) {
                    reference.child(mAuth.currentUser!!.uid)
                            .child("Empcode").setValue(empcode)
                }*/

        }



        
    }


}


