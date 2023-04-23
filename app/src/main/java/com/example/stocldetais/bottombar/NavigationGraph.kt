package com.example.stocldetais.bottombar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen()
        }
        composable(BottomNavItem.Clock.screen_route) {
            ClockScreen()
        }
        composable(BottomNavItem.Transaction.screen_route) {
            TransactionScreen()
        }
        composable(BottomNavItem.Candle.screen_route) {
            CandleScreen()
        }
        composable(BottomNavItem.Personal.screen_route) {
            AccountScreen()
        }
    }
}