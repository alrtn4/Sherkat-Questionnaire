package com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit.JsonPack;

import android.support.annotation.NonNull;

import com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit.JsonPack.DataPack;
import com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit.JsonPack.EndPack;
import com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit.JsonPack.Pack;
import com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit.JsonPack.StartPack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MakeJsonObjs {

    DataPack dataPack = new DataPack(1, "1","1","1","1","1","1",
            "1","1","1","1","1","1","1");

    List<DataPack> dataPackList =  new ArrayList<DataPack>();

    StartPack startPack = new StartPack(1,1);

    EndPack endPack = new EndPack(1,1);


    public Pack getJsonObjs(){
        dataPackList.add(dataPack);

        Pack pack = new Pack(startPack, 1, "1", "1", dataPackList, endPack);

        return pack;
    }
}
