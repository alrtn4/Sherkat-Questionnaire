package com.example.ideapad510.sherkatquestionear.Params;

import android.content.Context;

/**
 * Created by Ideapad 510 on 2/12/2019.
 */

public class Params {
    private static Params instance;

    private String username;
    private String QT;
    private String AT;
    private String porseshnameId;
    private String pasokhgoo;
    private Context context;

    private Params(){};

    public static Params getInstance(){
        if(instance == null)
            instance = new Params();
        return instance;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setQT(String QT){
        this.QT = QT;
    }

    public void setAT(String AT){
        this.AT = AT;
    }

    public void setPorseshnameId(String porseshnameId){
        this.porseshnameId = porseshnameId;
    }

    public void setPasokhgoo(String pasokhgoo){
        this.pasokhgoo = pasokhgoo;
    }

    public void setContext(Context context){ this.context = context;}

    public String getUsername(){
        return username;
    }

    public String getQT(){
        return QT;
    }

    public String getAT(){
        return AT;
    }

    public String getPorseshnameId(){
        return porseshnameId;
    }

    public String getPasokhgoo(){ return pasokhgoo;}

    public Context getContext(){ return context;}
}
