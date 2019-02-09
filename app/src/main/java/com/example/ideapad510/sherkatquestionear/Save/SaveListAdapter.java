package com.example.ideapad510.sherkatquestionear.Save;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ideapad510.sherkatquestionear.Questions.Chosens;
import com.example.ideapad510.sherkatquestionear.R;

import java.util.ArrayList;


public class SaveListAdapter extends ArrayAdapter {
    private final Activity context;
    private final ArrayList<SaveObject> saveArray;
    Chosens chosens;

    public SaveListAdapter(Activity context, ArrayList<SaveObject> saveArray){
        super(context, R.layout.savelist_row , saveArray);

        this.context=context;
        this.saveArray = saveArray;


    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.savelist_row, null,true);

        TextView porseshnameTextView = rowView.findViewById(R.id.porseshnameId);
        TextView questionTextView = rowView.findViewById(R.id.questionId);
        TextView answerTextView = rowView.findViewById(R.id.answerId);
        TextView deletTextView = rowView.findViewById(R.id.deletId);

        porseshnameTextView.setText(saveArray.get(position).getPorseshnameId());
        questionTextView.setText(saveArray.get(position).getQuestionId());
        answerTextView.setText(saveArray.get(position).getAnswerId());
        deletTextView.setText(saveArray.get(position).getDelete());

        return rowView;
    }
}
