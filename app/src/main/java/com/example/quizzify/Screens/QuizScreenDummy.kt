package com.example.quizzify.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizzify.api.Question

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun QuizScreen(data : List<Question>) {

    //scaffold to display the questions
    Column {
        QuestionList(questions = data)
    }
}

@Composable
fun QuestionList(questions: List<Question>) {
    var score : Int by remember { mutableStateOf(0) }
    LazyColumn(
        //make it scrollable so that all questions can be viewed
        modifier = Modifier
            .fillMaxSize()

    ) {
        itemsIndexed(questions) { index, question ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // Display the question
                Text(
                    text = question.property1, // Assuming property1 contains the question
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.titleMedium
                )

                // Display multiple-choice options
                val options = listOf(
                    question.property2,
                    question.property3,
                    question.property4,
                    question.property5
                )

                OptionsList(options = options, correctAnswer = question.property6, onAnswerSelected = { isCorrect ->
                    // Handle answer selected
                    if (isCorrect) {
                        score++
                    }
                })
            }
        }
    }
}

@Composable
fun OptionsList(options: List<String>, correctAnswer: String, onAnswerSelected: (Boolean) -> Unit) {
    var selectedOption by remember { mutableStateOf("") }

    options.forEach { option ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable {
                    if (selectedOption.isEmpty()) {
                        selectedOption = option
                        onAnswerSelected(option == correctAnswer)
                    }
                }
        ) {
            RadioButton(
                selected = option == selectedOption,
                onClick = {
                    // RadioButton click handled by the Row click
                    if (selectedOption.isEmpty()) {
                        selectedOption = option
                        onAnswerSelected(option == correctAnswer)
                    }
                },
                modifier = Modifier
                    .padding(end = 8.dp)
            )

            Text(text = option)
        }
    }

    // Display feedback based on selected option
    if (selectedOption.isNotEmpty()) {
        Text(
            text = if (selectedOption == correctAnswer) "Correct!" else "Incorrect! The correct answer is $correctAnswer",
            color = if (selectedOption == correctAnswer) Color.Green else Color.Red,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}



@Preview
@Composable
fun QuizScreenPreview() {
    QuizScreen(dummyQuestions)
}