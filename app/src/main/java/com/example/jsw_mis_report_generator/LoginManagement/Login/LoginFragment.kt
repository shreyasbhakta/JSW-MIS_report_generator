package com.example.jsw_mis_report_generator.LoginManagement.Login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.jsw_mis_report_generator.LoginManagement.ForgotPassword.ForgotPassword
import com.example.jsw_mis_report_generator.LoginManagement.Signup.Signup
import com.example.jsw_mis_report_generator.MainActivity
import com.example.jsw_mis_report_generator.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewmodel: LoginViewmodel
    private lateinit var mauth :FirebaseAuth
    var TAG="LOGIN"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewmodel = ViewModelProviders.of(this).get(LoginViewmodel::class.java)
        mauth= FirebaseAuth.getInstance()

        LoginSubmit.setOnClickListener(){
            val email = LoginEmail.text.toString()
            val password = loginPassword.text.toString()

            if(email.isEmpty()){
                LoginEmail.error="Username Empty"
                LoginEmail.requestFocus()
            }else if (password.isEmpty()){
                loginPassword.error="Password Empty"
                loginPassword.requestFocus()
            }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                LoginEmail.error="Invalid Username"
                LoginEmail.requestFocus()
            }
            else{
                mauth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener() { task ->
                        if (task.isSuccessful){
                            Log.d(TAG,"Login Successfull")
                            val intent = Intent(requireContext(),MainActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            startActivity(intent)
                            activity?.finish()
                            Toast.makeText(context,"Login Successful", Toast.LENGTH_SHORT).show()
                        }else{
                            Log.d(TAG, "Log in Failed")
                            Toast.makeText(context, "Email id Not Match", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

        logintosignup.setOnClickListener {
            val intent = Intent(requireContext(), Signup::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            activity?.finish()
        }

        forgotFromLogin.setOnClickListener {
            val intent = Intent(requireContext(), ForgotPassword::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }
    }


}