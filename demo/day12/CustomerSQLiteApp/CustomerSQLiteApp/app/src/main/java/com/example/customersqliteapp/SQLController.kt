package com.example.customersqliteapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase

class SQLController// Constructor to set the context
    (c:Context) {
   lateinit var  dbhelper:DBHelper
   lateinit var ourcontext:Context
   lateinit var database:SQLiteDatabase
    init{
        ourcontext = c
    }
    fun open():SQLController {
        dbhelper = DBHelper(ourcontext)
        database = dbhelper.getWritableDatabase()
        return this
    }
    fun close() {
        dbhelper.close()
    }
    //Inserting Data into table
    fun insertData(name:String, mobile:String, email:String) {
        val cv = ContentValues()
        cv.put(DBHelper.NAME, name)
        cv.put(DBHelper.PHONE, mobile)
        cv.put(DBHelper.EMAIL, email)
        database.insert(DBHelper.TABLE_NAME, null, cv)
    }
    //Getting Cursor to read data from table
    fun readData():Cursor {
        val allColumns = arrayOf<String>(DBHelper.KEY_ROWID, DBHelper.NAME, DBHelper.PHONE, DBHelper.EMAIL)
        val c = database.query(DBHelper.TABLE_NAME, allColumns, null, null, null, null, null)
        c?.moveToFirst()
        return c
    }
    // Update the record in the Table
    fun updateData(memberID:Long, name:String, mobile:String, email:String):Int {
        val cvUpdate = ContentValues()
        cvUpdate.put(DBHelper.NAME, name)
        cvUpdate.put(DBHelper.PHONE, mobile)
        cvUpdate.put(DBHelper.EMAIL, email)
        val i = database.update(DBHelper.TABLE_NAME, cvUpdate,
            DBHelper.KEY_ROWID + " = " + memberID, null)
        return i
    }
    // Deleting record data from table by NAME
    fun deleteData(memberID:Long) {
        database.delete(DBHelper.TABLE_NAME, (DBHelper.KEY_ROWID + "="
                + memberID), null)
    }
}