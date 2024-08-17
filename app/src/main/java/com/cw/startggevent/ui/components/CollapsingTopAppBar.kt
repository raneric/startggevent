package com.cw.startggevent.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cw.startggevent.ui.theme.StartGGEventTheme

@Composable
fun CollapsingTopAppBar(modifier: Modifier = Modifier) {
    Box(modifier = modifier.background(MaterialTheme.colorScheme.primaryContainer)) {

    }
}


@Preview(showBackground = true)
@Composable
private fun CollapsingTopAppBarPreview(modifier: Modifier = Modifier) {
    StartGGEventTheme {
        CollapsingTopAppBar()
    }
}

enum class CollapsingState {
    EXPANDED, COLLAPSED
}