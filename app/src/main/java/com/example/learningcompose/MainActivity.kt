package com.example.learningcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningcompose.ui.theme.LearningcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningcomposeTheme {
                MyApp(
                    names = listOf(
                        "최베르",
                        "최성훈",
                        "베르최",
                        "최베르",
                        "최성훈",
                        "베르최",
                        "최베르",
                        "최성훈",
                        "베르최",
                        "최베르",
                        "최성훈",
                        "베르최",
                        "최베르",
                        "최성훈",
                        "베르최",
                    ),
                )
            }
        }
    }
}

@Composable
private fun MyApp(modifier: Modifier = Modifier, names: List<String> = listOf()) {
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name = (name))
        }
    }
}

@Composable
fun Greeting(name: String) {
    val expended = remember { mutableStateOf(false) }
    val extraPadding = if (expended.value) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding),
            ) {
                Text(text = "Hello,  ")
                Text(text = "$name!")
            }
            ElevatedButton(
                onClick = { expended.value = !expended.value },
            ) {
                Text(if (expended.value) "접기!" else "펼치기")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    LearningcomposeTheme {
        MyApp(Modifier, listOf("최베르", "최성훈", "베르최", "최베르", "최성훈", "베르최", "최베르", "최성훈", "베르최"))
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    LearningcomposeTheme {
        Greeting("최성훈")
    }
}
