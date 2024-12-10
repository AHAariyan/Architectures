package com.aariyan.architectures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.aariyan.architectures.repository.TaskRepositoryImpl
import com.aariyan.architectures.ui.screens.TaskListView
import com.aariyan.architectures.ui.theme.ArchitecturesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val repository = TaskRepositoryImpl()
        val controller = TaskController(repository)

        setContent {
            ArchitecturesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ShowContent(innerPadding = innerPadding, controller = controller)
                }
            }
        }
    }
}

@Composable
internal fun ShowContent(innerPadding: PaddingValues, controller: TaskController) {
    Column(
        modifier = Modifier.padding(innerPadding)
    ) {
        TaskListView(controller = controller)
    }

}