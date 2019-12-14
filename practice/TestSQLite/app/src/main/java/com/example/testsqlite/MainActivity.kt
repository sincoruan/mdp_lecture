package com.example.testsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testsqlite.dao.SQLController
import com.example.testsqlite.dao.TestDataBase
import com.idescout.sql.SqlScoutServer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var sqlController:SQLController = SQLController(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //use live device connection
        SqlScoutServer.create(this, getPackageName());

        button.setOnClickListener{
            sqlController.open()
            val testDataBase = TestDataBase()

            testDataBase.test_searchWord(sqlController)

            testDataBase.test_addToFavorite(sqlController)

            testDataBase.test_initializeFavoriteMemorize(sqlController)

            testDataBase.test_getFavoriteFromMemorize(sqlController)

            testDataBase.test_removeFromMemorize(sqlController)

            testDataBase.test_displayFavoriteList(sqlController)

        }
    }
}
