package com.prcoding.hipointernassignment.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.prcoding.hipointernassignment.R
import com.prcoding.hipointernassignment.data.model.Hipo
import com.prcoding.hipointernassignment.data.model.Member
import com.prcoding.hipointernassignment.presentation.components.HipoTextField
import com.prcoding.hipointernassignment.presentation.components.HipoTopBar
import com.prcoding.hipointernassignment.presentation.components.MemberItem
import com.prcoding.hipointernassignment.ui.theme.buttonColor
import com.prcoding.hipointernassignment.ui.theme.mediumPadding
import java.util.*

@Composable
fun MainScreen(
    state: MainActivityState,
    onValueChange: (String) -> Unit,
    onClickMember: (Member) -> Unit,
    onClickGithubIcon:(String)->Unit
) {


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            HipoTopBar(text = stringResource(R.string.members))
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(mediumPadding)
        ) {
            Column {
                HipoTextField(
                    value = state.searchText,
                    onValueChange = onValueChange
                )
                LazyColumn {
                    items(state.members) { member ->
                        MemberItem(
                            member = member,
                            onClickGithub ={
                                onClickGithubIcon(member.github)
                            }
                        )
                    }
                }
            }

            Button(
                onClick = {
                    onClickMember(
                        Member(
                            name = "Tolga",
                            age = "22",
                            location = "Kayseri",
                            github = "tolgaprm",
                            hipo = Hipo(
                                position = "Intern",
                                yearsInHipo = "0"
                            )
                        )
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = buttonColor
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .clip(RoundedCornerShape(20.dp))
            ) {
                Text(
                    modifier = Modifier.padding(mediumPadding),
                    text = stringResource(R.string.add_new_number).uppercase(Locale.ROOT),
                    color = Color.White
                )
            }

            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }

}