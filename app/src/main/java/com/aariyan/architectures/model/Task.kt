package com.aariyan.architectures.model

data class Task(
    val id: Int,
    val title: String,
    var isCompleted: Boolean = false
)
