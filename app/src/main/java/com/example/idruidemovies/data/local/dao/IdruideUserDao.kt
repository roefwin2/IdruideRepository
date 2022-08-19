package com.example.idruidemovies.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.idruidemovies.data.local.entity.IdruideUserEntity

@Dao
interface IdruideUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(idruideUserEntity: IdruideUserEntity)

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<IdruideUserEntity>

    @Query("SELECT * FROM users WHERE id LIKE id")
    suspend fun getUser(id: String): IdruideUserEntity

    @Query("DELETE FROM users")
    suspend fun clearAll()
}