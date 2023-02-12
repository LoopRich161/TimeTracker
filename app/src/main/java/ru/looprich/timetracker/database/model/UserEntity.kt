package ru.looprich.timetracker.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.looprich.timetracker.domain.model.User


@Entity(tableName = "users")
data class UserEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    val login: String,

    val password: String

) {

    fun toUser(): User {
        return User(
            id = id,
            login = login,
            password = password
        )
    }

    companion object {
        fun fromUser(user: User): UserEntity {
            return UserEntity(
                id = user.id,
                login = user.login,
                password = user.password
            )
        }
    }
}

