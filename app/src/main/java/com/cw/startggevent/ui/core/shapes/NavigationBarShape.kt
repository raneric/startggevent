package com.cw.startggevent.ui.core.shapes

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class NavigationBarShape(
    private val fabSize: Dp,
    private val fabMargin: Dp = 24.dp
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val path = Path()
        val fabSlotSize = fabSize + fabMargin
        val roundCornerRectSize = 52.dp
        with(density) {
            val availableSize = size.width - fabSlotSize.toPx()
            val slotStart = availableSize / 2
            path.apply {
                lineTo(x = slotStart - roundCornerRectSize.toPx(), y = 0f)
                arcTo(
                    rect = Rect(
                        topLeft = Offset(
                            x = slotStart - roundCornerRectSize.toPx(),
                            y = 0f
                        ),
                        bottomRight = Offset(
                            x = slotStart,
                            y = roundCornerRectSize.toPx()
                        )
                    ),
                    startAngleDegrees = 270f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )
                arcTo(
                    rect = Rect(
                        topLeft = Offset(
                            x = slotStart,
                            y = -(fabSize / 2).toPx()
                        ),
                        bottomRight = Offset(
                            x = slotStart + fabSlotSize.toPx(),
                            y = (fabSize.toPx() / 2) + fabMargin.toPx()
                        ),
                    ),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = -180f,
                    forceMoveTo = false
                )
                arcTo(
                    rect = Rect(
                        topLeft = Offset(
                            x = slotStart + fabSlotSize.toPx(),
                            y = 0f
                        ),
                        bottomRight = Offset(
                            x = slotStart + fabSlotSize.toPx() + roundCornerRectSize.toPx(),
                            y = roundCornerRectSize.toPx()
                        )
                    ),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )
                lineTo(x = slotStart + fabSlotSize.toPx(), y = 0f)
                lineTo(x = size.width, y = 0f)
                lineTo(x = size.width, size.height)
                lineTo(x = 0f, size.height)
                close()
            }
        }

        return Outline.Generic(path)
    }
}
