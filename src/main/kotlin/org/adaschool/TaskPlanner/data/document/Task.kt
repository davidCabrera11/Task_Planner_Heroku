package org.adaschool.TaskPlanner.data.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Task(
    @Id
    val id: String?,
    val description: String,
    val personResponsible:String,
    val dueDate: Date,
    val status: String,
    val userId: String

)

