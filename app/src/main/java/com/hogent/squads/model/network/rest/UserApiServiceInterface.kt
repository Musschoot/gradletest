package com.hogent.squads.model.network.rest

import com.hogent.squads.model.domain.UserData
import com.hogent.squads.model.network.rest.resources.UserResponseResource
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserApiServiceInterface {

    @Headers("Content-Type:application/json")
    @POST("/users/login")
    fun login(@Body loginResource: UserData): Call<UserResponseResource>

    @Headers("Content-Type:application/json")
    @POST("/users/login")
    fun logout(@Body loginResource: UserData): Call<UserResponseResource>

    @Headers("Content-Type:application/json")
    @POST("/users/register")
    fun register(@Body registrationResource: UserData): Call<UserResponseResource>
}
