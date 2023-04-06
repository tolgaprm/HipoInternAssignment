package com.prcoding.hipointernassignment.data.remote

import com.prcoding.hipointernassignment.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface HipoApi {

    @GET("a957d4e0af6f9d35048808e7200ea076/raw/6c988963e8a9a311e9f6fc0e08e5aa32ddda64ec/hipo.json")
    suspend fun getMembers():Response<ApiResponse>


    companion object{
        const val BASE_URL ="https://gist.githubusercontent.com/artizco/"
    }

}