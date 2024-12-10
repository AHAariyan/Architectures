package com.aariyan.architectures

import androidx.compose.runtime.saveable.rememberSaveable
import com.aariyan.architectures.model.Task
import com.aariyan.architectures.repository.TaskRepositoryImpl
import junit.framework.TestCase.assertEquals
import org.junit.Test


class AddCourseUnitTest {

    @Test
    fun `addTask adds task to repository`() {

        val testTaskTitle = "Test Task"

        val repository = TaskRepositoryImpl()
        repository.addTask(Task(id = 0, title = testTaskTitle))

        val tasks = repository.getTask()
        assertEquals(1, tasks.size)
        assertEquals(testTaskTitle, tasks[0].title)
    }
}