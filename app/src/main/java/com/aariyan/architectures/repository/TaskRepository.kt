package com.aariyan.architectures.repository

import com.aariyan.architectures.model.Task

interface TaskRepository {
    fun getTask(): List<Task>
    fun addTask(task: Task)
    fun markTaskAsCompleted(id: Int)
}