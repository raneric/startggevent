package com.cw.startggevent.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cw.startggevent.ui.core.shapes.NavigationBarShape
import com.cw.startggevent.ui.theme.StartGGEventTheme
import com.cw.startggevent.utils.Destination

@Composable
fun BottomNavigation(
    activeDestination: Destination,
    onDestinationClicked: (Destination) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
            .clip(
                NavigationBarShape(
                    fabSize = 80.dp
                )
            )
    ) {
        bottomNavItemList.forEach { destination ->
            NavigationBarItem(
                selected = destination == activeDestination,
                onClick = { onDestinationClicked(destination) },
                icon = {
                    Icon(
                        painter = painterResource(id = destination.icon),
                        contentDescription = ""
                    )
                },
                label = {
                    Text(text = stringResource(id = destination.label))
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StartGGBottomNavPreview() {
    StartGGEventTheme {
        BottomNavigation(
            activeDestination = Destination.Tournament,
            onDestinationClicked = {})
    }
}


private val bottomNavItemList = listOf(
    Destination.Tournament,
    Destination.Profile
)