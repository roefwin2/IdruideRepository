package com.example.idruidemovies.di.database

import android.content.Context
import androidx.room.Room
import com.example.idruidemovies.data.local.database.IdruideUserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): IdruideUserDatabase {
        return Room.databaseBuilder(
            context,
            IdruideUserDatabase::class.java,
            "idruideusers.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

}