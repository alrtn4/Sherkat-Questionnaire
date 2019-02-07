package com.example.ideapad510.sherkatquestionear.Questions;

import android.content.Context;
import android.util.Log;

import com.example.ideapad510.sherkatquestionear.Save.SaveController;
import com.example.ideapad510.sherkatquestionear.Save.SaveObject;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

//this class finds which answers are chosen before


public class Chosens {
    Context context;
    SaveController saveController = new SaveController(context);
    String user;
    String TAG = "chosen";
    SaveObject saveObject;

    //user is important because we return the result depending on users choices
    public Chosens(Context context, String user){
        this.context = context;
        this.user = user;
    }

    //returns if this answer is chosen before
    public String isChosen(int questionId, int answerId, String user, String porseshnameId){
        ArrayList<SaveObject> saves = saveController.getAllSaves(user);
        ArrayList<SaveObject> savedAnswersToTheQuestion = getAllAnswersForQuestion(questionId, porseshnameId, saves);
        for(SaveObject svobj : savedAnswersToTheQuestion)
            if(svobj.getAnswerId().equals(String.valueOf(answerId)))
                if(svobj.getDelete().equals("deleted")) {
                    Log.d(TAG, "isChosen: delete = " + svobj.getDelete());
                    return "deleted";
                }
                else if(svobj.getDelete().equals("saved"))
                    return "saved";

        return "empty";
    }

    //returns all answers u have chosen on this question
    private ArrayList<SaveObject> getAllAnswersForQuestion(int questionId, String porseshnameId, ArrayList<SaveObject> saved){
        ArrayList<SaveObject> svobjarray = new ArrayList<>();
        for(SaveObject svobj : saved)
            if((svobj.getQuestionId()).equals(String.valueOf(questionId))  &  svobj.getPorseshnameId().equals(porseshnameId))
                svobjarray.add(svobj);
        return svobjarray;
    }

}
