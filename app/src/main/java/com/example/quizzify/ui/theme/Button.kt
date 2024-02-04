package com.example.quizzify.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Define the gradient
val buttonGradient = Brush.linearGradient(
    listOf(Color(0xFF30885B), Color(0xFF2A58A2))
)

@Composable
fun GradientButton(text: String, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(buttonGradient) // Apply the gradient as the background of the Box
            .clickable(onClick = onClick)
            .padding(PaddingValues(16.dp)) // Add padding to size the button
    ) {
        Text(
            text = text,
            style = typography.bodyLarge,
            color = Color.White,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GradientButtonPreview() {
    Surface {
        GradientButton(text = "Click Me", onClick = {})
    }
}
