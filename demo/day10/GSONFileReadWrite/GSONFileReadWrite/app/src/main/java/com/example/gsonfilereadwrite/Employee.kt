package com.example.gsonfilereadwrite

import com.google.gson.annotations.SerializedName
/**
 * Created by rMohanraj on 4/16/2018.
 */
// POJO, or Plain Old Java Object, is a normal Java object class (that is, not a JavaBean, EntityBean etc.)
// This class helps to give the structure of Individual Employee
class Employee {
    /* @SerializedName annotation indicates this member should be serialized to JSON
   with the provided name value as its field name.
   It will be serialized with that key, if Serialized {"id":10}*/
    @SerializedName("idno")
    var id:Int = 0
    @SerializedName("name")
    lateinit var name:String
    @SerializedName("desig")
    lateinit var desig:String
    @SerializedName("dept")
    lateinit var dept:String

    override fun toString():String {
        return ("Employee{" +
                "id=" + id +
                ", name= " + name +
                ", desig= " + desig +
                ", dept= " + dept +
                "} ")
    }
}