package ru.looprich.timetracker

import android.app.Application
import ru.looprich.timetracker.database.AppDatabase
import ru.looprich.timetracker.models.User
import ru.looprich.timetracker.repository.ProjectRepository
import ru.looprich.timetracker.repository.UserRepository
import ru.looprich.timetracker.repository.connections.UserAndProjectRepository

class App : Application() {

    lateinit var userRepo: UserRepository
    lateinit var projectRepo: ProjectRepository
    lateinit var userAndProject: UserAndProjectRepository

    lateinit var user: User

    override fun onCreate() {
        super.onCreate()

        val db = AppDatabase.getDatabase(this)
        userRepo = UserRepository(db.userDao())
        projectRepo = ProjectRepository(db.projectDao())
        userAndProject = UserAndProjectRepository(db.userAndProjectDao())

        createTestUser()
    }

    private fun createTestUser() {
        val userTest = User(login = "test", password = "test")
        if (userRepo.get(userTest.login, userTest.password) == null) {
            userRepo.create(userTest)
            println("Created new user: test, test")
        }
    }
}