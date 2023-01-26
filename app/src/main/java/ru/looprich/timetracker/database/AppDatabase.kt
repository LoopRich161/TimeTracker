package ru.looprich.timetracker.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.looprich.timetracker.R
import ru.looprich.timetracker.dao.UserDao
import ru.looprich.timetracker.models.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

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