package com.aariyan.architectures.repository

import com.aariyan.architectures.model.Task

class TaskRepositoryImpl: TaskRepository {

    private val tasks = mutableListOf<Task>()
    private var nextId = 1

    override fun getTask(): List<Task> = tasks

    override fun addTask(task: Task) {
        tasks.add(task.copy(id = nextId ++))
    }

    override fun markTaskAsCompleted(id: Int) {
        tasks.find { it.id == id }?.isCompleted = true
    }
}