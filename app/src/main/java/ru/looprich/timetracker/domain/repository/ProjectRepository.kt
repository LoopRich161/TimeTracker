package ru.looprich.timetracker.domain.repository

import ru.looprich.timetracker.domain.model.Project
import ru.looprich.timetracker.domain.model.User

typealias Projects = List<Project>

interface ProjectRepository {

    fun getUserProjects(user: User): Projects

}