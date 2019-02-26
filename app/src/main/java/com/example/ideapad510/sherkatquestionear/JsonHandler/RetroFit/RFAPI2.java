package com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit;

import com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit.JsonPack.Pack;
import com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit.JsonPack.ResponsePack;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RFAPI2 {

    @GET("send-results.php")
    Call<ResponsePack> sendQuery(@Query("req") int reqNumber);

    @POST("send-results.php")
    Call<ResponsePack> sendJsonObj(@Query("req") int reqNumber, @Body Pack pack);

}
