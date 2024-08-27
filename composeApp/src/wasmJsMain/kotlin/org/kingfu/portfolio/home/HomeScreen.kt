package org.kingfu.portfolio.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kingfu.imaginate.ui.theme.TextBodyLarge
import org.jetbrains.compose.resources.painterResource
import org.kingfu.portfolio.navigation.Screen
import org.kingfu.portfolio.topBar.MenuTopBar
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.longnguyen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    toggleDrawer: () -> Unit
) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            MenuTopBar(
                title = Screen.Home.name,
                toggleDrawer = toggleDrawer
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(state = scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                propagateMinConstraints = true
            ) {
                val maxWidth = this.maxWidth
                val text = "Hi, my name is Long Nguyen. I am a Software Engineer based in Anaheim, California"

                if (maxWidth <= 600.dp) {
                    Column(
                        modifier = Modifier
                            .height(intrinsicSize = IntrinsicSize.Max)
                            .fillMaxWidth()
                    ) {
                        Image(
                            modifier = Modifier
                                .height(height = 400.dp),
                            painter = painterResource(Res.drawable.longnguyen),
                            contentDescription = null
                        )

                        TextBodyLarge(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = text,
                            textAlign = TextAlign.Center,
                            fontSize = 36.sp,
                            lineHeight = 48.sp
                        )
                    }
                } else {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier
                                .height(height = 500.dp)
                                .weight(weight = 0.5f),
                            painter = painterResource(Res.drawable.longnguyen),
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(width = 16.dp))

                        TextBodyLarge(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(weight = 0.5f),
                            text = text,
                            textAlign = TextAlign.Center,
                            fontSize = 36.sp,
                            lineHeight = 48.sp
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.height(height = 500.dp))
        }


    }
}

