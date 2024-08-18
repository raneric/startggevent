package com.cw.startggevent.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cw.startggevent.StartGGEventAppState
import com.cw.startggevent.ui.components.BottomNavigation
import com.cw.startggevent.ui.components.CollapsingTopBar
import com.cw.startggevent.ui.theme.StartGGEventTheme
import com.cw.startggevent.ui.theme.primaryContainerLight

@Composable
fun StartGGEventApp(appState: StartGGEventAppState, modifier: Modifier = Modifier) {

    val scrollState = rememberLazyListState()

    val shouldCollapseTopBar by remember {
        derivedStateOf {
            scrollState.firstVisibleItemIndex > 0
        }
    }

    Scaffold(
        topBar = {
            CollapsingTopBar(
                shouldCollapseTopBar = shouldCollapseTopBar,
                modifier = Modifier.safeContentPadding()
            )
        },
        containerColor = primaryContainerLight,
        bottomBar = {
            BottomNavigation(
                activeDestination = appState.activeDestination,
                onDestinationClicked = {
                    appState.navController.navigate(it.route)
                }
            )
        },
        modifier = modifier
    ) { paddingValues ->
        Surface(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()) {
        }
    }
}

@Preview
@Composable
private fun StartGGEventAppPreview() {
    StartGGEventTheme {}
}