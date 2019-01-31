package com.example.ideapad510.sherkatquestionear.Questions;


import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ideapad510.sherkatquestionear.R;

import java.util.ArrayList;

public class MakeRadioButton {
    private Context context;
    RadioGroup rg ;

    public MakeRadioButton(Context context){
        this.context = context;
        rg = ( (((Activity)context).findViewById(R.id.radioGroup)));
    }

    public void addRadioButtons(int number, ArrayList<String> answers) {
//        RadioGroup ll = new RadioGroup(context);
        RadioGroup ll =  ( (((Activity)context).findViewById(R.id.radioGroup)));
        for (int i = 1; i <= number; i++) {
            RadioButton rdbtn = new RadioButton(context);
            rdbtn.setId(View.generateViewId());
            rdbtn.setScaleX((float)0.5);
            rdbtn.setScaleY((float)0.5);
            rdbtn.setTextSize(30);
//            rdbtn.setGravity();
            rdbtn.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            rdbtn.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
            rdbtn.setText(answers.get(i - 1));
//            rdbtn.setText("hi");
//            rdbtn.setText("سلام");
            ll.addView(rdbtn);
        }
//        ((ViewGroup) (((Activity)context).findViewById(R.id.radioGroup))).addView(ll);
    }




    public void makeRadioButtons(int number, ArrayList<String> answers)
    {
//        rg = ( (((Activity)context).findViewById(R.id.radioGroup)));

        for(int i = 0 ; i < number ; i++) {
            RadioButton rb = new RadioButton(context);
            rb.setText(answers.get(i));
            //rg is private member of class which refers to the radio group which I find
            //by id.
            rg.addView(rb);
        }

    }



/*
    protected void onPostExecute(HashMap<String,String> mylist) {
        // TODO Auto-generated method stub
        super.onPostExecute(mylist);
        for(Integer z=0;z<mRG.getChildCount();z++){
            View o =mRG.getChildAt(z);
            ((RadioButton)o).setText(text[z]);


        }

        for(Integer z =0;z< mRG.getChildCount();z++){

            Set set = mylist.entrySet();
            Iterator i = set.iterator();
            View o = mRG.getChildAt(z);

            NumberFormat formatter = new DecimalFormat("#0.00");

            if (o instanceof RadioButton){


                int counted[] = new int[ mRG.getChildCount()];
                int j=0;
                while(i.hasNext()) {


                    enter code here
                    Map.Entry me = (Map.Entry)i.next();
                    String Value=String.valueOf(formatter.format(Double.valueOf(me.getValue().toString())*100/count))+"%";
                    if (Integer.valueOf(me.getKey().toString())==((RadioButton) o).getId())
                    {

                        ((RadioButton)o).setText(text[z]+" "+ Value);
                    }



                }
            }
        }
        progressDialog.hide();
    }

*/

}
