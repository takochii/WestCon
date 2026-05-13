package com.example.westcon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
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
fun SkillSelectionScreen(onNextClick: () -> Unit) {
    val selectedSkills = remember { mutableStateListOf<String>() }
    val availableSkills = listOf("UI/UX", "Academic Writing", "Graphic Design", "Programming", "Tutoring")

    Box(modifier = Modifier.fillMaxSize()) {
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
            Text(
                text = "I can help with...",
                color = Color.White,
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = MomotrustFontFamily,
                lineHeight = 46.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Your Skill Set",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = MomotrustFontFamily
            )

            Spacer(modifier = Modifier.height(20.dp))

            // This call should no longer be red
            SkillDropdown(options = availableSkills) { skill ->
                if (!selectedSkills.contains(skill)) {
                    selectedSkills.add(skill)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            @OptIn(ExperimentalLayoutApi::class)
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                selectedSkills.forEach { skill ->
                    // This call should no longer be red
                    SkillChip(text = skill) {
                        selectedSkills.remove(skill)
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onNextClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 80.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF001229))
            ) {
                Text(
                    "Next",
                    color = WestconYellow,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = MomotrustFontFamily
                )
            }
        }
    }
}

// Ensure these two functions are OUTSIDE of SkillSelectionScreen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SkillDropdown(options: List<String>, onSkillSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        OutlinedTextField(
            value = "Select a Skill",
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth().menuAnchor(),
            shape = RoundedCornerShape(50),
            leadingIcon = {
                Icon(painterResource(R.drawable.skill), null, tint = WestconDarkBlue)
            },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                unfocusedTextColor = Color.Gray
            )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onSkillSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun SkillChip(text: String, onRemove: () -> Unit) {
    Box(
        modifier = Modifier
            .background(Color.White, RoundedCornerShape(20.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = text,
                color = WestconDarkBlue,
                fontWeight = FontWeight.Bold,
                fontFamily = MomotrustFontFamily
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painterResource(R.drawable.delete),
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier.size(18.dp).clickable { onRemove() }
            )
        }
    }
}