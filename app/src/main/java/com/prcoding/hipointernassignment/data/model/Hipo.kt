package com.prcoding.hipointernassignment.data.model

import com.squareup.moshi.Json

data class Hipo(
    val position: String,
    @Json(name = "years_in_hipo") val yearsInHipo: String
)
