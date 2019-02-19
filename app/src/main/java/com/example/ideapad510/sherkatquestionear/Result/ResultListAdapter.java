package com.example.ideapad510.sherkatquestionear.Result;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

//import com.example.ideapad510.sherkatquestionear.Questions.Chosens;
import com.example.ideapad510.sherkatquestionear.R;

import java.util.ArrayList;


public class ResultListAdapter extends ArrayAdapter {
    private final Activity context;
    private final ArrayList<ResultObject> resultArray;
//    Chosens chosens;

    public ResultListAdapter(Activity context, ArrayList<ResultObject> resultArray){
        super(context, R.layout.resultlist_row, resultArray);

        this.context=context;
        this.resultArray = resultArray;


    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.resultlist_row, null,true);

        TextView porseshnameTextView = rowView.findViewById(R.id.porseshnameId);
        TextView questionTextView = rowView.findViewById(R.id.questionId);
        TextView answerTextView = rowView.findViewById(R.id.answerId);
        TextView pasokhgooTextView = rowView.findViewById(R.id.pasokhgoo);

        porseshnameTextView.setText(resultArray.get(position).getPorseshnameId());
        questionTextView.setText(resultArray.get(position).getQuestionId());
        answerTextView.setText(resultArray.get(position).getAnswerId());
        pasokhgooTextView.setText(resultArray.get(position).getPasokhgoo());

        return rowView;
    }
}
