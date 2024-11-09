package love.aespa.nemomemo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import love.aespa.nemomemo.database.entity.Memo
import love.aespa.nemomemo.di.appModule
import love.aespa.nemomemo.repository.MemoRepository
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import nemomemo.composeapp.generated.resources.Res
import nemomemo.composeapp.generated.resources.compose_multiplatform
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject
import java.util.Date

@Composable
@Preview
fun App() {
    KoinApplication(application = {
        modules(appModule())
    }) {
    val repository = koinInject<MemoRepository>()

    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        val composableScope = rememberCoroutineScope()

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                showContent = !showContent
                val memo = Memo(
                    text = "aaa",
                    createdAt = Date(),
                    updatedAd = Date()
                )
                composableScope.launch {
                    repository.insert(memo)
                    repository.getAllMemosOrderByIdAsc()
                }
            }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
    }
}