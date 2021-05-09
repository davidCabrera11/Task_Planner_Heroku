package org.adaschool.TaskPlanner.services

import org.adaschool.TaskPlanner.data.document.Task
import org.adaschool.TaskPlanner.data.dto.TaskDto
import org.adaschool.TaskPlanner.data.repository.TaskRepository
import org.springframework.beans.factory.annotation.Autowired

class TaskServiceMongoDb(@Autowired val taskRepository: TaskRepository):TaskService {


    override fun save(taskDto: TaskDto): Task {
        TODO("Not yet implemented")
    }

    override fun update(taskId: String, taskDto: TaskDto): Task {
        TODO("Not yet implemented")
    }

    override fun findTaskById(taskId: String): Task? {
        TODO("Not yet implemented")
    }

    override fun all(): List<Task> {
        TODO("Not yet implemented")
    }

    override fun delete(taskId: String): Boolean {
        TODO("Not yet implemented")
    }


}