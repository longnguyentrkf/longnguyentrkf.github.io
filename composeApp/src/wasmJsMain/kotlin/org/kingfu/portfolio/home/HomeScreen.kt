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
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.kingfu.portfolio.ui.theme.Shape
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
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()


    Scaffold(
        modifier = Modifier.nestedScroll(connection = scrollBehavior.nestedScrollConnection),
        topBar = {
            MenuTopBar(
                title = Screen.Home.name,
                toggleDrawer = toggleDrawer,
                scrollBehavior = scrollBehavior
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
                val fontSize = 36.sp
                val lineHeight = 48.sp
                val shape = Shape.medium
                val scale = 0.7f

                if (maxWidth <= 700.dp) {
                    Column(
                        modifier = Modifier
                            .height(intrinsicSize = IntrinsicSize.Max)
                            .fillMaxWidth()
                    ) {
                        Image(
                            modifier = Modifier
                                .scale(scale  = scale)
                                .clip(shape = shape)
                            ,
                            painter = painterResource(Res.drawable.longnguyen),
                            contentDescription = null
                        )

                        TextBodyLarge(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = text,
                            textAlign = TextAlign.Center,
                            fontSize = fontSize,
                            lineHeight = lineHeight
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
                                .scale(scale  = scale)
                                .weight(weight = 0.5f)
                                .clip(shape = shape)
                            ,
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
                            fontSize = fontSize,
                            lineHeight = lineHeight
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.height(height = 1500.dp))
        }


    }
}

