package ru.salfa.bankcardinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import ru.salfa.bankcardinfo.ui.components.BottomBar
import ru.salfa.bankcardinfo.ui.components.TopBar
import ru.salfa.bankcardinfo.ui.navigation.NavigationGraph
import ru.salfa.bankcardinfo.ui.theme.BankCardInfoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            BankCardInfoTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopBar(
                            titleId = R.string.query_history_title
                        )
                    },
                    bottomBar = {
                        BottomBar(
                            navController = navController
                        )
                    }
                ) { innerPadding ->
                    NavigationGraph(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}