package com.example.stocldetais.bottombar

import com.example.stocldetais.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {
    object Home : BottomNavItem("Home", R.drawable.ic_home, "home")
    object Clock : BottomNavItem("Home", R.drawable.ic_clock, "clock")
    object Transaction : BottomNavItem("Transaction", R.drawable.ic_tow_arraow, "transaction")
    object Candle : BottomNavItem("Home", R.drawable.ic_candle, "candle")
    object Personal : BottomNavItem("Home", R.drawable.ic_person, "person")
}
