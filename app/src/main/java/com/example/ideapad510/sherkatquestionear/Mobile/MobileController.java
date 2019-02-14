package com.example.ideapad510.sherkatquestionear.Mobile;

import android.content.Context;

import com.example.ideapad510.sherkatquestionear.ParentClass.Controller;

/**
 * Created by Ideapad 510 on 2/12/2019.
 */

public class MobileController extends Controller{
    public MobileController(Context context){
        super(context);
    }


    public void insertPhoneNumber(String phoneNumber){
        databaseInsertMethods.insertRowPhone(phoneNumber);

    }
}
