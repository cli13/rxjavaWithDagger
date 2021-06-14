package com.example.apidemo.network

import com.example.apidemo.model.PostResponse
import io.reactivex.Single
import retrofit2.http.GET

interface MyApiServices {
    @GET("posts")
    fun getPosts(): Single<PostResponse>
}