package com.cw.startggevent.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.cw.startggevent.R

sealed class Destination(
    val route: String,
    @DrawableRes val icon: Int,
    @StringRes val label: Int
) {
    object Home : Destination(
        route = "home",
        icon = R.drawable.home,
        label = R.string.label_home
    )

    object Tournament : Destination(
        route = "event",
        icon = R.drawable.tournament,
        label = R.string.label_tournament
    )

    object Profile : Destination(
        route = "profile",
        icon = R.drawable.profile,
        label = R.string.label_profile
    )
}
