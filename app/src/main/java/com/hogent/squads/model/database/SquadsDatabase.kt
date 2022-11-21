package com.hogent.squads.model.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hogent.squads.model.domain.TypeConverterUserData
import com.hogent.squads.model.domain.UserData

@Database(
    entities = [UserData::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    TypeConverterUserData::class
)
abstract class SquadsDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {
        private var DB_INSTANCE: SquadsDatabase? = null

        fun getSquadsDBInstance(context: Context): SquadsDatabase {
            if (DB_INSTANCE == null) {
                DB_INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    SquadsDatabase::class.java,
                    "SQUADS_DB"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            Log.d("logging", "DB created")
            return DB_INSTANCE!!
        }
    }
}
