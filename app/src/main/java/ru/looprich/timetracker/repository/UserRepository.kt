package ru.looprich.timetracker.repository

import ru.looprich.timetracker.dao.UserDao
import ru.looprich.timetracker.models.User

class UserRepository(private val userDao: UserDao) {

    fun get(login: String, password: String): User? {
        return userDao.getByLoginAndPassword(login, password)
    }

    fun create(user: User) {
        userDao.insert(user)
    }

}