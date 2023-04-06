package com.prcoding.hipointernassignment.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.prcoding.hipointernassignment.ui.theme.HipoInternAssignmentTheme
import com.prcoding.hipointernassignment.presentation.util.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HipoInternAssignmentTheme {
                val viewModel: MainActivityViewModel by viewModels()
                MainScreen(
                    state = viewModel.state.value,
                    onValueChange =  { viewModel.onSearch(it) },
                    onClickMember = {
                        viewModel.addMember(it)
                    },
                    onClickGithubIcon = {githubUserName->
                        redirectTheGithubPage(githubUserName)
                    }
                )
            }
        }
    }

    private fun redirectTheGithubPage(githubUserName: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(Constants.GITHUB_BASE_URL + githubUserName)
        }
        startActivity(intent)
    }
}
