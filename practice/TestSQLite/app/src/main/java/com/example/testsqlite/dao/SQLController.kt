package com.example.testsqlite.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.testsqlite.dao.DBHelper.Companion.MEMORIZE_WORDNAME
import com.example.testsqlite.dao.DBHelper.Companion.TABLE_MEMORIZE

class SQLController
    (c: Context){
    lateinit var  dbhelper:DBHelper
    lateinit var ourcontext:Context
    lateinit var database: SQLiteDatabase
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

    /**
     * func: search one word from the vocabulary
     * input:wordname
     * output:wordid,wordname,wordexplain,wordexample,favoritegroup
     * if favoritegroup is null, then this word is not a favorite word
     */
    fun searchWord(wordname:String):Cursor{

        val query = """
            select a.*,b.${DBHelper.FAVORITE_WORDGROUP} 
                from ${DBHelper.TABLE_VOCABULARY} a 
                left join ${DBHelper.TABLE_FAVORITE} b on a.${DBHelper.WORD_NAME} = b.${DBHelper.FAVORITE_WORDNAME}
             WHERE ${DBHelper.WORD_NAME} = '${wordname}'
        """.trimIndent()
        val cursor = database.rawQuery(query, null)
        return cursor
    }

    /**
     * func: add this word to your favorite
     * input:wordname,faviritegroup
     * output:null
     */
    fun addToFavorite(wordname:String,group:String) {
        val sql  = """
            insert into ${DBHelper.TABLE_FAVORITE}
            (
            ${DBHelper.FAVORITE_ROWID},
            ${DBHelper.FAVORITE_WORDNAME},
            ${DBHelper.FAVORITE_EXAMPLE},
            ${DBHelper.FAVORITE_EXPLANATION},
            ${DBHelper.FAVORITE_WORDGROUP}
            )
                select ${DBHelper.FAVORITE_ROWID},
                ${DBHelper.WORD_NAME},
                ${DBHelper.WORD_EXAMPLE},
                ${DBHelper.WORD_EXPLANATION},
                '${group}'
                from ${DBHelper.TABLE_VOCABULARY}
                    where ${DBHelper.WORD_NAME} = '${wordname}'
        """.trimIndent()
        database.execSQL(sql)
    }
    /**
     * func: remove word from your favorite
     * input:wordname
     * output:null
     */
    fun removeFromFavorite(wordname: String){
        val sql  = """
            delete from ${DBHelper.TABLE_FAVORITE} 
                where ${DBHelper.FAVORITE_WORDNAME} = '${wordname}'
        """.trimIndent()
    }

    /**
     * func: when user click memrize or study,we create a templist for memorize
     * input:faviritegroup
     * output:null
     */
    fun initializeFavoriteMemorize(group:String) {
        val deletesql = """delete from ${TABLE_MEMORIZE}"""

        database.execSQL(deletesql)

        val sql = """
            insert into ${TABLE_MEMORIZE} (${DBHelper.MEMORIZE_ROWID},${DBHelper.MEMORIZE_WORDNAME}) 
                select ${DBHelper.FAVORITE_ROWID},${DBHelper.FAVORITE_WORDNAME} from favorite  
                    WHERE ${DBHelper.FAVORITE_WORDGROUP} = '${group}'
        """.trimIndent()
        database.execSQL(sql)
    }

    /**
     * func: return the wordlist need to be memorized
     * input:faviritegroup
     * output:null
     */
    fun getFavoriteFromMemorize():Cursor{
        val query = """
            SELECT b.* FROM ${DBHelper.TABLE_MEMORIZE} a, ${DBHelper.TABLE_FAVORITE} b
            where a.${DBHelper.MEMORIZE_WORDNAME} = b.${DBHelper.FAVORITE_WORDNAME}
        """.trimIndent()
        val cursor = database.rawQuery(query, null)
        return cursor
    }

    /**
     * func: remove word from memwordlist when I click I have remember this word
     * input:wordname
     * output:null
     */
    fun removeFromMemorize(wordname:String){
        val sql = """
            delete from ${DBHelper.TABLE_MEMORIZE}
                where ${MEMORIZE_WORDNAME} = '${wordname}'
        """.trimIndent()
        database.execSQL(sql)
    }

    /**
     * func: display the favorite word list
     * input:favgroup
     * output:wordid,wordgroup,wordname,wordexplain,wordexample
     */
    fun displayFavoriteList(group:String): Cursor {
        val query = "SELECT * FROM ${DBHelper.TABLE_FAVORITE} WHERE ${DBHelper.FAVORITE_WORDGROUP} = '${group}'"
        val cursor = database.rawQuery(query, null)
        return cursor
    }
}