package com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RFAPI {

    @GET("changes/")
    Call<List<Change>> loadChanges(@Query("q") String status);

}
