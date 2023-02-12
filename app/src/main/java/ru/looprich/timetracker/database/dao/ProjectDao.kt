package ru.looprich.timetracker.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.looprich.timetracker.database.model.ProjectEntity

@Dao
interface ProjectDao {

    @Query("DELETE FROM `projects`")
    fun deleteAll()

    @Insert
    fun insert(projectEntity: ProjectEntity)

    @Query("SELECT * FROM `projects` WHERE `ownerId`=:userId")
    fun getUserProjects(userId: Long): List<ProjectEntity>?

}