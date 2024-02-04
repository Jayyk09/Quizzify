//package com.example.quizzify.Screens
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.livedata.observeAsState
//import com.example.quizzify.ViewModels.EnterCode
//import com.example.quizzify.ViewModels.EnterCodeViewState
//import androidx.compose.ui.Modifier
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.unit.dp
//import com.example.quizzify.api.Question
//import androidx.compose.ui.graphics.Color
//import androidx.compose.material3.RadioButton
//import androidx.compose.material3.Text
//import androidx.compose.runtime.rememberUpdatedState
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.ui.tooling.data.EmptyGroup.data
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.quizzify.api.apiInterface
//
//@Composable
//@OptIn(ExperimentalMaterial3Api::class)
//fun QuizScreen(enterCodeViewModel: EnterCode.EnterCodeViewModel, data : List<Question>) {
//
//    val enterCodeState by enterCodeViewModel.enterCodeState.observeAsState()
//
//    when (enterCodeState) {
//        is EnterCodeViewState.Loading -> {
//            // Show a loading indicator
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(MaterialTheme.colorScheme.background)
//            ) {
//                CircularProgressIndicator(
//                    modifier = Modifier.align(Alignment.Center)
//                )
//            }
//        }
//        is EnterCodeViewState.Success -> {
//            // Show the questions
//            QuestionList(questions = data)
//        }
//        is EnterCodeViewState.Error -> {
//            // Show an error message
//
//        }
//
//        null -> TODO()
//    }
//}
//
//@Composable
//fun QuestionList(questions: List<Question>) {
//    LazyColumn {
//        itemsIndexed(questions) { index, question ->
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                // Display the question
//                Text(
//                    text = question.property1, // Assuming property1 contains the question
//                    modifier = Modifier.fillMaxWidth()
//                )
//
//                // Display multiple-choice options
//                val options = listOf(
//                    question.property2,
//                    question.property3,
//                    question.property4,
//                    question.property5
//                )
//
//                OptionsList(options = options, correctAnswer = question.property6)
//            }
//        }
//    }
//}
//
//@Composable
//fun OptionsList(options: List<String>, correctAnswer: String) {
//    var selectedOption by remember { mutableStateOf("") }
//
//    options.forEach { option ->
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//                .clickable {
//                    selectedOption = option
//                }
//        ) {
//            RadioButton(
//                selected = option == selectedOption,
//                onClick = { selectedOption = option },
//                modifier = Modifier
//                    .padding(end = 8.dp)
//            )
//
//            Text(text = option)
//        }
//    }
//
//    // Display feedback based on selected option
//    if (selectedOption.isNotEmpty()) {
//        val feedbackColor = if (selectedOption == correctAnswer) Color.Green else Color.Red
//        Text(
//            text = if (selectedOption == correctAnswer) "Correct!" else "Incorrect!",
//            color = feedbackColor,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        )
//    }
//}
//
//@Preview
//@Composable
//fun QuizScreenPreview() {
//    val enterCodeViewModel = EnterCode.EnterCodeViewModel(
//    myAPI = apiInterface)
//    QuizScreen(enterCodeViewModel, dummyQuestions)
//}
//
//
