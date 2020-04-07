package com.douglasborba.tasks.service.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.douglasborba.tasks.service.model.UserModel

@Dao
interface UserDAO {
    @Insert
    fun insert(user: UserModel) : Long

    @Update
    fun update(user: UserModel) : Int

    @Delete
    fun delete(user: UserModel)

}