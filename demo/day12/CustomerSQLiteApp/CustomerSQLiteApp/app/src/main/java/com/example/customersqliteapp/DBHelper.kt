package com.example.customersqliteapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        // TABLE CREATION STATEMENT
        // Create table if not exists test(_id integer PRIMARY KEY AUTOINCREMENT,cname text,phone text,email text);
        val CREATE_TABLE = ("Create table if not exists " + TABLE_NAME +
                "(" + KEY_ROWID + " integer PRIMARY KEY AUTOINCREMENT," +
                NAME + " text," + PHONE + " text," + EMAIL + " text)")
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    companion object {
        // Database Information
        val DB_NAME = "Contacts"
        val DB_VERSION = 2

       // TABLE INFORMATTION
        val TABLE_NAME = "test"
        val NAME = "cname"
        val PHONE = "phone"
        val EMAIL = "email"
        val KEY_ROWID = "_id"

    }
}
