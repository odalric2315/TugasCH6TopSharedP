package com.percobaan.tugasch6topsharedp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [user::class],version = 1, exportSchema = false)
abstract class MyDatabase: RoomDatabase() {
    abstract fun userDao(): userDao

    companion object {
        @Volatile
        private var INSTANCE: MyDatabase? = null
        fun getInstance(context: Context): MyDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "TugasCH6_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}