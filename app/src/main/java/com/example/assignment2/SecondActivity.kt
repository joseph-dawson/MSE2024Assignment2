package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.ui.platform.LocalContext

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondActivityApp()
        }
    }

    // This method will handle the intent when the SecondActivity is started
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (intent?.action == "com.example.assignment2.START_SECOND_ACTIVITY") {
            // Handle any specific logic if needed for the implicit intent
        }
    }
}

@Preview
@Composable
fun SecondActivityApp() {
    SecondActivityTextAndButton(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center).padding(20.dp))
}

@Composable
fun SecondActivityTextAndButton(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Mobile Software Engineering Challenges:\n" +
                "1. Device Fragmentation\n" +
                "2. OS Fragmentation\n" +
                "3. Unstable and Dynamic Environment\n" +
                "4. Rapid Changes\n" +
                "5. Tool Support\n")

        Spacer(modifier = Modifier.padding(12.dp))

        Button(onClick = {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }) {
            Text("Return to main activity")
        }
    }
}
