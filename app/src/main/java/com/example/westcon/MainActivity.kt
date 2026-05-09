package com.example.westcon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.westcon.ui.screens.LandingScreen
import com.example.westcon.ui.screens.LoginScreen
import com.example.westcon.ui.theme.WestConTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WestConTheme {
                AppNavigation(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val currentScreen = remember { mutableStateOf<Screen>(Screen.Landing) }
    
    when (currentScreen.value) {
        Screen.Landing -> {
            LandingScreen(
                onSignUpClick = { currentScreen.value = Screen.Login },
                onLoginClick = { currentScreen.value = Screen.Login },
                onContinueClick = { currentScreen.value = Screen.Login }
            )
        }
        Screen.Login -> {
            LoginScreen(
                onBackClick = { currentScreen.value = Screen.Landing },
                onJoinClick = { studentId, email, password, confirmPassword ->
                    // TODO: Handle registration logic here
                    // For now, just navigate back to landing
                    currentScreen.value = Screen.Landing
                }
            )
        }
    }
}

sealed class Screen {
    object Landing : Screen()
    object Login : Screen()
}

@Preview(showBackground = true)
@Composable
fun AppNavigationPreview() {
    WestConTheme {
        AppNavigation()
    }
}