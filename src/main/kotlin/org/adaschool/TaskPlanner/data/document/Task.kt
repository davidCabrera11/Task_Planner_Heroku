package org.adaschool.TaskPlanner.data.document

import org.adaschool.TaskPlanner.data.dto.TaskDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Task(
    @Id
    var id: String?,
    var description: String,
    var personResponsible:String,
    var dueDate: Date,
    var status: String,
    var userId: String

) {
    fun update(taskDto: TaskDto){
        description = taskDto.description
        personResponsible = taskDto.personResponsible
        dueDate = taskDto.dueDate
        status = taskDto.status

    }



    constructor(taskDto: TaskDto) : this(
        null,
        taskDto.description,
        taskDto.personResponsible,
        taskDto.dueDate,
        taskDto.status,
        taskDto.userId
    )
}

