package com.example.booksapp.data.source.remote

import com.example.booksapp.common.Constans.Endpoint.GET_BOOKS
import com.example.booksapp.common.Constans.Endpoint.GET_BOOKS_DETAİL
import com.example.booksapp.data.model.GetBookDetailResponse
import com.example.booksapp.data.model.GetBooksResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {
    @GET(GET_BOOKS)
    fun getProducts(): Call<GetBooksResponse>

    @GET(GET_BOOKS_DETAİL)

    fun getBookDetail(
        @Query("id") id: Int
    ): Call<GetBookDetailResponse>
}