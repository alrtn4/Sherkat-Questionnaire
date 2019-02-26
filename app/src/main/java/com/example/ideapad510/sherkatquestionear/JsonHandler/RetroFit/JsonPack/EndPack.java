
package com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit.JsonPack;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EndPack {

    @SerializedName("time")
    private Integer time;
    @SerializedName("num-pack")
    private Integer numPack;

    public EndPack(Integer time, Integer numPack) {
        this.time = time;
        this.numPack = numPack;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getNumPack() {
        return numPack;
    }

    public void setNumPack(Integer numPack) {
        this.numPack = numPack;
    }

}
