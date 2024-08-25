package com.cw.startggevent.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.cw.startggevent.R
import com.cw.startggevent.ui.core.ui.CardIconText
import com.cw.startggevent.ui.core.ui.ChipStatus
import com.cw.startggevent.ui.theme.StartGGEventTheme

@Composable
fun TournamentCard(modifier: Modifier = Modifier) {
    val cardOffsetModifier = Modifier.offset(x = 8.dp)

    Card(modifier = modifier.width(280.dp),
         colors = CardDefaults.cardColors()
             .copy(
                 containerColor = MaterialTheme
                     .colorScheme
                     .onPrimary
             ),
         shape = MaterialTheme.shapes.small,
         onClick = { /*TODO*/ }) {

        Column {

            Box {
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.test_card),
                    contentDescription = ""
                )
                ChipStatus(
                    isValid = true,
                    text = "Registration open",
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .offset(x = 5.dp, y = (-5).dp)
                )
            }

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = "East Coast Throwdown 2024",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.then(cardOffsetModifier)
            )
            Text(
                text = "Capcom vs SNK 2",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.then(cardOffsetModifier)
            )

            Spacer(modifier = Modifier.size(16.dp))

            CardIconText(
                text = "October 11th 2024",
                icon = painterResource(id = R.drawable.event_24px),
                modifier = Modifier.then(cardOffsetModifier)
            )
            CardIconText(
                text = "Antananrivo",
                icon = painterResource(id = R.drawable.location_on_24px),
                modifier = Modifier.then(cardOffsetModifier)
            )
            CardIconText(
                text = "212 Attendes",
                icon = painterResource(id = R.drawable.person_24px),
                modifier = Modifier.then(cardOffsetModifier)
            )

            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}

@PreviewLightDark
@Composable
private fun TournamentCardPreview() {
    StartGGEventTheme {
        TournamentCard()
    }
}
