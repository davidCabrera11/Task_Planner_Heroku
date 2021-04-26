package org.adaschool.TaskPlanner.services

import org.adaschool.TaskPlanner.controller.dto.TaskDto
import org.adaschool.TaskPlanner.model.Task
import java.util.concurrent.atomic.AtomicLong

class TaskServiceHashMap:TaskService {

    private val tasks = HashMap<String,Task>()

    private val nextOid = AtomicLong()

    override fun save(taskDto: TaskDto): Task {
        val task = Task(nextOid.incrementAndGet(),taskDto)
        tasks[taskDto.id] = task
        return task

    }

    override fun update(taskId: String, taskDto: TaskDto): Task {
        if (tasks.containsKey(taskId)){
            val task = tasks[taskId]
            tasks[taskId] = Task(task!!.oid,taskDto)
        }
        return tasks[taskId]!!

    }

    override fun findReserveById(taskId: String): Task? {
        return if (tasks.containsKey(taskId))
            tasks[taskId]
        else
            null

    }

    override fun all(): List<Task> {
        return tasks.values.toList()

    }

    override fun delete(taskId: String): Boolean {
        return tasks.remove(taskId) != null
    }

}