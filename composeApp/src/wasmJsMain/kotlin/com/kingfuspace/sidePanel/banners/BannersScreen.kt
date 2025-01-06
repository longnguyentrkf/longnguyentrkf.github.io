package com.kingfuspace.sidePanel.banners

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.kingfuspace.main.editor.state.Banner
import com.kingfuspace.main.ui.theme.Typography
import com.kingfuspace.sidePanel.navigation.SidePanelDestination
import com.kingfuspace.sidePanel.ui.components.menu.BannerMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BannersScreen(
    modifier: Modifier = Modifier,
    banners: MutableList<Banner>,
    goToBanner: () -> Unit,
    addBanner: () -> Unit,
    setBannerIndex: (Int?) -> Unit,
    goBack: () -> Boolean,
    lazyListState: LazyListState,
    goToDialogConfirm: () -> Unit,
    goToDialogEditText: () -> Unit,
) {
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
                title = {
                    Text(
                        text = SidePanelDestination.BANNERS.label,
                        style = Typography.bodySmall
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { goBack() }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.ChevronLeft,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(modifier = modifier.padding(paddingValues = paddingValues)) {
            items(count = banners.size) { index ->
                Box(contentAlignment = Alignment.CenterEnd) {
                    Text(
                        modifier = Modifier
                            .clickable {
                                scope.launch {
                                    setBannerIndex(index)
                                    lazyListState.scrollToItem(index = index)
                                    goToBanner()
                                }
                            }
                            .padding(all = 16.dp)
                            .fillMaxWidth()
                            .padding(end = 24.dp),
                        text = banners[index].name,
                        style = Typography.bodySmall
                    )

                    BannerMenu(
                        onClick = { setBannerIndex(index) },
                        onDelete = goToDialogConfirm,
                        onEditName = goToDialogEditText
                    )
                }
            }

            item {
                Icon(
                    modifier = Modifier
                        .clickable { addBanner() }
                        .fillMaxWidth()
                        .padding(all = 16.dp),
                    imageVector = Icons.Rounded.Add,
                    contentDescription = null
                )
            }
        }
    }
}


