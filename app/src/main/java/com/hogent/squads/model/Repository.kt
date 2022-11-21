package com.hogent.squads.model

import android.util.Log
import android.widget.ScrollView
import androidx.lifecycle.LiveData
import com.google.android.material.snackbar.Snackbar
import com.hogent.squads.model.database.UserDao
import com.hogent.squads.model.domain.UserData
import com.hogent.squads.model.network.rest.UserApiServiceInterface
import com.hogent.squads.model.network.rest.resources.UserApiResponseStatus.SUCCESS
import com.hogent.squads.model.network.rest.resources.UserResponseResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val userApiService: UserApiServiceInterface,
    private val userDao: UserDao
) {

    fun getUser(): LiveData<UserData?> {
        return userDao.getUser()
    }


    fun login(userdata: UserData, loginScrollView: ScrollView): LiveData<UserData?> {
        userApiService.login(userdata).enqueue(object : Callback<UserResponseResource> {

            override fun onResponse(
                call: Call<UserResponseResource>,
                response: Response<UserResponseResource>
            ) {
                if (response.isSuccessful && response.body()!!.status == SUCCESS) {
                    userDao.insertUser(userdata)
                }
            }

            override fun onFailure(call: Call<UserResponseResource>, t: Throwable) {
                Snackbar.make(
                    loginScrollView,
                    "Something went wrong, check your internet connection",
                    Snackbar.LENGTH_SHORT
                ).show()
                Log.d("logging", "Could not login user")
            }
        })
        return getUser()
    }

    fun register(userdata: UserData, registerScrollView: ScrollView): LiveData<UserData?> {
        userApiService.register(userdata).enqueue(object : Callback<UserResponseResource> {

            override fun onResponse(
                call: Call<UserResponseResource>,
                response: Response<UserResponseResource>
            ) {
                if (response.isSuccessful && response.body()!!.status == SUCCESS) {
                    userDao.insertUser(userdata)
                }
            }

            override fun onFailure(call: Call<UserResponseResource>, t: Throwable) {
                Snackbar.make(
                    registerScrollView,
                    "Something went wrong, check your internet connection",
                    Snackbar.LENGTH_SHORT
                ).show()
                Log.d("logging", "Could not register user")
            }
        })
        return getUser()
    }

    fun logout() {
        val currentUser = userDao.getCurrentUserData()
        if (currentUser != null) {
            userDao.deleteUser(currentUser)
        }
    }
}
