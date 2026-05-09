package com.example.westcon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.westcon.ui.theme.WestConTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This makes the blue background go behind the status bar
        enableEdgeToEdge()

        setContent {
            WestConTheme {
                // Surface is better here than Scaffold for a solid background
                Surface(modifier = Modifier.fillMaxSize()) {
                    // Call the screen you created in LoginScreen.kt
                    WestconLoginScreen()
                }
            }
        }
    }
}