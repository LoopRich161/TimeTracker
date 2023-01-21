package ru.looprich.timetracker.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class User(

    val login: String,

    val password: String

) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
}