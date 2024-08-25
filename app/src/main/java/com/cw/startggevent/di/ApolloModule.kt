package com.cw.startggevent.di

import com.apollographql.apollo.ApolloClient
import com.cw.startggevent.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ApolloModule {

    @Provides
    fun provideApolloClient() = ApolloClient.Builder()
        .serverUrl(BuildConfig.URL_ENDPOINT)
        .addHttpHeader(name = "Authorization", "Bearer ${BuildConfig.API_TOKEN}")
        .build()

}