package ru.salfa.bankcardinfo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.salfa.bankcardinfo.ui.screens.BankCardSearchScreen
import ru.salfa.bankcardinfo.ui.screens.QueryHistoryScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = BankCardSearch,
        modifier = modifier
    ) {
        composable<BankCardSearch> {
            BankCardSearchScreen()
        }

        composable<QueryHistory> {
            QueryHistoryScreen()
        }
    }
}