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
import androidx.navigation.NavHostController
import com.example.quizzify.Screens.HomeScreen

class MainActivity : ComponentActivity() {

    //viewModels
    private val loginViewModel: LoginViewModel by viewModels()
    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizzifyTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(navController = navController)
                    }

                    composable("login") {
                        LoginScreen(
                            navController = navController,
                            loginViewModel = loginViewModel
                        )
                    }

                    composable("register") {
                        RegisterScreen(
                            navController = navController,
                            viewModel = registerViewModel
                        )
                    }
                }
                }
            }
        }
    }

@Preview
@Composable
fun DefaultPreview() {
    QuizzifyTheme {
        HomeScreen(navController = rememberNavController())
    }
}