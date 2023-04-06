package com.prcoding.hipointernassignment.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp
import com.prcoding.hipointernassignment.ui.theme.memberItemRadius

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

val Shapes.memberShape: RoundedCornerShape
    get() = RoundedCornerShape(memberItemRadius)

val Shapes.textFieldShape: RoundedCornerShape
    get() = RoundedCornerShape(memberItemRadius)