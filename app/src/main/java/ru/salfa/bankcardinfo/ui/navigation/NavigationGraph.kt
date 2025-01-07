package ru.salfa.bankcardinfo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.salfa.bankcardinfo.ui.screens.BINInfoSearchScreen
import ru.salfa.bankcardinfo.ui.screens.BINQueryHistoryScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = BINInfoSearch,
        modifier = modifier
    ) {
        composable<BINInfoSearch> {
            BINInfoSearchScreen()
        }

        composable<BINQueryHistory> {
            BINQueryHistoryScreen()
        }
    }
}