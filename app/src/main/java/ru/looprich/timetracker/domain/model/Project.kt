package ru.looprich.timetracker.domain.model

data class Project(
    var id: Long,

    var ownerId: Long,

    val name: String,

    val completed: Boolean
)
