package com.example.customersqliteapp

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import android.widget.TextView

class MyCursorAdaptor(context:Context, cursor:Cursor):CursorAdapter(context, cursor, 0) {
   override fun newView(context:Context, cursor:Cursor, parent:ViewGroup):View {
        return LayoutInflater.from(context).inflate(R.layout.view_member_entry, parent, false)
    }
    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    override fun bindView(view:View, context:Context, cursor:Cursor) {
        // Find fields to populate in inflated template
        val tvname = view.findViewById(R.id.cname) as TextView
        val tvmobile = view.findViewById(R.id.mobile) as TextView
        val tvemail = view.findViewById(R.id.email) as TextView
        /* Extract properties from cursor -
        Returns the zero-based index for the given column name,
        or throws IllegalArgumentException if the column doesn't exist.
         */
        val name = cursor.getString(cursor.getColumnIndexOrThrow("cname"))
        val phone = cursor.getString(cursor.getColumnIndexOrThrow("phone"))
        val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
        // Populate fields with extracted properties
        tvname.setText(name)
        tvmobile.setText(phone)
        tvemail.setText(email)
    }
}