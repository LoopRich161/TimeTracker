package ru.looprich.timetracker.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.looprich.timetracker.R
import ru.looprich.timetracker.database.dao.ProjectDao
import ru.looprich.timetracker.database.dao.UserDao
import ru.looprich.timetracker.database.model.ProjectEntity
import ru.looprich.timetracker.database.model.UserEntity

@Database(
    entities = [UserEntity::class, ProjectEntity::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun projectDao(): ProjectDao

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