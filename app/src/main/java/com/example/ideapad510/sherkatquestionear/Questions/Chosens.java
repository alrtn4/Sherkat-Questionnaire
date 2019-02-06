package com.example.ideapad510.sherkatquestionear.Questions;

import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Save.SaveController;
import com.example.ideapad510.sherkatquestionear.Save.SaveObject;

import java.util.ArrayList;

//this class finds which answers are chosen before


public class Chosens {
    Context context;
    SaveController saveController = new SaveController(context);
    String user;

    //user is important because we return the result depending on users choices
    public Chosens(Context context, String user){
        this.context = context;
        this.user = user;
    }

    //returns if this answer is chosen before
    public boolean isChosen(int questionId, int answerId, String user){
        ArrayList<SaveObject> saves = saveController.getAllSaves(user);
        ArrayList<SaveObject> savedAnswersToTheQuestion = getAllAnswersForQuestion(questionId, saves);
        for(SaveObject svobj : savedAnswersToTheQuestion)
            if(svobj.getAnswerId().equals(String.valueOf(answerId)))
                return true;
        return false;
    }

    //returns all answers u have chosen on this question
    private ArrayList<SaveObject> getAllAnswersForQuestion(int questionId, ArrayList<SaveObject> saved){
        ArrayList<SaveObject> svobjarray = new ArrayList<>();
        for(SaveObject svobj : saved)
            if(svobj.getQuestionId().equals(String.valueOf(questionId)))
                svobjarray.add(svobj);
        return svobjarray;
    }

}
