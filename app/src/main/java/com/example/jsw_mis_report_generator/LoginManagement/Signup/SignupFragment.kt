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
import com.example.jsw_mis_report_generator.MainActivity
import com.example.jsw_mis_report_generator.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_signup.SignupPassword
import kotlinx.android.synthetic.main.activity_signup.SignupSubmit
import kotlinx.android.synthetic.main.activity_signup.signupEmail
import kotlinx.android.synthetic.main.activity_signup.signupEmpcode
import kotlinx.android.synthetic.main.activity_signup.sigupName
import kotlinx.android.synthetic.main.fragment_signup.*


class SignupFragment : Fragment() {

    companion object {
        fun newInstance() = SignupFragment()
    }

    private lateinit var viewModel: SignupViewmodel
    private lateinit var auth: FirebaseAuth
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
            }else if (password.isEmpty()){
                SignupPassword.error = "Password Empty"
                SignupPassword.requestFocus()
            }else{

                auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(){ task->
                            if (task.isSuccessful){
                                Log.d(TAG, "hello")
                                val intent = Intent(requireContext(),MainActivity::class.java)
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                startActivity(intent)
                                activity?.finish()
                            } else {
                                Toast.makeText(context, "Authentication Failed!!!",Toast.LENGTH_SHORT).show()
                            }
                        }
                        .addOnFailureListener(){task->
                            Log.d(TAG, "$task")
                        }
            }
        }
    }


}