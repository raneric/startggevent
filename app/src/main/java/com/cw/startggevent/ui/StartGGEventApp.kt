package com.cw.startggevent.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cw.startggevent.R
import com.cw.startggevent.StartGGEventAppState
import com.cw.startggevent.ui.components.BottomNavigation
import com.cw.startggevent.ui.components.CollapsingTopBar
import com.cw.startggevent.ui.components.TournamentCard
import com.cw.startggevent.ui.theme.StartGGEventTheme
import com.cw.startggevent.ui.theme.fabAccentColor
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
        floatingActionButton = {
            LargeFloatingActionButton(
                onClick = { /*TODO*/ },
                shape = CircleShape,
                containerColor = fabAccentColor,
                modifier = Modifier.offset(y = 72.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.search_24px),
                    contentDescription = ""
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
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
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
            ) {
                items(8) {
                    TournamentCard()
                }
            }
        }
    }
}

@Preview
@Composable
private fun StartGGEventAppPreview() {
    StartGGEventTheme {}
}