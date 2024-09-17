package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondActivityApp()
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
    //for calling MainActivity in button
    val context = LocalContext.current

    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Device Fragmentation\n" +
                "OS Fragmentation\n" +
                "Unstable and Dynamic Environment\n" +
                "Rapid Changes\n" +
                "Tool Support\n")

        Spacer(modifier = Modifier.padding(12.dp))

        Button(onClick = {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }) {
            Text("Return to main activity")
        }
    }
}