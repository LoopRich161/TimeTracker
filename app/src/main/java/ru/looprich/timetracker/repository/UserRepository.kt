package ru.looprich.timetracker.repository

import ru.looprich.timetracker.dao.UserDao
import ru.looprich.timetracker.models.User

class UserRepository(private val userDao: UserDao) {

    fun checkExist(login: String, password: String): Boolean {
        return userDao.checkExist(login, password)
    }

    fun addUser(login: String, password: String) {
        userDao.insert(User(login, password))
    }

}