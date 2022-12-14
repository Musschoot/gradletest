package com.hogent.squads.model

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BaseUrlModule {

    @Provides
    @Singleton
    fun getBaseUrl(): String {
        return "http://10.0.2.2:8081"
    }
}
