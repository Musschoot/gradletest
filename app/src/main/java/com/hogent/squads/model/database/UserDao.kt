package com.hogent.squads.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.hogent.squads.model.domain.UserData

@Dao
interface UserDao {

    @Query("SELECT * FROM user LIMIT 1")
    fun getUser(): LiveData<UserData?>

    @Query("SELECT * FROM user LIMIT 1")
    fun getCurrentUserData(): UserData?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserData)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUser(user: UserData)

    @Delete
    fun deleteUser(user: UserData)

    @Query("DELETE FROM user")
    fun deleteAll()
}
