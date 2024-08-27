package org.kingfu.portfolio.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.kingfu.imaginate.ui.theme.TextBodyMedium
import org.kingfu.portfolio.ui.theme.ThemeType
import org.kingfu.portfolio.navigation.Screen
import org.kingfu.portfolio.settings.component.Theme
import org.kingfu.portfolio.topBar.BackTopBar
import kotlin.reflect.KFunction1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    goBack: () -> Unit,
    theme: ThemeType,
    setTheme: (ThemeType) -> Unit,
    isShowDialogTheme: Boolean,
    setIsShowDialogTheme: KFunction1<Boolean, Unit>
) {

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier.nestedScroll(connection = scrollBehavior.nestedScrollConnection),
        topBar = {
            BackTopBar(
                title = Screen.Settings.name,
                goBack = goBack,
                scrollBehavior = scrollBehavior,
                containerColor = colorScheme.surface
            )
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(state = scrollState)
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = CenterHorizontally
        ){
            TextBodyMedium(
                text = "App",
                modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxWidth()
            )

            Theme(
                theme = theme,
                setTheme = setTheme,
                isShowDialog = isShowDialogTheme,
                setIsShowDialog = setIsShowDialogTheme
            )

            Spacer(modifier = Modifier.height(height = 3000.dp))
        }
    }
}