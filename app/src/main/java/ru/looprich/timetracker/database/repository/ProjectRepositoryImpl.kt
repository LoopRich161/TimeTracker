package ru.looprich.timetracker.database.repository

import ru.looprich.timetracker.database.dao.ProjectDao
import ru.looprich.timetracker.domain.model.Project
import ru.looprich.timetracker.domain.model.User
import ru.looprich.timetracker.domain.repository.ProjectRepository

class ProjectRepositoryImpl(private val projectDao: ProjectDao) : ProjectRepository {

    override fun getUserProjects(user: User): List<Project> {
        val projectEntities = projectDao.getUserProjects(user.id)
        val projects = emptyList<Project>()

        projectEntities?.stream()?.map {
            projects.plus(
                it.toProject()
            )
        }

        return projects;
    }


}