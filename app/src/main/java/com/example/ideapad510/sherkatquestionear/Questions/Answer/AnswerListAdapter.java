package com.example.ideapad510.sherkatquestionear.Questions.Answer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ideapad510.sherkatquestionear.R;

import java.util.ArrayList;

public class AnswerListAdapter extends ArrayAdapter {
    private final Activity context;
    private final ArrayList<String> answerArray;

    public AnswerListAdapter(Activity context, ArrayList<String> answerArray){
        super(context, R.layout.listview_row , answerArray);

        this.context=context;
        this.answerArray = answerArray;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        TextView answersTextField = rowView.findViewById(R.id.row);

        answersTextField.setText(answerArray.get(position));

        return rowView;

    }

}
