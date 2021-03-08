package com.percobaan.tugasch6topsharedp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface userDao {
    @Insert
    fun registerUser(user: user) : Long

    @Query("SELECT * FROM user WHERE username = :username AND password = :password LIMIT 1")
    fun loginUser(username: String, password: String) : user?

}