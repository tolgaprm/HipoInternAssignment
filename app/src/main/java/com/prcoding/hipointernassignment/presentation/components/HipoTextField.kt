package com.prcoding.hipointernassignment.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.prcoding.hipointernassignment.R
import com.prcoding.hipointernassignment.ui.theme.Shapes
import com.prcoding.hipointernassignment.ui.theme.textFieldShape

@Composable
fun HipoTextField(
    value:String,
    onValueChange:(String)->Unit
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(Shapes.textFieldShape)
            .border(
                width = 1.dp,
                shape = Shapes.textFieldShape,
                color = Color.Black
            ),
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.LightGray
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.search),
                style = MaterialTheme.typography.body1
            )
        }
    )
}