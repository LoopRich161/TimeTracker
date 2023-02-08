package ru.looprich.timetracker.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    val name: String,

    val description: String,

    val completed: Boolean = false

)