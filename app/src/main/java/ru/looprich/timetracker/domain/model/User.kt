package ru.looprich.timetracker.domain.model

data class User(

    val id: Long,

    val login: String,

    val password: String,

    var projects: List<Project>? = null

)
