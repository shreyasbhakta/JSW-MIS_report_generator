package com.example.jsw_mis_report_generator

import android.content.Context
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.firestore.auth.User

fun Context.showToast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this,text,duration).show()
}

fun DataSnapshot.asUser(): Users? =
        getValue(Users::class.java)?.copy(uid = key)