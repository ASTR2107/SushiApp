package com.example.sushidelevery.view.data

import android.graphics.Path
import androidx.compose.ui.geometry.Offset
import java.lang.Math.abs


fun Path.standardQuadFromTo(from: Offset, to: Offset ) {
    quadratic(from.x, from.y, abs(from.x + to.x) / 2f, abs(from.y + to.y) / 2f)
}

private fun Path.quadratic(x: Float, y: Float, fl: Float, fl1: Float) {


}
