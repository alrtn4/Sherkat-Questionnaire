package com.example.ideapad510.sherkatquestionear.Answer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ideapad510.sherkatquestionear.R;

public class AnswerListAdapter extends ArrayAdapter {
    private final Activity context;
    private final String[][] answerArray;
    private final int qustionId;

    public AnswerListAdapter(Activity context, String[][] questionArrayParam, int questionIdParam){

        super(context, R.layout.listview_row , questionArrayParam);

        this.context=context;
        this.answerArray = questionArrayParam;
        this.qustionId = questionIdParam;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        TextView answersTextField = rowView.findViewById(R.id.row);

        if(!(position >= (answerArray[qustionId]).length ))
            answersTextField.setText(answerArray[qustionId][position]);

        return rowView;

    }

}
