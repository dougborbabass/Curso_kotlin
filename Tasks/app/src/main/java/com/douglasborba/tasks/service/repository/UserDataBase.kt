package com.douglasborba.tasks.service.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.douglasborba.tasks.service.model.UserModel

@Database(entities = [UserModel::class], version = 1)
abstract class UserDataBase : RoomDatabase() {

    abstract fun userDAO(): UserDAO

    companion object {

        //Singleton
        private lateinit var INSTANCE: UserDataBase

        fun getDatabase(context: Context): UserDataBase {
            synchronized(UserDataBase::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(context, UserDataBase::class.java, "UserDB")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}