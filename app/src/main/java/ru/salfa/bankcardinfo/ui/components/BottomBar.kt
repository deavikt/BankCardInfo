package ru.salfa.bankcardinfo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.salfa.bankcardinfo.R
import ru.salfa.bankcardinfo.ui.models.BottomBarItem
import ru.salfa.bankcardinfo.ui.navigation.BankCardSearch
import ru.salfa.bankcardinfo.ui.navigation.QueryHistory
import ru.salfa.bankcardinfo.ui.theme.BankCardInfoTheme
import ru.salfa.bankcardinfo.ui.theme.Purple

@Composable
fun BottomBar(navController: NavHostController) {
    val items = arrayOf(
        BottomBarItem(
            iconId = R.drawable.search_icon,
            descriptionId = R.string.bank_card_search_title,
            destination = BankCardSearch
        ),
        BottomBarItem(
            iconId = R.drawable.history_icon,
            descriptionId = R.string.query_history_title,
            destination = QueryHistory
        )
    )

    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            items.forEach { item ->
                IconButton(
                    onClick = {
                        navController.navigate(item.destination) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                ) {
                    Icon(
                        painter = painterResource(item.iconId),
                        contentDescription = stringResource(item.descriptionId),
                        tint = Purple
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun BottomBarPreview() {
    BankCardInfoTheme {
        val navController = rememberNavController()

        BottomBar(navController)
    }
}