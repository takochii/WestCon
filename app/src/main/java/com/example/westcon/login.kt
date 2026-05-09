package com.example.westcon // Update this to match your project package

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.westcon.R
//this is test
// Define the brand colors based on your image
val WestconBlue = Color(0xFF004AAD)
val WestconDarkBlue = Color(0xFF001D3D)
val WestconYellow = Color(0xFFFFD700)

@Composable
fun WestconLoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(WestconBlue)
            .padding(24.dp)
    ) {
        // Main Content Container
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            // Logo Section
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Replace 'ic_grad_cap' with your actual drawable resource
                Icon(
                    painter = painterResource(id = R.drawable.icon),
                    contentDescription = "Logo",
                    tint = WestconYellow,
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = "WESTCON",
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "THE OFFICIAL STUDENT SKILL\nMARKETPLACE",
                        color = Color.White,
                        fontSize = 10.sp,
                        lineHeight = 12.sp,
                        letterSpacing = 1.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(60.dp))

            // Headline
            Text(
                text = "Let’s get you\nsorted",
                color = Color.White,
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 48.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Sub-headline
            Text(
                text = "WANT TO CONNECT WITH FELLOW\nTAGA-WESTS?",
                color = Color.White.copy(alpha = 0.9f),
                fontSize = 16.sp,
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Sign Up Button
            Button(
                onClick = { /* TODO: Sign Up Logic */ },
                modifier = Modifier.fillMaxWidth().height(64.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = WestconDarkBlue)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.tdesign_education_filled),
                        contentDescription = null,
                        tint = WestconYellow,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text("Sign up with Student ID", color = WestconYellow, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Login Button
            Button(
                onClick = { /* TODO: Login Logic */ },
                modifier = Modifier.fillMaxWidth().height(64.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = null,
                        tint = WestconDarkBlue,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text("Login with Student ID", color = WestconDarkBlue, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        // Footer Section
        Column(
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "ACADEMIC INTEGRITY • PEER COLLABORATION • WVSU EXCELLENCE",
                color = Color.White.copy(alpha = 0.6f),
                fontSize = 10.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text("Privacy Policy", color = Color.White.copy(alpha = 0.8f), fontSize = 14.sp)
                Text("  •  ", color = Color.White.copy(alpha = 0.8f))
                Text("Terms of Service", color = Color.White.copy(alpha = 0.8f), fontSize = 14.sp)
            }
        }
    }
}