package com.example.jsw_mis_report_generator.LoginManagement.Signup

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.jsw_mis_report_generator.HomeScreen.HomeScreen
import com.example.jsw_mis_report_generator.LoginManagement.Login.Login
import com.example.jsw_mis_report_generator.MainActivity
import com.example.jsw_mis_report_generator.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_login.*

import kotlinx.android.synthetic.main.fragment_signup.*


class SignupFragment : Fragment() {

    companion object {
        fun newInstance() = SignupFragment()
    }

    private lateinit var viewModel: SignupViewmodel
    private lateinit var auth: FirebaseAuth
    private lateinit var refusers:DatabaseReference
    private  var firebaseUserId : String=""
    var emailPattern = "[a-zA-Z0-9._-]+@jsw+\\.+in"
    var TAG ="MainActivity"
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_signup,container,false)
    }

    @SuppressLint("ShowToast")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel= ViewModelProviders.of(this).get(SignupViewmodel::class.java)
        auth = FirebaseAuth.getInstance()
        SignupSubmit.setOnClickListener(){

            val name = sigupName.text.toString()
            val email =signupEmail.text.toString()
            val empcode =signupEmpcode.text.toString()
            val password =SignupPassword.text.toString()


            if (name.isEmpty()) {
                sigupName.error = "Name Empty"
                sigupName.requestFocus()
            }else if (email.isEmpty()){
                signupEmail.error = "Email Empty"
                signupEmail.requestFocus()
            }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                signupEmail.error = "Invalid Email"
                signupEmail.requestFocus()
            }else if (empcode.isEmpty()){
                signupEmpcode.error = "Empcode Empty"
                signupEmpcode.requestFocus()
            }
            else if (signupEmpcode.text.toString().length<7){
                signupEmpcode.error = "Invalid EmpCode"
                signupEmpcode.requestFocus()
            }else if (password.isEmpty()){
                SignupPassword.error = "Password Empty"
                SignupPassword.requestFocus()
            }else if (!signupEmail.text.toString().trim { it <= ' ' }.matches(emailPattern.toRegex())){
                signupEmail.error="Use JSW domain emailID"
                signupEmail.requestFocus()
            }
            else if (password.length<8){
                SignupPassword.error = "Password length should be >=8"
                SignupPassword.requestFocus()
            }
            else{

                auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(){ task->
                            if (task.isSuccessful) {
                                Log.d(TAG, "hello")
                                firebaseUserId = auth.currentUser!!.uid
                                refusers = FirebaseDatabase.getInstance().reference.child("Users").child(firebaseUserId)


                                val userHashmap = HashMap<String, Any>()

                                userHashmap["uid"] = firebaseUserId
                                userHashmap["Name"] = name
                                userHashmap["Email"] = email
                                userHashmap["Empcode"] = empcode
                                refusers.updateChildren(userHashmap)
                                        .addOnCompleteListener { task ->
                                            val intent = Intent(requireContext(), HomeScreen::class.java)
                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                            startActivity(intent)
                                            activity?.finish()
                                        }

                            } else {
                                Toast.makeText(context, "Some error occurred!!! (make sure your email id is not registered before)",Toast.LENGTH_SHORT).show()
                            }

                        }
                        .addOnFailureListener(){task->
                            Log.d(TAG, "$task")
                        }
            }
        }


        signuptologin.setOnClickListener {
            val intent = Intent(requireContext(), Login::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            activity?.finish()
        }
    }


}