package com.example.gsonfilereadwrite

import com.google.gson.annotations.SerializedName
class Employees {
    @SerializedName("employees")
    lateinit var employees:ArrayList<Employee>
}
