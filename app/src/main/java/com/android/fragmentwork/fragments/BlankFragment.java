package com.android.fragmentwork.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.fragmentwork.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    public static final String TAG = "Fragment1"; // This is like ID of fragment. by this TAG you can check, if he was already opened of not

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);

//        Button button = getActivity().findViewById(R.id.remove_text);
        /**
        in "onCreateView" can't use findViewById, because not sure if all layout was made. Because that
         need connect functionality of button in lifeCycle after sure was made layout, is in onResume()
         */
    }


    //remake of LifeCycle onResume() fragment, is will working only after made layout
    @Override
    public void onResume() {
        super.onResume();

        Button button = getActivity().findViewById(R.id.remove_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), "Pushed remove button", Toast.LENGTH_LONG).show(); //test code, for check if button working

                TextView outputText = getActivity().findViewById(R.id.output_text);
                        outputText.setText("Empty Text");
            }
        });
    }
}
