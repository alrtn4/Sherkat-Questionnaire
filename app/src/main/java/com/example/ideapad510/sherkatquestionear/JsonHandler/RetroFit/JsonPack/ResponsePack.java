
package com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit.JsonPack;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsePack {

    @SerializedName("start-pack")
    private StartPack startPack;

    @SerializedName("num-pack")
    private Integer numPack;

    @SerializedName("name-pack")
    private String namePack;

    @SerializedName("type-pack")
    private String typePack;

    @SerializedName("data-pack")
    private ResponseDataPack dataPack = null;

    @SerializedName("end-pack")
    private EndPack endPack;

    public ResponsePack(StartPack startPack, Integer numPack, String namePack, String typePack, ResponseDataPack dataPack, EndPack endPack) {
        this.startPack = startPack;
        this.numPack = numPack;
        this.namePack = namePack;
        this.typePack = typePack;
        this.dataPack = dataPack;
        this.endPack = endPack;
    }

    public StartPack getStartPack() {
        return startPack;
    }

    public void setStartPack(StartPack startPack) {
        this.startPack = startPack;
    }

    public Integer getNumPack() {
        return numPack;
    }

    public void setNumPack(Integer numPack) {
        this.numPack = numPack;
    }

    public String getNamePack() {
        return namePack;
    }

    public void setNamePack(String namePack) {
        this.namePack = namePack;
    }

    public String getTypePack() {
        return typePack;
    }

    public void setTypePack(String typePack) {
        this.typePack = typePack;
    }

    public ResponseDataPack getDataPack() {
        return dataPack;
    }

    public void setDataPack(ResponseDataPack dataPack) {
        this.dataPack = dataPack;
    }

    public EndPack getEndPack() {
        return endPack;
    }

    public void setEndPack(EndPack endPack) {
        this.endPack = endPack;
    }

}
