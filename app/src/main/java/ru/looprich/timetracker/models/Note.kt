package ru.looprich.timetracker.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    val note: String

)
