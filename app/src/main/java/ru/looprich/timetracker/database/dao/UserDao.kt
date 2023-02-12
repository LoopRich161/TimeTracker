package ru.looprich.timetracker.database.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.looprich.timetracker.database.model.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM `users` WHERE `login`=:login AND `password`=:password")
    fun getByLoginAndPassword(login: String, password: String): UserEntity?

    @Query("DELETE FROM `users`")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(userEntity: UserEntity): Long

}