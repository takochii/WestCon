package com.example.westcon.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.westcon.ui.theme.*

data class OnboardingPage(
    val title: String,
    val description: String
)

val onboardingPages = listOf(
    OnboardingPage(
        title = "Connect and interact with fellow Taga-Wests.",
        description = "Build meaningful connections with students"
    ),
    OnboardingPage(
        title = "Share skills and expand your network with Taga-Wests.",
        description = "Grow together through shared experiences"
    ),
    OnboardingPage(
        title = "Join the community and make WSU the best.",
        description = "Be part of something bigger"
    )
)

@Composable
fun LandingScreen(
    onSignUpClick: () -> Unit = {},
    onLoginClick: () -> Unit = {},
    onContinueClick: () -> Unit = {}
) {
    val pagerState = rememberPagerState(pageCount = { onboardingPages.size })
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Pager
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) { page ->
                OnboardingPageContent(onboardingPages[page])
            }
            
            // Page Indicators
            PageIndicators(
                pageCount = onboardingPages.size,
                currentPage = pagerState.currentPage,
                modifier = Modifier.padding(vertical = 24.dp)
            )
            
            // Buttons - Only show on last page
            if (pagerState.currentPage == onboardingPages.size - 1) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Get Started Button
                    Button(
                        onClick = onContinueClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = WestConGold
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Get Started",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = DarkGray
                        )
                    }
                    
                    // Footer Links
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Privacy Policy",
                            fontSize = 11.sp,
                            color = TextGray,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                        Text(
                            text = "•",
                            fontSize = 11.sp,
                            color = TextGray,
                            modifier = Modifier.padding(horizontal = 4.dp)
                        )
                        Text(
                            text = "Terms of Service",
                            fontSize = 11.sp,
                            color = TextGray,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }
                }
            } else {
                // Empty spacer to maintain bottom padding on other pages
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
private fun OnboardingPageContent(page: OnboardingPage) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        
        // Image Placeholder Box - Large and consistent across all pages
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    color = LightGray,
                    shape = RoundedCornerShape(16.dp)
                )
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Title - Centered
        Text(
            text = page.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = DarkGray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        
        // Description - Centered
        Text(
            text = page.description,
            fontSize = 14.sp,
            color = TextGray,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun PageIndicators(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageCount) { index ->
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(
                        color = if (index == currentPage) DarkGray else DarkGray.copy(alpha = 0.3f),
                        shape = CircleShape
                    )
                    .padding(4.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LandingScreenPreview() {
    LandingScreen()
}