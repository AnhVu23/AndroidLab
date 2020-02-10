package com.example.retrofitlab

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WikiApi {
    @GET("w/api.php")
    fun getQueryInfo ( @Query("srsearch") search: String,
                       @Query("action") action: String = "query",
                       @Query("format") format: String = "json",
                       @Query("list") list: String = "search") : Call<WikiResponse>
}

data class WikiResponse(val query: WikiQuery)
data class WikiQuery(val searchinfo: WikiSearchInfo)
data class WikiSearchInfo(val totalhits: Int)