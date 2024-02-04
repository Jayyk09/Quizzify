package com.example.quizzify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quizzify.Screens.LoginScreen
import com.example.quizzify.Screens.RegisterScreen
import com.example.quizzify.ui.theme.QuizzifyTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import com.example.quizzify.ViewModels.LoginViewModel
import com.example.quizzify.ViewModels.RegisterViewModel
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
//material theme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    //viewModels
    private val loginViewModel: LoginViewModel by viewModels()
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizzifyTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        LoginScreen( //passing the viewModels to the composable
                            onLogin = { email, password ->
                                loginViewModel.loginUser(email, password)
                            },
                            navController = navController
                        )

                    }
                    composable("register") {
                        RegisterScreen(
                            onRegister = { name, email, password ->
                                viewModel.registerUser(name, email, password)
                            },
                            navController = navController
                        )
                    }

                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Welcome to Quizzify!",
                            modifier = Modifier.padding(bottom = 16.dp),
                            style = MaterialTheme.typography.titleMedium
                        )

                        // For example, you can add a button to navigate to the registration screen
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Button(
                                onClick = { navController.navigate("register") },
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Text("Register")
                            }

                            Button(onClick = { navController.navigate("login") }) {
                                Text("Login")
                            }

                        }

                        }
                    }
                }
            }
        }
    }

@Preview
@Composable
fun MainActivityPreview() {
    QuizzifyTheme {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "login") {
            composable("login") {
                val loginViewModel: LoginViewModel = LoginViewModel()
                LoginScreen(
                    onLogin = { email, password ->
                        loginViewModel.loginUser(email, password)
                    },
                    navController = navController
                )
            }
            composable("register") {
                val viewModel: RegisterViewModel = RegisterViewModel()
                RegisterScreen(
                    onRegister = { name, email, password ->
                        viewModel.registerUser(name, email, password)
                    },
                    navController = navController
                )
            }
        }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Welcome to Quizzify!",
                    modifier = Modifier.padding(bottom = 16.dp),
                    style = MaterialTheme.typography.titleLarge
                )

                // For example, you can add a button to navigate to the registration screen
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { /* Handle button click */ },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text("Register")
                    }

                    Button(onClick = { /* Handle button click */ }) {
                        Text("Login")
                    }
                }
            }
        }
    }
}