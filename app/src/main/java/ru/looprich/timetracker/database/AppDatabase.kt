package ru.looprich.timetracker.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.looprich.timetracker.R
import ru.looprich.timetracker.dao.ProjectDao
import ru.looprich.timetracker.dao.UserDao
import ru.looprich.timetracker.dao.connections.UserAndProjectDao
import ru.looprich.timetracker.models.Note
import ru.looprich.timetracker.models.Project
import ru.looprich.timetracker.models.Task
import ru.looprich.timetracker.models.User
import ru.looprich.timetracker.models.connections.UserAndProject

@Database(
    entities = [User::class, Project::class, Task::class, Note::class, UserAndProject::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun projectDao(): ProjectDao

    abstract fun userAndProjectDao(): UserAndProjectDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            context: Context
        ): AppDatabase {
            return INSTANCE ?: createDatabase(context)
        }

        private fun createDatabase(context: Context): AppDatabase {
            val db = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                context.getString(R.string.appName)
            )
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()

            INSTANCE = db
            return db
        }
    }
}