package com.cw.startggevent.ui.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cw.startggevent.ui.theme.StartGGEventTheme
import com.cw.startggevent.ui.theme.greenOkStatus
import com.cw.startggevent.ui.theme.redNOKStatus

@Composable
fun ChipStatus(
    isValid: Boolean,
    text: String,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (isValid) greenOkStatus else redNOKStatus
    Text(
        text = text,
        color = Color.White,
        style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .background(backgroundColor)
            .padding(5.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun ChipStatusPreview() {
    StartGGEventTheme {
        ChipStatus(
            isValid = true,
            text = "Registration closed"
        )
    }
}