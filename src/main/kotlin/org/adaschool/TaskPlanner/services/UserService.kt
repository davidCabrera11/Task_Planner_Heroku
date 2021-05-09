package org.adaschool.TaskPlanner.services

import org.adaschool.TaskPlanner.data.User
import org.adaschool.TaskPlanner.data.dto.UserDto

interface UserService {


    //CRUD Operations

    //Create
    fun save(userDto: UserDto): User

    //Update
    fun update(userId: String,userDto: UserDto):User

    //Read specific reserve
    fun findUserById(userId: String):User?

    fun findByEmail(email: String):User?

    //Read all reserves
    fun all():List<User>

    //Delete
    fun delete(userId:String)
}