package ru.looprich.timetracker.database.repository

import ru.looprich.timetracker.database.dao.UserDao
import ru.looprich.timetracker.database.model.UserEntity
import ru.looprich.timetracker.domain.model.User
import ru.looprich.timetracker.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userDao: UserDao
) : UserRepository {


    override fun getByLoginAndPassword(login: String, password: String): User? {
        return userDao.getByLoginAndPassword(login = login, password = password)?.toUser()
    }

    override fun create(user: User): Boolean {
        return userDao.insert(UserEntity.fromUser(user = user)) == 1L
    }

}