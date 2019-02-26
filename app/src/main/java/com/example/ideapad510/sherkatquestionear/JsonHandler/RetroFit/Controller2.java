package com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit;


import android.util.Log;

import com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit.JsonPack.MakeJsonObjs;
import com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit.JsonPack.ResponseDataPack;
import com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit.JsonPack.ResponsePack;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

public class Controller2 implements Callback<ResponsePack>{

    static final String BASE_URL = "http://jmr.samim.org/JMR-Q/req-app/";
    String TAG = "Controller2";

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

        RFAPI2 rfAPI = retrofit.create(RFAPI2.class);

        Call<ResponsePack> call = rfAPI.sendQuery(1);

        Call<ResponsePack> call2 = rfAPI.sendJsonObj(1, new MakeJsonObjs().getJsonObjs());

        try {
//            call.enqueue(this);
/*            call2.enqueue(new Callback<ResponsePack>() {
                @Override
                public void onResponse(Call<ResponsePack> call, Response<ResponsePack> response) {
                    if(response.isSuccessful()) {
                        String result = response.body().toString();
                        System.out.println(" RESPONSEEEEEEEEE  "+result);
                    } else {
                        System.out.println("byeeeeeeeeeeeeeee   "+response.errorBody());
                    }

                }

                @Override
                public void onFailure(Call<ResponsePack> call, Throwable t) {
                    System.out.println("Failureeeeeeeeeeeeeeeeeee   " + t.getMessage());

                }
            });
*/
        }catch (Exception e){
            System.out.println("retrofittttttttttttt   "+e);
        }






        try{
            call.enqueue(this);
        }catch (Exception e){
            Log.d(TAG, "start: "+e);
        }


    }





    @Override
    public void onResponse(Call<ResponsePack> call, Response<ResponsePack> response) {
            if(response.isSuccessful()) {
            ResponsePack result = response.body();
            System.out.println(" RESPONSEEEEEEEEE  "+result.getDataPack().getSuccess());
        } else {
            System.out.println("byeeeeeeeeeeeeeee   "+response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<ResponsePack> call, Throwable t) {
        System.out.println("Failureeeeeeeeeeeeee   " + t.getMessage());

    }




}

