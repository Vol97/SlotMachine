package com.serhiivoloshyn.slotmachine.ui.screens

import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.serhiivoloshyn.slotmachine.R
import com.serhiivoloshyn.slotmachine.navigation.Screen
import com.serhiivoloshyn.slotmachine.ui.theme.DarkGreen
import com.serhiivoloshyn.slotmachine.ui.theme.baseFontFamily

@Composable
fun MenuScreen(navController: NavHostController) {
    val activity = LocalContext.current as? Activity

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds
        )

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            BaseButton(
                text = stringResource(id = R.string.play),
                onClick = { navController.navigate(Screen.SlotMachine.route) }
            )

            Spacer(modifier = Modifier.size(40.dp))

            BaseButton(
                text = stringResource(id = R.string.exit),
                onClick = { activity?.finish() }
            )
        }
    }
}

@Composable
fun BaseButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(5.dp, Color.LightGray),
        colors = ButtonDefaults.buttonColors(containerColor = DarkGreen)
    ) {
        Text(
            text = text,
            fontFamily = baseFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 30.sp
        )
    }
}