package com.serhiivoloshyn.slotmachine.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.serhiivoloshyn.slotmachine.R
import com.serhiivoloshyn.slotmachine.navigation.Screen
import com.serhiivoloshyn.slotmachine.ui.theme.SlotMachineAppTheme
import com.serhiivoloshyn.slotmachine.ui.theme.baseFontFamily
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    val infiniteTransition = rememberInfiniteTransition()

    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        )
    )

    LaunchedEffect(key1 = true) {
        delay(5000L)
        navController.navigate(Screen.Menu.route) {
            popUpTo(Screen.Splash.route) {
                inclusive = true
            }
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.item0),
                contentDescription = "SplashScreenLogo",
                modifier = Modifier
                    .size(200.dp)
                    .scale(scale)
            )

            Text(
                text = stringResource(id = R.string.loading),
                modifier = Modifier.padding(top = 20.dp),
                fontFamily = baseFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 30.sp,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SlotMachineAppTheme {
        val navController = rememberNavController()
        SplashScreen(navController)
    }
}