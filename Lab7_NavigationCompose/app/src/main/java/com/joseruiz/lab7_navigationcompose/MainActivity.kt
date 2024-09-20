package com.joseruiz.lab7_navigationcompose

import androidx.activity.compose.setContent
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var name by remember { mutableStateOf("") }
            var age by remember { mutableStateOf("") }

            Text(
                text = "Main Activity",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Ingresa tu nombre") }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        value = age,
                        onValueChange = { age = it },
                        label = { Text("Ingresa tu edad") }
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    // Button to navigate to SecondActivity
                    Button(onClick = {
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        intent.putExtra("name", name)
                        intent.putExtra("age", age)
                        startActivity(intent)
                    }) {
                        Text("Second Activity")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Button to navigate to ComposableScreen Activity with bottom navigation
                    Button(onClick = {
                        val intent = Intent(this@MainActivity, ComposableScreen::class.java)
                        intent.putExtra("name", name)
                        intent.putExtra("age", age)
                        startActivity(intent)
                    }) {
                        Text("Navigation Activity")
                    }
                }
            }
        }
    }
}

