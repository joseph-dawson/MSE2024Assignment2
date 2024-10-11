package com.example.assignment2

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class ThirdActivity : ComponentActivity() {
    private lateinit var imageCaptureLauncher: ActivityResultLauncher<Intent>
    private var imageBitmap: Bitmap? by mutableStateOf(null) // Use mutable state for bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content for the activity
        setContent {
            ThirdActivityApp()
        }

        // Register the camera intent activity result launcher
        imageCaptureLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                // Retrieve the image from the data
                val photo = result.data?.extras?.get("data") as? Bitmap
                imageBitmap = photo // Store the captured bitmap
            }
        }
    }

    @Composable
    fun ThirdActivityApp() {
        Column(
            modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center).padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Button to capture image
            Button(onClick = {
                // Create an intent to open the camera
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                imageCaptureLauncher.launch(cameraIntent)
            }) {
                Text("Capture Image")
            }

            Spacer(modifier = Modifier.padding(12.dp))

            // Display the captured image if it exists
            imageBitmap?.let { bitmap ->
                Image(bitmap = bitmap.asImageBitmap(), contentDescription = null, modifier = Modifier.size(200.dp))
            }
        }
    }

    @Preview
    @Composable
    fun PreviewThirdActivity() {
        ThirdActivityApp()
    }
}

