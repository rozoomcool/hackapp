package com.rozoomcool.hackapp.features.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel

private val screens = listOf<String>("Регистрация", "Авторизация")

object AuthScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<AuthScreenModel>()
        AuthScreenContent(screenModel)
    }
}

@Composable
fun AuthScreenContent(screenModel: AuthScreenModel) {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(0.4f),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(text = "Dekit", style = MaterialTheme.typography.h2)
                    Spacer(modifier = Modifier.height(48.dp))
                    AuthBar(selectedTabIndex) { index -> selectedTabIndex = index }
                }
                Spacer(modifier = Modifier.height(32.dp))
                Box(
                    modifier = Modifier.fillMaxHeight(1f),
                    contentAlignment = Alignment.Center
                ){
                    when (screens[selectedTabIndex]) {
                        screens[0] -> {
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.spacedBy(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                OutlinedTextField(
                                    label = { Text(text = "Логин") },
                                    value = "",
                                    onValueChange = {}
                                )
                                OutlinedTextField(
                                    label = { Text(text = "Почта") },
                                    value = "",
                                    onValueChange = {}
                                )
                                OutlinedTextField(
                                    label = { Text(text = "Пароль") },
                                    value = "",
                                    onValueChange = {}
                                )
                                Button(onClick = { /*TODO*/ }) {
                                    Text("Зарегистрироваться")
                                }
                            }
                        }

                        screens[1] -> {
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.spacedBy(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                OutlinedTextField(
                                    label = { Text(text = "Логин") },
                                    value = "",
                                    onValueChange = {}
                                )
                                OutlinedTextField(
                                    label = { Text(text = "Пароль") },
                                    value = "",
                                    onValueChange = {}
                                )
                                Button(onClick = { /*TODO*/ }) {
                                    Text("Авторизация")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun AuthBar(selectedTabIndex: Int, onTabClick: (index: Int) -> Unit) {
    TabRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        backgroundColor = MaterialTheme.colors.background,
        selectedTabIndex = 1,
        divider = {},
        indicator = { tabPositions ->
            if (selectedTabIndex < tabPositions.size) {
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                )
            }
        }
    ) {
        screens.forEachIndexed { i, value ->
            Tab(
                selected = i == selectedTabIndex,
                onClick = { onTabClick(i) }) {
                Text(
                    text = value,
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}