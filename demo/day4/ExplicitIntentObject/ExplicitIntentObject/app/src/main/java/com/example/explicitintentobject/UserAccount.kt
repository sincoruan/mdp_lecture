package com.example.explicitintentobject
import java.io.Serializable;
class UserAccount(var firstName: String?, var lastName: String?, var emailId: String?) :
    Serializable {
    override fun toString(): String {
        return "UserAccount(firstName=$firstName, lastName=$lastName, emailId=$emailId)"
    }
}
