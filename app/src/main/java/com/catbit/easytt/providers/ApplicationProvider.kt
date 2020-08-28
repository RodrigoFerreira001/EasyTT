package com.catbit.easytt.providers

import android.content.Context
import com.catbit.easytt.datasource.fromcrawler.CrawlerSource
import com.catbit.easytt.repositories.SharedPreferencesRepository
import com.catbit.easytt.repositories.TimeTrackingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object ApplicationProvider {

    private val userPreferencesKey = "userPreferences"

    @Provides
    @Singleton
    fun provideSharedPreferenceRepository(@ApplicationContext appContext: Context) = SharedPreferencesRepository(appContext, userPreferencesKey)

    @Provides
    @Singleton
    fun provideDataSourceRepository() = TimeTrackingRepository(CrawlerSource())

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext appContext: Context) = appContext
}