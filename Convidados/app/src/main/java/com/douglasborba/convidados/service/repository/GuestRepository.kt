package com.douglasborba.convidados.service.repository

import android.content.ContentValues
import android.content.Context
import com.douglasborba.convidados.service.constants.DataBaseConstants
import com.douglasborba.convidados.service.model.GuestModel
import java.lang.Exception

class GuestRepository private constructor(context: Context) {

    private var mGuestDataBaseHelper: GuestDataBaseHelper = GuestDataBaseHelper(context)

    // Singleton
    companion object {

        private lateinit var repository: GuestRepository

        // somente o metodo pode dar uma instancia da classe
        fun getInstance(context: Context): GuestRepository {
            //se ainda nao foi inicializada, inicialize
            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun save(guest: GuestModel): Boolean {

        return try {
            val db = mGuestDataBaseHelper.writableDatabase

            val content = ContentValues()
            content.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            content.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)

            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, content)

            true

        } catch (e: Exception) {
            false
        }
    }

    fun update(guest: GuestModel) {
    }

    fun delete(guest: GuestModel) {
    }

    fun getAll(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()

        return list
    }

    fun getPresent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()

        return list
    }

    fun getAbsent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()

        return list
    }
}