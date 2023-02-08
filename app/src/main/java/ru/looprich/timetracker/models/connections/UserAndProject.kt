package ru.looprich.timetracker.models.connections

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_and_project")
data class UserAndProject(

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    val userId: Long,

    val projectId: Long

)
