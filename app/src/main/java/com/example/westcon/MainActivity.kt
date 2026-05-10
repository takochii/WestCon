package com.example.westcon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.westcon.ui.theme.WestConTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Makes the UI draw behind the status bar for that full-screen background effect
        enableEdgeToEdge()

        setContent {
            WestConTheme {
                // Tracking 4 screens now: landing, signup, signup2, and join
                var currentScreen by remember { mutableStateOf("landing") }

                Surface(modifier = Modifier.fillMaxSize()) {
                    when (currentScreen) {
                        "landing" -> {
                            WestconLoginScreen(
                                onSignUpClick = { currentScreen = "signup" },
                                onLoginClick = { currentScreen = "join" }
                            )
                        }

                        "signup" -> {
                            // RegisterScreen is from signup.kt
                            RegisterScreen(
                                // When user clicks "Join WESTCON", go to the next step
                                onJoinClick = { currentScreen = "signup2" },
                                onBackClick = { currentScreen = "landing" }
                            )
                        }

                        "signup2" -> {
                            // SignUpStepTwoScreen is from signup2.kt
                            SignUpStepTwoScreen(
                                onNextClick = {
                                    // Eventually move to Home Screen here
                                    currentScreen = "landing"
                                }
                            )
                        }

                        "join" -> {
                            // LoginScreen is from join.kt
                            LoginScreen(
                                onBackClick = { currentScreen = "landing" }
                            )
                        }
                    }
                }
            }
        }
    }
}