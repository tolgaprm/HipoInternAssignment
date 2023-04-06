package com.prcoding.hipointernassignment.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prcoding.hipointernassignment.data.model.Member
import com.prcoding.hipointernassignment.data.repository.HipoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val hipoRepository: HipoRepository
) : ViewModel() {

    var state = mutableStateOf(MainActivityState())
        private set

    private val membersWithoutSearch = MutableStateFlow(emptyList<Member>())


    init {
        viewModelScope.launch {
            state.value = state.value.copy(
                isLoading = true
            )
            val result = hipoRepository.getMembers()
            result.onSuccess { members ->
                state.value = state.value.copy(
                    members = members,
                    isLoading = false
                )
                membersWithoutSearch.value = members
            }.onFailure {
                state.value = state.value.copy(
                    errorMessage = it.localizedMessage?.toString(),
                    isLoading = false
                )
            }
        }
    }

    fun onSearch(searchQuery: String) {
        state.value = state.value.copy(
            searchText = searchQuery
        )
        if (searchQuery.isEmpty()) {
            state.value = state.value.copy(
                members = membersWithoutSearch.value
            )
        } else {
            val filteredList = filterList(searchQuery = searchQuery)
            state.value = state.value.copy(
                members = filteredList
            )
        }
    }

    private fun filterList(searchQuery: String): List<Member> {
        return membersWithoutSearch.value.filter { it.name.lowercase().contains(searchQuery.lowercase()) }
    }

    fun addMember(member: Member) {
        if (!membersWithoutSearch.value.contains(member)){
            val newList = membersWithoutSearch.value + member
            state.value = state.value.copy(
                members = newList
            )
            membersWithoutSearch.value = newList
        }
    }
}