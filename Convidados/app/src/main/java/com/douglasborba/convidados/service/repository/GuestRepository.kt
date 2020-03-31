package com.douglasborba.convidados.service.repository

import com.douglasborba.convidados.service.model.GuestModel

class GuestRepository {

    fun getAll(): List<GuestModel>{
        val list: MutableList<GuestModel> = ArrayList()

        return list
    }

    fun getPresent(): List<GuestModel>{
        val list: MutableList<GuestModel> = ArrayList()

        return list
    }

    fun getAbsent(): List<GuestModel>{
        val list: MutableList<GuestModel> = ArrayList()

        return list
    }

    // CRUD - create, read, update, delete

    fun save(guest: GuestModel){
    }

    fun update(guest: GuestModel){
    }

    fun delete(guest: GuestModel){
    }
}