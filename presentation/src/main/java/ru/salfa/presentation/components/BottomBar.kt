package ru.salfa.presentation.components

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
import ru.salfa.presentation.R
import ru.salfa.presentation.models.BottomBarItem
import ru.salfa.presentation.navigation.BankCardSearch
import ru.salfa.presentation.navigation.QueryHistory
import ru.salfa.presentation.theme.BankCardInfoTheme
import ru.salfa.presentation.theme.Purple

@Composable
fun BottomBar(
    navController: NavHostController,
    setTopBarTitleId: (topBarTitleId: Int) -> Unit
) {
    val items = arrayOf(
        BottomBarItem(
            iconId = R.drawable.search_icon,
            topBarTitleId = R.string.bank_card_search_title,
            destination = BankCardSearch
        ),
        BottomBarItem(
            iconId = R.drawable.history_icon,
            topBarTitleId = R.string.query_history_title,
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

                        setTopBarTitleId(item.topBarTitleId)
                    }
                ) {
                    Icon(
                        painter = painterResource(item.iconId),
                        contentDescription = stringResource(item.topBarTitleId),
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
        BottomBar(
            navController = rememberNavController(),
            setTopBarTitleId = { }
        )
    }
}