package ru.looprich.timetracker.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.looprich.timetracker.domain.model.Project

@Entity(tableName = "projects")
data class ProjectEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    val ownerId: Long,

    val name: String,

    val completed: Boolean = false

) {

    fun toProject(): Project {
        return Project(
            id = id,
            ownerId = ownerId,
            name = name,
            completed = completed
        )
    }

    companion object {
        fun fromProject(project: Project): ProjectEntity {
            return ProjectEntity(
                id = project.id,
                ownerId = project.ownerId,
                name = project.name,
                completed = project.completed
            )
        }
    }

}
