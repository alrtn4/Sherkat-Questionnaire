package com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit;


import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<List<Change>>{

    static final String BASE_URL = "https://git.eclipse.org/r/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient client = new OkHttpClient.Builder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        RFAPI rfAPI = retrofit.create(RFAPI.class);

        Call<List<Change>> call = rfAPI.loadChanges("status:open");

        try {
            call.enqueue(this);

        }catch (Exception e){
            System.out.println("retrofittttttttttttt   "+e);
        }


    }



    @Override
    public void onResponse(Call<List<Change>> call, Response<List<Change>> response) {
        if(response.isSuccessful()) {
            List<Change> changesList = response.body();
//            changesList.forEach(change -> System.out.println(change.subject));
            for(Change c: changesList)
                System.out.println("hiiiiiiiiiiiiiiiiii   "+c.subject);
        } else {
            System.out.println("byeeeeeeeeeeeeeee   "+response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Change>> call, Throwable t) {

    }





}

