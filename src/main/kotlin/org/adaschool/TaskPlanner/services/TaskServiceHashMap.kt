package org.adaschool.TaskPlanner.services

import org.adaschool.TaskPlanner.controller.dto.TaskDto
import org.adaschool.TaskPlanner.model.Task
import java.util.concurrent.atomic.AtomicLong

class TaskServiceHashMap:TaskService {

    private val tasks = HashMap<String,Task>()

    private val nextOid = AtomicLong()

    override fun save(taskDto: TaskDto): Task {
        TODO("Not yet implemented")
    }

    override fun update(taskId: String, taskDto: TaskDto): Task {
        TODO("Not yet implemented")
    }

    override fun findReserveById(taskId: String): Task? {
        TODO("Not yet implemented")
    }

    override fun all(): List<Task> {
        TODO("Not yet implemented")
    }

    override fun delete(taskId: String): Boolean {
        TODO("Not yet implemented")
    }
}