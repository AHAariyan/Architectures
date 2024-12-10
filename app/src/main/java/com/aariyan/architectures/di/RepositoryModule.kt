package com.aariyan.architectures.di

import com.aariyan.architectures.repository.TaskRepository
import com.aariyan.architectures.repository.TaskRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTaskRepository(): TaskRepository = TaskRepositoryImpl()
}