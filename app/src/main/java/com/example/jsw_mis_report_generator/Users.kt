package com.example.jsw_mis_report_generator

import com.google.firebase.database.Exclude

data class Users(@Exclude val uid: String? = "", val Name: String = "", val Email: String = "",
                 val Empcode: String = "")