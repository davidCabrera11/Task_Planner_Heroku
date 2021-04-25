package org.adaschool.TaskPlanner.model

import org.adaschool.TaskPlanner.controller.dto.UserDto

data class User(
    val oid:Long,
    val id:String,
    val name:String,
    val password:String,
    val email:String,
    val profilePictureUrl:String


)
{
    constructor(oid: Long,userDto: UserDto):this
        (oid,userDto.id,userDto.name,userDto.password,
        userDto.email,userDto.profilePictureUrl)
}