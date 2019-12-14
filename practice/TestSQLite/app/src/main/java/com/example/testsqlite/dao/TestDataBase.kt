package com.example.testsqlite.dao

import android.content.Context
import com.example.testsqlite.dao.DBHelper
import com.example.testsqlite.dao.SQLController
import java.security.AccessControlContext

class TestDataBase (){

    fun test_searchWord(sqlController:SQLController){
        println("\n*** test_searchWord ---------------------------")
        var cursor =sqlController.searchWord("apple")

        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                val id = Integer.parseInt(cursor.getString(0))
                val wordstr = cursor.getString(1)
                val wordexplain =cursor.getString(2)
                val wordexample =cursor.getString(3)
                println("\nid:${id} word:${wordstr} explain:${wordexplain} example:${wordexample}")
                cursor.moveToNext()
            }
            cursor.close()
        }
    }
    fun test_addToFavorite(sqlController:SQLController){
        println("\n*** test_addToFavorite ---------------------------")

        sqlController.addToFavorite("a","undefine")
        sqlController.addToFavorite("pear","undefine")
    }
    fun test_initializeFavoriteMemorize(sqlController:SQLController){
        println("\n*** test_initializeFavoriteMemorize ---------------------------")
        sqlController.initializeFavoriteMemorize("undefine")
    }
    fun test_getFavoriteFromMemorize(sqlController:SQLController){
        println("\n*** test_getFavoriteFromMemorize ---------------------------")
        val cursor = sqlController.getFavoriteFromMemorize()
        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                val id = Integer.parseInt(cursor.getString(0))
                val wordstr = cursor.getString(1)
                val wordexplain =cursor.getString(2)
                val wordexample =cursor.getString(3)
                println("\nid:${id} word:${wordstr} explain:${wordexplain} example:${wordexample}")
                cursor.moveToNext()
            }
            cursor.close()
        }
    }

    fun test_removeFromMemorize(sqlController:SQLController){
        println("\n*** test_removeFromMemorize ---------------------------")
        sqlController.removeFromMemorize("a")
    }

    fun test_displayFavoriteList(sqlController:SQLController){
        println("\n*** test_displayFavoriteList ---------------------------")
        var cursor =sqlController.displayFavoriteList("undefine")
        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                val id = Integer.parseInt(cursor.getString(0))
                val wordstr = cursor.getString(1)
                val wordexplain =cursor.getString(2)
                val wordexample =cursor.getString(3)
                println("\nid:${id} word:${wordstr} explain:${wordexplain} example:${wordexample}")
                cursor.moveToNext()
            }
            cursor.close()
        }
    }

}