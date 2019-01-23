package com.example.ideapad510.sherkatquestionear;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AnswerListAdapter extends ArrayAdapter {
    private final Activity context;
    private final String[][] answerArray;
    private final int qustionId;

    public AnswerListAdapter(Activity context, String[][] questionArrayParam, int questionIdParam){

        super(context,R.layout.listview_row , questionArrayParam);

        this.context=context;
        this.answerArray = questionArrayParam;
        this.qustionId = questionIdParam;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView questionTextField = (TextView) rowView.findViewById(R.id.question);

        //this code sets the values of the objects to values from the arrays
        System.out.println("the length is : "+qustionId);
        if(!(position >= (answerArray[qustionId]).length ))
            questionTextField.setText(answerArray[qustionId][position]);

        return rowView;

    }

}
