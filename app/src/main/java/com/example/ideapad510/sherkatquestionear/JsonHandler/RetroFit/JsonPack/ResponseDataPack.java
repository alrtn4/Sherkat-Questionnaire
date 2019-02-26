
package com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit.JsonPack;

import com.google.gson.annotations.SerializedName;

public class ResponseDataPack {

    @SerializedName("num_pack")
    private  int numPack;

    @SerializedName("success")
    private int success;

    public void setNumPack(int numPack){ numPack = numPack;}

    public int getNumPack(){ return numPack;}

    public void setSuccess(int success){ this.success = success;}

    public int getSuccess(){ return success;}

}
