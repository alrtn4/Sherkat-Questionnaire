package com.example.ideapad510.sherkatquestionear.Question;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ideapad510.sherkatquestionear.R;

import java.util.ArrayList;

public class QuestionListAdapter extends ArrayAdapter {
    private final Activity context;
    private final ArrayList<String> questionArray;

    public QuestionListAdapter(Activity context, ArrayList<String> questionArray){
        super(context, R.layout.listview_row , questionArray);

        this.context=context;
        this.questionArray = questionArray;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        TextView questionTextField = rowView.findViewById(R.id.row);

        questionTextField.setText(questionArray.get(position));

        return rowView;
    }
}
