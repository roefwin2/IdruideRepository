package com.example.idruidemovies.domain.usecases

import com.example.idruidemovies.data.local.entity.IdruideUserEntity
import com.example.idruidemovies.data.repository.IdruideUsersRepositoryImpl
import com.example.idruidemovies.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AddAccountUseCase @Inject constructor(
    private val idruideUsersRepositoryImpl: IdruideUsersRepositoryImpl
) {

    fun invoke(idruideUserEntity: IdruideUserEntity): Flow<Resource<Unit>> {
        return idruideUsersRepositoryImpl.addAccount(idruideUserEntity).map {
            it
        }
    }
}