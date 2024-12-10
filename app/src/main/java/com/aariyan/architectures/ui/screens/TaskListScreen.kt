package com.aariyan.architectures.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aariyan.architectures.TaskController
import com.aariyan.architectures.model.Task


@Composable
fun TaskListView(
    controller: TaskController
) {

    var taskTitle by remember { mutableStateOf("") }
    val tasks = remember { mutableStateOf(controller.getTask()) }
    Column (
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {


        TextField(
            value = taskTitle,
            onValueChange = { taskTitle = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Enter task title") }
        )
        Spacer(modifier = Modifier.height(8.dp))


        Button(
            onClick = {
                if (taskTitle.isNotEmpty()) {
                    controller.addTask(taskTitle)
                    taskTitle = ""
                    tasks.value = controller.getTask() // Manual update
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Add Task")
        }
        Spacer(modifier = Modifier.height(16.dp))


        LazyColumn {
            items(tasks.value) { task ->
                TaskItem(
                    task = task,
                    onComplete = {
                        controller.markTaskAsCompleted(it)
                        tasks.value = controller.getTask()
                    }
                )
            }
        }
    }
}

@Composable
fun TaskItem(task: Task, onComplete: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = if (task.isCompleted) "${task.title} (Completed)" else task.title,
            modifier = Modifier.weight(1f)
        )
        if (!task.isCompleted) {
            Button(onClick = { onComplete(task.id) }) {
                Text("Complete")
            }
        }
    }
}