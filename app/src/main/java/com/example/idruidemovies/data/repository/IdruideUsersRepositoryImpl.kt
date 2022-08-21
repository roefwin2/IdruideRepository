package com.example.idruidemovies.data.repository

import com.example.idruidemovies.data.local.dao.IdruideUserDao
import com.example.idruidemovies.data.local.entity.IdruideUserEntity
import com.example.idruidemovies.domain.repository.IdruideUsersRepository
import com.example.idruidemovies.utils.Error
import com.example.idruidemovies.utils.Loading
import com.example.idruidemovies.utils.Success
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class IdruideUsersRepositoryImpl @Inject constructor(
    private val userDao: IdruideUserDao
) : IdruideUsersRepository {
    override fun addAccount(idruideUserEntity: IdruideUserEntity) = flow {
        emit(Loading())
        try {
            userDao.insertUser(idruideUserEntity)
            emit(Success(Unit))
        } catch (e: Exception) {
            emit(Error(e.toString()))
        }
    }

    override fun getUsers() = flow {
        emit(Loading())
        try {
            val users = userDao.getAllUsers()
            emit(Success(users))
        } catch (e: Exception) {
            emit(Error(e.toString()))
        }
    }
}