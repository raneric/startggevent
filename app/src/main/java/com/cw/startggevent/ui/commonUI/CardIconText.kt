package com.cw.startggevent.ui.commonUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cw.startggevent.R
import com.cw.startggevent.ui.theme.StartGGEventTheme

@Composable
fun CardIconText(
    text: String,
    icon: Painter, modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        Icon(
            painter = icon,
            contentDescription = "",
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = text, style =
            MaterialTheme.typography.bodyMedium
        )
    }
}


@Preview
@Composable
private fun CardIconTextPreview() {
    StartGGEventTheme {
        CardIconText(
            text = "Antananarivo",
            icon = painterResource(id = R.drawable.location_on_24px)
        )
    }
}