package com.example.ideapad510.sherkatquestionear.Questions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ideapad510.sherkatquestionear.R;


public class Dialog_Fragment extends DialogFragment {
    public Dialog_Fragment() {

        // Empty constructor is required for DialogFragment

        // Make sure not to add arguments to the constructor

        // Use `newInstance` instead as shown below

    }



    public static Dialog_Fragment newInstance(String title) {

        Dialog_Fragment frag = new Dialog_Fragment();

        Bundle args = new Bundle();

        args.putString("title", title);

        frag.setArguments(args);

        return frag;

    }



    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment, container);

    }



    @Override

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        // Get field from view


        // Fetch arguments from bundle and set title

        String title = getArguments().getString("title", "Enter Name");

        getDialog().setTitle(title);

        // Show soft keyboard automatically and request focus to field

//        getDialog().getWindow().setSoftInputMode(

//                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    }

}