package com.example.myapitestinfifa

import android.provider.ContactsContract.CommonDataKinds.Nickname
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    //@Headers("Authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJYLUFwcC1SYXRlLUxpbWl0IjoiNTAwOjEwIiwiYWNjb3VudF9pZCI6IjE0NzY2MDM5NjciLCJhdXRoX2lkIjoiMiIsImV4cCI6MTY5MDE4NDc2NCwiaWF0IjoxNjc0NjMyNzY0LCJuYmYiOjE2NzQ2MzI3NjQsInNlcnZpY2VfaWQiOiI0MzAwMTE0ODEiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4ifQ.DloXHd9w1eTUC9a-M9Yfb33ZXxmo0RW2LBUhUNF9sVs")

    //GET 예제
    @GET("posts/1")
    fun getUser(): Call<FifaApi>

    @GET("posts/{page}")
    fun getUserPage(@Path("page") page: String): Call<FifaApi>

    @GET("users/")
    fun getUserInfo(
        @Header("Authorization") Authorization: String,
        @Query("nickname") nickname: String
    ) : Call<FifaApi>


//    @GET("posts/1")
//    fun getStudent(@Query("school_id") schoolId: Int,
//                   @Query("grade") grade: Int,
//                   @Query("classroom") classroom: Int): Call<ExampleResponse>
//
//
//    //POST 예제
//    @FormUrlEncoded
//    @POST("posts")
//    fun getContactsObject(@Field("idx") idx: String): Call<JsonObject>
}