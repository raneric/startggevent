package com.cw.startggevent

import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun rememberStartGGEventAppState(
    windowWidthSizeClass: WindowWidthSizeClass,
    snackbarHostState: SnackbarHostState = SnackbarHostState(),
    navController: NavHostController = rememberNavController()
) =
    remember(navController, windowWidthSizeClass) {
        StartGGEventAppState(
            navController = navController,
            snackbarHostState = snackbarHostState,
            windowWidthSizeClass = windowWidthSizeClass
        )
    }

@Stable
class StartGGEventAppState(
    val navController: NavHostController,
    val windowWidthSizeClass: WindowWidthSizeClass,
    val snackbarHostState: SnackbarHostState,
) {
}