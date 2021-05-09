package org.adaschool.TaskPlanner.services

import org.adaschool.TaskPlanner.data.User
import org.adaschool.TaskPlanner.data.dto.UserDto
import org.adaschool.TaskPlanner.data.repository.UserRepository
import org.adaschool.TaskPlanner.utils.RoleEnum
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class UserServiceMongoDb(@Autowired val userRepository: UserRepository): UserService {


    override fun save(userDto: UserDto): User {
        return userRepository.save(User(userDto))

     }

    override fun update(userId: String, userDto: UserDto): User {
        val user = userRepository.findById(userId).get()
        user.update(userDto)
        return userRepository.save(user)

    }

    override fun findUserById(userId: String): User? {
        return userRepository.findById(userId).orElse(null)


    }

    override fun findByEmail(email: String): User? {
        return userRepository.findUserByEmail(email)
    }

    override fun all(): List<User> {
        return userRepository.findAll()

    }

    override fun delete(userId: String) {
        return userRepository.deleteById(userId)

    }
}