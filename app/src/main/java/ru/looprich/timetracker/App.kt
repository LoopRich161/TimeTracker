package ru.looprich.timetracker

import android.app.Application
import ru.looprich.timetracker.database.AppDatabase
import ru.looprich.timetracker.models.User
import ru.looprich.timetracker.repository.UserRepository

class App : Application() {

    var userRepo: UserRepository? = null

    override fun onCreate() {
        super.onCreate()

        val db = AppDatabase.getDatabase(this)
        userRepo = UserRepository(db.userDao())
        createTestUser()
    }

    private fun createTestUser() {
        val userTest = User("test", "test")
        if (!userRepo?.checkExist(userTest.login, userTest.password)!!) {
            userRepo!!.addUser(userTest.login, userTest.password)
            println("Inserted new user: test,test")
        }
    }
}