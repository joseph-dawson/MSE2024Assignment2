package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment2.ui.theme.Assignment2Theme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.Spacer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment2Theme {
                FirstActivityApp()
            }
        }
    }

    @Preview
    @Composable
    fun FirstActivityApp() {
        FirstActivityTextAndButtons(
            modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center).padding(20.dp)
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
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)
            }) {
                Text("Start activity explicitly")
            }

            Button(onClick = {
                val intent = Intent()
                intent.setClassName(this@MainActivity, SecondActivity::class.java.name)
                startActivity(intent)
            }) {
                Text("Start activity implicitly")
            }
        }
    }
}