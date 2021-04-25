package org.adaschool.TaskPlanner.model

import org.adaschool.TaskPlanner.controller.dto.TaskDto
import java.util.*

data class Task(
    val oid: Long,
    val id: String,
    val description: String,
    val personResponsible:String,
    val startDate: Date,
    val endDate: Date,
    val status: String
)
{
    constructor(oid: Long,taskDto: TaskDto):this
        (oid,taskDto.id,taskDto.description,taskDto.personResponsible,
        taskDto.startDate,taskDto.endDate,taskDto.status)
}