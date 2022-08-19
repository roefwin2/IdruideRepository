package com.example.idruidemovies.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class IdruideUserEntity(
    @PrimaryKey val id : String,
    val firstName: String,
    val lastName : String,
    val email :String,
    val password :String
)
