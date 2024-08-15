package com.cw.startggevent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.cw.startggevent.ui.StartGGEventApp
import com.cw.startggevent.ui.theme.StartGGEventTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val windowSizeClass = calculateWindowSizeClass(activity = this)
            val appState =
                rememberStartGGEventAppState(windowWidthSizeClass = windowSizeClass.widthSizeClass)
            StartGGEventTheme {
                StartGGEventApp(appState = appState)
            }
        }
    }
}
