package com.example.ideapad510.sherkatquestionear.Phone;

import android.content.Context;

import com.example.ideapad510.sherkatquestionear.ParentClass.Controller;

/**
 * Created by Ideapad 510 on 2/12/2019.
 */

public class PhoneController extends Controller{
    public PhoneController(Context context){
        super(context);
    }


    public void insertPhoneNumber(String phoneNumber){
        databaseInsertMethods.insertRowPhone(phoneNumber);

    }

    public boolean searchInPhone(String number){
        if (databaseOtherMethods.searchInPhone(number))
            return true;
        return false;

    }
}
