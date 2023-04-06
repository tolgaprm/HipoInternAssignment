package com.prcoding.hipointernassignment.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.prcoding.hipointernassignment.R
import com.prcoding.hipointernassignment.data.model.Member
import com.prcoding.hipointernassignment.ui.theme.*

@Composable
fun MemberItem(
    member: Member,
    onClickGithub:()->Unit
) {
    Box(
        modifier = Modifier
            .padding(smallPadding)
            .fillMaxWidth()
            .clip(Shapes.memberShape)
            .background(Color.White)
            .border(
                width = 1.dp,
                shape = Shapes.memberShape,
                color = Color.Black.copy(alpha = 0.4f)
            )
            .padding(mediumPadding)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = member.name,
                    color = Color.Black,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = member.hipo.position,
                    color = Color.Black,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .padding(top = smallPadding)
                )
            }

            Image(
                painter = painterResource(id = R.drawable.github),
                contentDescription = null,
                modifier = Modifier
                    .size(iconSize)
                    .clickable { onClickGithub() }

            )
        }
    }
}