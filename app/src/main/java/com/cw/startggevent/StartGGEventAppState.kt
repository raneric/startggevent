package com.cw.startggevent

import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cw.startggevent.utils.Destination


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
    val activeDestination
        @Composable get() = navController.currentDestination?.activeItem ?: Destination.Tournament
}

val NavDestination.activeItem: Destination
    get() {
        return when (route) {
            Destination.Profile.route -> Destination.Profile
            else                      -> Destination.Tournament
        }
    }