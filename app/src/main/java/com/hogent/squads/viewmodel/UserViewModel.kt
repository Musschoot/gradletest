package com.hogent.squads.viewmodel

import android.widget.ScrollView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hogent.squads.model.Repository
import com.hogent.squads.model.domain.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun getUser(): LiveData<UserData?> {
        return repository.getUser()
    }

    fun login(userData: UserData, loginScrollView: ScrollView): LiveData<UserData?> {
        return repository.login(userData, loginScrollView)
    }

    fun register(userData: UserData, registerScrollView: ScrollView): LiveData<UserData?> {
        return repository.register(userData, registerScrollView)
    }

    fun logout() {
        repository.logout()
    }
}
