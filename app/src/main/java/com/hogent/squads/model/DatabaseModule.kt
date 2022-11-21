package com.hogent.squads.model

import android.app.Application
import com.hogent.squads.model.database.SquadsDatabase
import com.hogent.squads.model.database.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun getSquadsDatabase(context: Application): SquadsDatabase {
        return SquadsDatabase.getSquadsDBInstance(context)
    }

    @Provides
    @Singleton
    fun getUserDao(squadsDatabase: SquadsDatabase): UserDao {
        return squadsDatabase.getUserDao()
    }
}
