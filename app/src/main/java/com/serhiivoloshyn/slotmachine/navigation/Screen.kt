package com.serhiivoloshyn.slotmachine.navigation

sealed class Screen(val route: String) {
    object Splash : Screen(route = "splash_screen")
    object Menu : Screen(route = "menu_screen")
    object SlotMachine : Screen(route = "slotMachine_screen")
}
