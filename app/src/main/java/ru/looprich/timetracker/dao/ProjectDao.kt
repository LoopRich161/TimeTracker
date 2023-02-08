package ru.looprich.timetracker.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.looprich.timetracker.models.Project

@Dao
interface ProjectDao {

    @Query("DELETE FROM `projects`")
    fun deleteAll()

    @Insert
    fun insert(project: Project)

    @Query("SELECT * FROM `projects` WHERE `id`=:id")
    fun getProjectById(id: Long): Project

}