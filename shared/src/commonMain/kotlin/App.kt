import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun App() {
    MaterialTheme {

        Scaffold(topBar = {
            TopAppBar(title = {
                Text(
                    text = "My First App on IOS Android",
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.width(250.dp).basicMarquee(
                    )
                ) },
                navigationIcon = {
                    Icon(Icons.Default.Home, "", modifier = Modifier.padding(10.dp))
                }
            )
        }) {


            Box(modifier = Modifier.padding(it).fillMaxWidth()) {
                LazyColumn {

                    items(count = 100) {
                        Card(modifier = Modifier.padding(10.dp).fillMaxSize()) {
                            Text(text = "item no is $it", modifier = Modifier.padding(10.dp))
                        }
                    }
                }
                // ShowTextAnimation()
            }
        }


    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ShowTextAnimation() {
    var greetingText by remember { mutableStateOf("Hello, World!") }
    var showImage by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            greetingText = "Hello, ${getPlatformName()}"
            showImage = !showImage
        }) {
            Text(greetingText)
        }
        AnimatedVisibility(showImage) {
            Image(
                painterResource("compose-multiplatform.xml"),
                null
            )
        }
    }
}

expect fun getPlatformName(): String