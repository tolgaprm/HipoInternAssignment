package com.prcoding.hipointernassignment.data.repository

import com.prcoding.hipointernassignment.data.model.Member
import com.prcoding.hipointernassignment.data.remote.HipoApi
import javax.inject.Inject

class HipoRepository @Inject constructor(
    private val api: HipoApi
) {

    suspend fun getMembers(): Result<List<Member>> {
        val response = api.getMembers()

        return if(response.isSuccessful){
            val members = response.body()?.members ?: emptyList()
            Result.success(members)
        }else{
            Result.failure(Exception("something went wrong"))
        }
    }
}