package ru.looprich.timetracker.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.looprich.timetracker.models.User

@Dao
interface UserDao {

    @Query("SELECT * FROM `users` WHERE `login`=:login AND `password`=:password LIMIT 1")
    fun getByLoginAndPassword(login: String, password: String): User?

    @Query("SELECT EXISTS(SELECT * FROM `users` WHERE `login`=:login AND `password`=:password LIMIT 1)")
    fun checkExist(login: String, password: String): Boolean

    @Query("DELETE FROM `users`")
    fun deleteAll()

    @Insert
    fun insert(user: User)

}