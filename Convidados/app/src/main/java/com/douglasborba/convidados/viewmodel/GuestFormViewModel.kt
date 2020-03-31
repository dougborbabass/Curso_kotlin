package com.douglasborba.convidados.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.douglasborba.convidados.service.model.GuestModel
import com.douglasborba.convidados.service.repository.GuestRepository

class GuestFormViewModel: ViewModel() {

    private val mGuestRepository: GuestRepository =
        GuestRepository()

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest:LiveData<Boolean> = mSaveGuest

    fun save(name: String, isPresent: Boolean){
        val guest = GuestModel(name, isPresent)
        mGuestRepository.save(guest)
    }
}