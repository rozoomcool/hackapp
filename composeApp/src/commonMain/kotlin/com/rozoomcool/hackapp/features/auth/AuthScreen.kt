package com.rozoomcool.hackapp.features.auth

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.dokar.sonner.rememberToasterState
import kotlinx.coroutines.launch
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

private val screens = listOf<String>("Регистрация", "Авторизация")

object AuthScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<AuthScreenModel>()
        AuthScreenContent(screenModel)
    }
}

@Composable
private fun AuthScreenContent(screenModel: AuthScreenModel) {
    val uiState by screenModel.state.collectAsState()
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val toaster = rememberToasterState {}
    val scope = rememberCoroutineScope()

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
                    modifier = Modifier.fillMaxHeight(0.3f),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Dekit", style = typography.displaySmall)
                    Spacer(modifier = Modifier.height(48.dp))
                    AuthBar(selectedTabIndex) { index -> selectedTabIndex = index }
                }
                Spacer(modifier = Modifier.height(32.dp))
                Box(
                    modifier = Modifier.fillMaxHeight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    when (screens[selectedTabIndex]) {
                        screens[0] -> {
                            Column(
                                modifier = Modifier.animateContentSize().fillMaxHeight(),
                                verticalArrangement = Arrangement.spacedBy(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                OutlinedTextField(
                                    label = { Text(text = "Логин") },
                                    value = uiState.username,
                                    onValueChange = { value -> screenModel.changeUsername(value) },
                                    maxLines = 1,
                                    isError = uiState.isUsernameError,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                OutlinedTextField(
                                    label = { Text(text = "Почта") },
                                    value = uiState.email,
                                    onValueChange = { value -> screenModel.changeEmail(value) },
                                    maxLines = 1,
                                    isError = uiState.isEmailError,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                OutlinedTextField(
                                    label = { Text(text = "Пароль") },
                                    value = uiState.password,
                                    onValueChange = { value -> screenModel.changePassword(value) },
                                    isError = uiState.isPasswordError,
                                    visualTransformation = PasswordVisualTransformation(),
                                    maxLines = 1,
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Password,
                                        imeAction = ImeAction.Done
                                    ),
                                    shape = RoundedCornerShape(12.dp)
                                )
                                Button(onClick = {
                                    screenModel.signUp()
                                }) {
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
                                    value = uiState.username,
                                    onValueChange = { value -> screenModel.changeUsername(value) },
                                    maxLines = 1,
                                    isError = uiState.isUsernameError,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                OutlinedTextField(
                                    label = { Text(text = "Пароль") },
                                    value = uiState.password,
                                    onValueChange = { value -> screenModel.changePassword(value) },
                                    isError = uiState.isPasswordError,
                                    visualTransformation = PasswordVisualTransformation(),
                                    maxLines = 1,
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Password,
                                        imeAction = ImeAction.Done
                                    ),
                                    shape = RoundedCornerShape(12.dp)
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
        containerColor = colorScheme.surface,
        selectedTabIndex = 1,
        divider = {},
        indicator = { tabPositions ->
            if (selectedTabIndex < tabPositions.size) {
                TabRowDefaults.PrimaryIndicator(
                    Modifier.fillMaxWidth().tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = colorScheme.primary
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
                    style = typography.titleLarge
                )
            }
        }
    }
}