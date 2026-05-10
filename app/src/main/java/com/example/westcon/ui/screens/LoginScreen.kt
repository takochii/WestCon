package com.example.westcon.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.westcon.ui.theme.*

@Composable
fun LoginScreen(
    onBackClick: () -> Unit = {},
    onJoinClick: (studentId: String, email: String, password: String, confirmPassword: String) -> Unit = { _, _, _, _ -> }
) {
    var studentId by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var showConfirmPassword by remember { mutableStateOf(false) }
    
    val scrollState = rememberScrollState()
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(GradientStart, GradientEnd)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            
            // Header
            Text(
                text = "🎓",
                fontSize = 40.sp,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            
            Text(
                text = "WESTCON",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = WestConGold
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = "Welcome, Taga-WEST!",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = White
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Form Card
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = White,
                        shape = RoundedCornerShape(16.dp)
                    ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Student ID Field
                    OutlinedTextField(
                        value = studentId,
                        onValueChange = { studentId = it },
                        label = { Text("Student ID") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(8.dp),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = WestConBlue,
                            unfocusedBorderColor = LightGray,
                            focusedLabelColor = WestConBlue
                        )
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Email Field
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("WSVU email") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(8.dp),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = WestConBlue,
                            unfocusedBorderColor = LightGray,
                            focusedLabelColor = WestConBlue
                        )
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Password Field
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(8.dp),
                        singleLine = true,
                        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            TextButton(onClick = { showPassword = !showPassword }) {
                                Text(
                                    text = if (showPassword) "Hide" else "Show",
                                    fontSize = 12.sp,
                                    color = TextGray
                                )
                            }
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = WestConBlue,
                            unfocusedBorderColor = LightGray,
                            focusedLabelColor = WestConBlue
                        )
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Confirm Password Field
                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        label = { Text("Re-enter password") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(8.dp),
                        singleLine = true,
                        visualTransformation = if (showConfirmPassword) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            TextButton(onClick = { showConfirmPassword = !showConfirmPassword }) {
                                Text(
                                    text = if (showConfirmPassword) "Hide" else "Show",
                                    fontSize = 12.sp,
                                    color = TextGray
                                )
                            }
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = WestConBlue,
                            unfocusedBorderColor = LightGray,
                            focusedLabelColor = WestConBlue
                        )
                    )
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    // Join Button
                    Button(
                        onClick = {
                            onJoinClick(studentId, email, password, confirmPassword)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = WestConBlue
                        ),
                        shape = RoundedCornerShape(8.dp),
                        enabled = studentId.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()
                    ) {
                        Text(
                            text = "Join WESTCON",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = White
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Footer Links
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Privacy Policy",
                    fontSize = 11.sp,
                    color = White.copy(alpha = 0.7f),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Text(
                    text = "•",
                    fontSize = 11.sp,
                    color = White.copy(alpha = 0.7f),
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
                Text(
                    text = "Terms of Service",
                    fontSize = 11.sp,
                    color = White.copy(alpha = 0.7f),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}