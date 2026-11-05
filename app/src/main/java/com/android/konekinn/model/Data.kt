package com.android.konekinn.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id: Int,
    @SerializedName("employee_name")
    val employeeName: String,
    @SerializedName("employee_salary")
    val employeeSalary: String,
    @SerializedName("employee_age")
    val employeeAge: Int,
    @SerializedName("profile_image")
    val profileImage: String
)
