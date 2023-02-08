package ru.looprich.timetracker.dao.connections

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.looprich.timetracker.models.connections.UserAndProject

@Dao
interface UserAndProjectDao {

    @Query("DELETE FROM `user_and_project`")
    fun deleteAll()

    @Insert
    fun insert(userAndProject: UserAndProject)

    @Query("SELECT * FROM `user_and_project` WHERE `userId`=:userId")
    fun getUserProjectsId(userId: Long): List<UserAndProject>

}
