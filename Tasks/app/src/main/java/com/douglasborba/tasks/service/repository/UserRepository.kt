package com.douglasborba.tasks.service.repository

import android.content.Context
import com.douglasborba.tasks.service.model.UserModel

class UserRepository(context: Context){

    private val mDataBase = UserDataBase.getDatabase(context).userDAO()

    fun insert(user: UserModel): Boolean{
        return mDataBase.insert(user) > 0
    }
}