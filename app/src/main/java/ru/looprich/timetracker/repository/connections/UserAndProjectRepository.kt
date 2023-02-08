package ru.looprich.timetracker.repository.connections

import ru.looprich.timetracker.dao.connections.UserAndProjectDao
import ru.looprich.timetracker.models.connections.UserAndProject


class UserAndProjectRepository(private val userAndProjectDao: UserAndProjectDao) {

    fun getUserProjectsId(userId: Long): List<UserAndProject> {
        return userAndProjectDao.getUserProjectsId(userId)
    }

}