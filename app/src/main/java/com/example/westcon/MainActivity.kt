package com.example.westcon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.westcon.ui.theme.WestConTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enables the full-screen experience behind the status bar
        enableEdgeToEdge()

        setContent {
            WestConTheme {
                // Tracking 6 distinct screen states
                var currentScreen by remember { mutableStateOf("landing") }

                Surface(modifier = Modifier.fillMaxSize()) {
                    when (currentScreen) {
                        // 1. Initial Landing Page (login.kt)
                        "landing" -> {
                            WestconLoginScreen(
                                onSignUpClick = { currentScreen = "signup" },
                                onLoginClick = { currentScreen = "join" }
                            )
                        }

                        // 2. Sign Up Part 1: Credentials (signup.kt)
                        "signup" -> {
                            RegisterScreen(
                                onJoinClick = { currentScreen = "signup2" },
                                onBackClick = { currentScreen = "landing" }
                            )
                        }

                        // 3. Sign Up Part 2: College Info (signup2.kt)
                        "signup2" -> {
                            SignUpStepTwoScreen(
                                onNextClick = { currentScreen = "signup3" }
                            )
                        }

                        // 4. Sign Up Part 3: Skills to Give (signup3.kt)
                        "signup3" -> {
                            SkillSelectionScreen(
                                onNextClick = { currentScreen = "signup4" }
                            )
                        }

                        // 5. Sign Up Part 4: Skills to Learn (signup4.kt)
                        "signup4" -> {
                            SkillWantedScreen(
                                onNextClick = { currentScreen = "landing" }
                            )
                        }

                        // 6. Login Page (join.kt)
                        "join" -> {
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WestConTheme {
        Greeting("Android")
    }
}