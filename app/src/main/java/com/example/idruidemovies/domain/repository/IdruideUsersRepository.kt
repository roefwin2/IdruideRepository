package com.example.idruidemovies.domain.repository

import com.example.idruidemovies.data.local.entity.IdruideUserEntity
import com.example.idruidemovies.utils.Resource
import kotlinx.coroutines.flow.Flow

interface IdruideUsersRepository {

    fun addAccount(idruideUserEntity: IdruideUserEntity) : Flow<Resource<Unit>>
    fun getUsers(): Flow<Resource<List<IdruideUserEntity>>>
}