package com.example.idruidemovies.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.idruidemovies.data.local.dao.IdruideUserDao
import com.example.idruidemovies.data.local.entity.IdruideUserEntity

@Database(
    entities = [IdruideUserEntity::class],
    version = 1
)
abstract class IdruideUserDatabase : RoomDatabase() {
    abstract val userDao: IdruideUserDao
}