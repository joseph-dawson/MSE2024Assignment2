package com.example.assignment2

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment2.ui.theme.Assignment2Theme
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    // Register the permission request launcher
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                // Permission granted, start SecondActivity
                startSecondActivity()
            } else {
                // Permission denied, show a message
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check if permission is already granted
        if (checkSelfPermission("com.example.assignment2.MSE412") == PackageManager.PERMISSION_GRANTED) {
            startSecondActivity()
        } else {
            // If not granted, request permission
            requestPermissionLauncher.launch("com.example.assignment2.MSE412")
        }

        setContent {
            Assignment2Theme {
                FirstActivityApp()
            }
        }
    }

    // Function to start the SecondActivity
    private fun startSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    @Preview
    @Composable
    fun FirstActivityApp() {
        FirstActivityTextAndButtons(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .padding(20.dp)
        )
    }

    @Composable
    fun FirstActivityTextAndButtons(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Joseph Dawson")
            Text("1367442")

            Spacer(modifier = Modifier.padding(12.dp))

            Button(onClick = {
                // Explicit intent to start SecondActivity
                startSecondActivity()
            }) {
                Text("Start activity explicitly")
            }
        }
    }
}
