package com.prcoding.hipointernassignment.data.model

data class ApiResponse(
    val company:String,
    val team:String,
    val members:List<Member>
)
