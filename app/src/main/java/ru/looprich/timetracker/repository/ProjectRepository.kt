package ru.looprich.timetracker.repository

import ru.looprich.timetracker.dao.ProjectDao
import ru.looprich.timetracker.models.Project
import ru.looprich.timetracker.models.connections.UserAndProject

class ProjectRepository(private val projectDao: ProjectDao) {

    fun getUserProjects(userAndProjects: List<UserAndProject>): List<Project> {
        val projects = mutableListOf<Project>()

        userAndProjects.forEach {
            val project = projectDao.getProjectById(it.projectId)
            projects.add(project)
        }

        return projects.toList()
    }

}