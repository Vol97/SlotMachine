package com.serhiivoloshyn.slotmachine.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.serhiivoloshyn.slotmachine.ui.screens.MenuScreen
import com.serhiivoloshyn.slotmachine.ui.screens.SlotMachineScreen
import com.serhiivoloshyn.slotmachine.ui.screens.SplashScreen

@Composable
fun SetupNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Menu.route){
            MenuScreen(navController = navController)
        }
        composable(route = Screen.SlotMachine.route) {
            SlotMachineScreen()
        }
    }
}