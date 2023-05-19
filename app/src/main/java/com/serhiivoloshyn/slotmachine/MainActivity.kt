package com.serhiivoloshyn.slotmachine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.serhiivoloshyn.slotmachine.navigation.SetupNavGraph
import com.serhiivoloshyn.slotmachine.ui.theme.SlotMachineAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SlotMachineAppTheme {
                SetupNavGraph()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SlotMachineAppTheme {
        SetupNavGraph()
    }
}