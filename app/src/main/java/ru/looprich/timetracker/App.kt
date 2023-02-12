package ru.looprich.timetracker

import android.app.Application
import ru.looprich.timetracker.database.AppDatabase
import ru.looprich.timetracker.database.repository.ProjectRepositoryImpl
import ru.looprich.timetracker.database.repository.UserRepositoryImpl
import ru.looprich.timetracker.domain.model.User
import ru.looprich.timetracker.domain.repository.ProjectRepository
import ru.looprich.timetracker.domain.repository.UserRepository

class App : Application() {

    lateinit var userRepo: UserRepository
    lateinit var projectRepo: ProjectRepository

    lateinit var user: User

    override fun onCreate() {
        super.onCreate()

        val db = AppDatabase.getDatabase(this)
        userRepo = UserRepositoryImpl(db.userDao())
        projectRepo = ProjectRepositoryImpl(db.projectDao())

        createTestUser()
    }

    private fun createTestUser() {
        val userTest = User(id = -1, login = "test", password = "test")

        if (userRepo.create(userTest)) {
            println("Created new user: test, test")
        }
    }
}