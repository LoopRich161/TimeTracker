package ru.looprich.timetracker.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.looprich.timetracker.models.User

@Dao
interface UserDao {

    @Query("SELECT * FROM `users` WHERE `login`=:login AND `password`=:password")
    fun getByLoginAndPassword(login: String, password: String): User?

    @Query("DELETE FROM `users`")
    fun deleteAll()

    @Insert
    fun insert(user: User)

}