package ru.looprich.timetracker.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "projects")
data class Project(

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    val name: String,

    val completed: Boolean = false

)
