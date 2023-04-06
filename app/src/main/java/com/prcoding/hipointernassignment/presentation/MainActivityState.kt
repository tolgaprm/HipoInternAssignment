package com.prcoding.hipointernassignment.presentation

import com.prcoding.hipointernassignment.data.model.Member

data class MainActivityState(
    val members:List<Member> = emptyList(),
    val isLoading:Boolean=false,
    val errorMessage:String?=null,
    val searchText:String=""
)