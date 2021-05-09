package org.adaschool.TaskPlanner.data

import org.adaschool.TaskPlanner.data.dto.UserDto
import org.adaschool.TaskPlanner.utils.RoleEnum
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.security.crypto.bcrypt.BCrypt


@Document
data class User(

    @Id
    var id:String?,
    var name:String,
    var passwordHash:String,
    var email:String,
    var profilePictureUrl:String,
    val roles: List<RoleEnum>
) {
    fun update(userDto: UserDto) {
        name = userDto.name
        email = userDto.email
        passwordHash = BCrypt.hashpw(userDto.password, BCrypt.gensalt())
        profilePictureUrl = userDto.profilePictureUrl


    }

    constructor(userDto: UserDto) : this(
        null,
        userDto.name,
        BCrypt.hashpw(userDto.password, BCrypt.gensalt()),
        userDto.email,
        userDto.profilePictureUrl,
        listOf(RoleEnum.USER)

    )


}
