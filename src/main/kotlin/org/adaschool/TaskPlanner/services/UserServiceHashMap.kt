package org.adaschool.TaskPlanner.services

import org.adaschool.TaskPlanner.data.User
import org.adaschool.TaskPlanner.data.dto.UserDto
import org.adaschool.TaskPlanner.utils.RoleEnum
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong


class UserServiceHashMap:UserService {

    private val users = HashMap<String,User>()

    private val nextOid = AtomicLong()

    init {
        createSampleUser()
    }

    private fun createSampleUser(){
        val id = nextOid.incrementAndGet().toString()
        val user = User(
            id,
            "David",
            BCrypt.hashpw("passw0rd",BCrypt.gensalt()),
            "davidcab11@gmail.com",
            "https://www.imgur.com/kotlin-image" ,
            listOf(RoleEnum.USER)
        )
        users[id] = user
    }

    override fun save(userDto: UserDto): User {
        TODO("Not yet implemented")
    }


    override fun update(userId: String, userDto: UserDto): User {
        if (users.containsKey(userId)) {
            val user = users[userId]
            users[userId] = User( userDto)
            users[userId]!!.id = userId
        }
        return users[userId]!!
    }

    override fun findUserById(userId: String): User? {
        return if (users.containsKey(userId))
            users[userId]
        else
            null
    }

    override fun findByEmail(email: String): User? {
        return users.values.find { email == it.email }
    }

    override fun all(): List<User> {
        return users.values.toList()
    }

    override fun delete(userId: String) {
        users.remove(userId) != null
    }
}