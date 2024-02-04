package com.example.quizzify

//material theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizzify.Screens.EnterCode
import com.example.quizzify.Screens.HomeScreen
import com.example.quizzify.Screens.LoginScreen
import com.example.quizzify.Screens.QuizScreen
import com.example.quizzify.Screens.RegisterScreen
import com.example.quizzify.Screens.dummyQuestions
import com.example.quizzify.ViewModels.LoginViewModel
import com.example.quizzify.ViewModels.RegisterViewModel
import com.example.quizzify.ui.theme.QuizzifyTheme


class MainActivity : ComponentActivity() {

//    val apiService: apiInterface = apiInterface.create("YOUR_BASE_URL")

    private val loginViewModel : LoginViewModel by viewModels()
    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizzifyTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "entercode") {
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

                    composable("entercode") {
                        EnterCode(navController = navController)
                    }

                    // Add a composable for the quiz screen
                     composable("quizscreendummy") {
                         QuizScreen(data = dummyQuestions)
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