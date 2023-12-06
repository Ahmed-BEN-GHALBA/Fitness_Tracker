package com.example.fitnesstracker

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabase(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "MyDatabase.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Create tables and insert initial data here
        db.execSQL("CREATE TABLE Users(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)")
        // Insert pre-existing users
        db.execSQL("INSERT INTO Users (username, password) VALUES ('ahmed', 'ahmed')")
        db.execSQL("INSERT INTO Users (username, password) VALUES ('user1', 'password1')")
        db.execSQL("INSERT INTO Users (username, password) VALUES ('user2', 'password2')")
        // Add more users as needed
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Handle upgrades (e.g., dropping and recreating tables)
        db.execSQL("DROP TABLE IF EXISTS Users")
        onCreate(db)
    }

    fun authenticateUser(username: String, password: String): Boolean {
        val readableDatabase = readableDatabase
        val columns = arrayOf("id")
        val selection = "username = ? AND password = ?"
        val selectionArgs = arrayOf(username, password)
        val cursor = readableDatabase.query("Users", columns, selection, selectionArgs, null, null, null)
        val count = cursor.count
        cursor.close()
        return count > 0
    }
    fun insertUser(username: String, password: String): Boolean {
        val wDB = this.writableDatabase
        val cv = ContentValues()
        cv.put("username", username)
        cv.put("password", password)
        val result = wDB.insert("Users", null, cv)
        return result != -1L
    }

    // Additional methods for database operations (e.g., insert, query) can be added here
}
