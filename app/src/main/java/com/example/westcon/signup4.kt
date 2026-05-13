package com.example.westcon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SkillWantedScreen(onNextClick: () -> Unit) {
    // List to track skills the user wants to LEARN
    val wantedSkills = remember { mutableStateListOf<String>() }
    val availableSkills = listOf("Mobile Dev", "Data Science", "Public Speaking", "Photography", "SEO")

    Box(modifier = Modifier.fillMaxSize()) {
        // Background
        Image(
            painter = painterResource(id = R.drawable.bg_login),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .statusBarsPadding()
                .padding(top = 130.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // Updated Header Text per your request
            Text(
                text = "I want to\nlearn...",
                color = Color.White,
                fontSize = 42.sp,
                lineHeight = 48.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = MomotrustFontFamily
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Skills You're Interested In",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = MomotrustFontFamily
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Reusing the SkillDropdown from signup3.kt
            SkillDropdown(options = availableSkills) { skill ->
                if (!wantedSkills.contains(skill)) {
                    wantedSkills.add(skill)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Reusing FlowRow logic to display chips
            @OptIn(ExperimentalLayoutApi::class)
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                wantedSkills.forEach { skill ->
                    // Reusing SkillChip from signup3.kt
                    SkillChip(text = skill) {
                        wantedSkills.remove(skill)
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // Final Button
            Button(
                onClick = onNextClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 60.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF001D3D))
            ) {
                Text(
                    "Finish Setup",
                    color = WestconYellow,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = MomotrustFontFamily
                )
            }
        }
    }
}