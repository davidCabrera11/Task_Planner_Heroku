package org.adaschool.TaskPlanner.document

import org.adaschool.TaskPlanner.utils.RoleEnum
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document
data class User(

    @Id
    var id:String?,
    var name:String,
    var passwordHash:String,
    var email:String,
    var profilePictureUrl:String,
    val roles: List<RoleEnum>
)
