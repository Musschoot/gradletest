package com.hogent.squads.model.domain

import android.service.autofill.UserData
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@Entity(tableName = "user")
data class UserData(
    @PrimaryKey
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "password")
    val password: String?
)

class TypeConverterUserData {
    private val gson: Gson = Gson()

    @TypeConverter
    fun jsonToUserData(json: String?): UserData? {
        if (json == null) return null
        val listType: Type = object : TypeToken<UserData>() {}.type
        return gson.fromJson<UserData>(json, listType)
    }

    @TypeConverter
    fun userDataToJson(userData: UserData): String? {
        return gson.toJson(userData)
    }
}
