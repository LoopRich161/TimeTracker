package ru.looprich.timetracker.domain.repository

import ru.looprich.timetracker.domain.model.User

interface UserRepository {

    fun getByLoginAndPassword(login: String, password: String): User?

    fun create(user: User): Boolean

}

