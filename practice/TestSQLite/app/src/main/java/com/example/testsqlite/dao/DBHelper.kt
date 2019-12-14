package com.example.testsqlite.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kotlin.math.log

class DBHelper(context: Context) : SQLiteOpenHelper (context, DB_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_TABLE = ("Create table if not exists " + TABLE_NAME +
                "(" + KEY_ROWID + " integer PRIMARY KEY AUTOINCREMENT," +
                NAME + " text," + PHONE + " text," + EMAIL + " text)")
        db?.execSQL(CREATE_TABLE)

        val CREATE_TABLE_VOCABULARY = """
        CREATE TABLE IF NOT EXISTS $TABLE_VOCABULARY
        (
            $WORD_ROWID integer PRIMARY KEY AUTOINCREMENT,
            $WORD_NAME text,
            $WORD_EXPLANATION text,
            $WORD_EXAMPLE text
        ) 
        """.trimIndent()
        System.out.println(CREATE_TABLE_VOCABULARY)
        db?.execSQL(CREATE_TABLE_VOCABULARY)

        val CREATE_TABLE_FAVORITE = """
        CREATE TABLE IF NOT EXISTS $TABLE_FAVORITE
        (
            $FAVORITE_ROWID integer PRIMARY KEY AUTOINCREMENT,
            $FAVORITE_WORDGROUP text,
            $FAVORITE_WORDNAME text,
            $FAVORITE_EXPLANATION text,
            $FAVORITE_EXAMPLE text
        )
        """.trimIndent()
        db?.execSQL(CREATE_TABLE_FAVORITE)

        val CREATE_TABLE_MEMORIZE = """
        CREATE TABLE IF NOT EXISTS $TABLE_MEMORIZE
        (
            $MEMORIZE_ROWID integer PRIMARY KEY AUTOINCREMENT,
            $MEMORIZE_WORDNAME text
        ) 
        """.trimIndent()
        db?.execSQL(CREATE_TABLE_MEMORIZE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        // Database Information
        val DB_NAME = "v6"
        val DB_VERSION = 2

        // TABLE INFORMATTION
        val TABLE_VOCABULARY = "VOCABULARY"
        val WORD_ROWID = "_id"
        val WORD_NAME="WORD_NAME"
        val WORD_EXPLANATION="WORD_EXPLANATION"
        val WORD_EXAMPLE="WORD_EXAMPLE"

        // TABLE INFORMATTION
        val TABLE_FAVORITE = "FAVORITE"
        val FAVORITE_ROWID = "_id"
        val FAVORITE_WORDGROUP="FAVORITE_WORDGROUP"
        val FAVORITE_WORDNAME="FAVORITE_WORDNAME"
        val FAVORITE_EXPLANATION="FAVORITE_EXPLANATION"
        val FAVORITE_EXAMPLE="FAVORITE_EXAMPLE"

        // TABLE INFORMATTION
        val TABLE_MEMORIZE = "MEMORIZE"
        val MEMORIZE_ROWID = "_id"
        val MEMORIZE_WORDNAME="MEMORIZE_WORDNAME"

        val TABLE_NAME = "test"
        val NAME = "cname"
        val PHONE = "phone"
        val EMAIL = "email"
        val KEY_ROWID = "_id"

    }
}