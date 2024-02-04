package com.example.quizzify.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.quizzify.ui.theme.GradientButton
import com.example.quizzify.ui.theme.buttonGradient


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeScreen (
    navController: NavHostController
) {
    // HomeScreen UI
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
                modifier = Modifier.padding(bottom = 36.dp),
                style = MaterialTheme.typography.titleLarge
            )
            GradientButton(text = "Register", onClick = { navController.navigate("register") })
            Spacer(modifier = Modifier.padding(8.dp))
            GradientButton(text = "Login", onClick = { navController.navigate("login") })

            // For example, you can add a button to navigate to the registration screen
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
            }

        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    // HomeScreen UI
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
                modifier = Modifier.padding(bottom = 36.dp),
                style = MaterialTheme.typography.titleLarge
            )
            GradientButton(text = "Login", onClick = {})
            Spacer(modifier = Modifier.padding(8.dp))
            GradientButton(text = "Register", onClick = {})

            // For example, you can add a button to navigate to the registration screen
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
            }

        }
    }
}
