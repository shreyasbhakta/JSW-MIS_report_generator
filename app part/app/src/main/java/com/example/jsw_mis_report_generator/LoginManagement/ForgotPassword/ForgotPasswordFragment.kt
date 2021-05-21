package com.example.jsw_mis_report_generator.LoginManagement.ForgotPassword

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.jsw_mis_report_generator.LoginManagement.Login.Login
import com.example.jsw_mis_report_generator.LoginManagement.Login.LoginFragment
import com.example.jsw_mis_report_generator.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_forgot_password.*
import kotlinx.android.synthetic.main.fragment_login.*


class ForgotPasswordFragment : Fragment() {
    companion object {
        fun newInstance() = ForgotPasswordFragment()
    }

    private lateinit var viewmodel: ForgotPasswordViewmodel
    private lateinit var fauth: FirebaseAuth
    var TAG = "LOGIN"

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_forgot_password, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewmodel = ViewModelProviders.of(this).get(ForgotPasswordViewmodel::class.java)
        fauth = FirebaseAuth.getInstance()

        ForgotSubmit.setOnClickListener() {
            val email = ForgotEmail.text.toString()

            if (email.isEmpty()) {
                ForgotEmail.error = "Username Empty"
                ForgotEmail.requestFocus()

            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                ForgotEmail.error = "Invalid Username"
                ForgotEmail.requestFocus()
            }else
            {
                fauth.sendPasswordResetEmail(email)
                        .addOnCompleteListener() {task ->

                                if (task.isSuccessful()) {
                                    Toast.makeText(context, "Check email to reset your password!(If your email id is registered ith us you will be able to reset...)", Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(context, "Fail to send reset password email!", Toast.LENGTH_SHORT).show()
                                }

                        }

            }
        }
        LoginfromForgot.setOnClickListener {
            val intent = Intent(requireContext(), Login::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            activity?.finish()

        }
    }
}

