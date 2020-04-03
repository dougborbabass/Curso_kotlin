package com.douglasborba.convidados.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.douglasborba.convidados.service.model.GuestModel
import com.douglasborba.convidados.service.repository.GuestRepository

class GuestFormViewModel(application: Application): AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val mGuestRepository: GuestRepository = GuestRepository.getInstance(mContext)

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest:LiveData<Boolean> = mSaveGuest

    private var mGuest = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = mGuest

    fun save(name: String, isPresent: Boolean){
        val guest = GuestModel(name = name, presence = isPresent)
        mSaveGuest.value = mGuestRepository.save(guest)
    }

    fun load(id: Int){
        mGuest.value = mGuestRepository.getGuest(id)
    }
}