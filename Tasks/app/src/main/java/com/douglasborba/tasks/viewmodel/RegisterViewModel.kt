package com.douglasborba.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.douglasborba.tasks.service.model.UserModel
import com.douglasborba.tasks.service.repository.UserRepository

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val mUserRepository: UserRepository = UserRepository(mContext)

    private var mSaveUser = MutableLiveData<Boolean>()
    val saveUser: LiveData<Boolean> = mSaveUser

    fun handleSave(name: String, email: String, password: String){
        val user = UserModel().apply {
            this.name = name
            this.email = email
            this.password = password
        }
        mSaveUser.value = mUserRepository.insert(user)
    }
}