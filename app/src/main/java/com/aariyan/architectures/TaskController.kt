package com.aariyan.architectures

import com.aariyan.architectures.model.Task
import com.aariyan.architectures.repository.TaskRepository

/**
 * [TaskController] has a dependency over [Repository]
 * [Repository] provided through the constructor and that's why it called [Constructor Injection]
 */

class TaskController(
    private val taskRepository: TaskRepository
) {
    fun getTask(): List<Task> = taskRepository.getTask()
    fun addTask(title: String) = taskRepository.addTask(Task(id = 0, title))
    fun markTaskAsCompleted(id: Int) {
        taskRepository.markTaskAsCompleted(id = id)
    }
}