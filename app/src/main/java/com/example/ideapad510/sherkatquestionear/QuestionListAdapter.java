package com.example.ideapad510.sherkatquestionear;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Ideapad 510 on 1/23/2019.
 */

public class QuestionListAdapter extends ArrayAdapter {
    private final Activity context;
    private final String[] questionArray;

    public QuestionListAdapter(Activity context, String[] questionArrayParam){

        super(context,R.layout.listview_row , questionArrayParam);

        this.context=context;
        this.questionArray = questionArrayParam;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView questionTextField = (TextView) rowView.findViewById(R.id.question);

        //this code sets the values of the objects to values from the arrays
        questionTextField.setText(questionArray[position]);

        return rowView;

    }
}
