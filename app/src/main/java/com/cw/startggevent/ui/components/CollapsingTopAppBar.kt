package com.cw.startggevent.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cw.startggevent.R
import com.cw.startggevent.ui.theme.primaryContainerLight

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun CollapsingTopAppBar(appBarState: CollapsingState, modifier: Modifier = Modifier) {

    SharedTransitionLayout(modifier) {
        AnimatedContent(targetState = appBarState, label = "top bar animation") {
            when (it) {
                CollapsingState.EXPANDED  -> {
                    ExpandedTopAppBar(
                        sharedTransitionScope = this@SharedTransitionLayout,
                        animatedVisibilityScope = this@AnimatedContent
                    )
                }

                CollapsingState.COLLAPSED -> {
                    CollapsedTopAppBar(
                        sharedTransitionScope = this@SharedTransitionLayout,
                        animatedVisibilityScope = this@AnimatedContent
                    )
                }
            }
        }
    }


}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun CollapsedTopAppBar(
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    modifier: Modifier = Modifier
) {
    with(sharedTransitionScope) {
        Box(
            modifier = modifier
                .background(primaryContainerLight)
                .height(56.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Image(
                modifier = Modifier.sharedElement(
                    state = rememberSharedContentState(key = "logo"),
                    animatedVisibilityScope = animatedVisibilityScope
                ),
                painter = painterResource(id = R.drawable.small_logo),
                contentDescription = null
            )
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ExpandedTopAppBar(
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    modifier: Modifier = Modifier
) {
    with(sharedTransitionScope) {
        Box(
            modifier = modifier
                .background(primaryContainerLight)
                .height(260.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.sharedElement(
                    state = rememberSharedContentState(key = "logo"),
                    animatedVisibilityScope = animatedVisibilityScope
                ),
                painter = painterResource(id = R.drawable.big_logo),
                contentDescription = null
            )
        }
    }

}


enum class CollapsingState {
    EXPANDED, COLLAPSED
}