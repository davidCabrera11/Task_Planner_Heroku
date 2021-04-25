package org.adaschool.TaskPlanner.services

import org.adaschool.TaskPlanner.controller.dto.UserDto
import org.adaschool.TaskPlanner.model.User
import java.util.concurrent.atomic.AtomicLong

class UserServiceHashMap:UserService {

    private val users = HashMap<String,User>()

    private val nextOid = AtomicLong()

    override fun save(userDto: UserDto): User {
        TODO("Not yet implemented")
    }

    override fun update(userId: String, userDto: UserDto): User {
        TODO("Not yet implemented")
    }

    override fun findReserveById(userId: String): User? {
        TODO("Not yet implemented")
    }

    override fun all(): List<User> {
        TODO("Not yet implemented")
    }

    override fun delete(userId: String): Boolean {
        TODO("Not yet implemented")
    }
}