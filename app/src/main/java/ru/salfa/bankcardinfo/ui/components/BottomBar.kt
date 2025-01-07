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
import ru.salfa.bankcardinfo.ui.models.BottomBarItems
import ru.salfa.bankcardinfo.ui.theme.BankCardInfoTheme
import ru.salfa.bankcardinfo.ui.theme.Purple

@Composable
fun BottomBar() {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            BottomBarItems.entries.forEach { item ->
                IconButton(
                    onClick = { }
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
       BottomBar()
    }
}