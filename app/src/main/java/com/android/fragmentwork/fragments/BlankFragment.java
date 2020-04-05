package com.android.fragmentwork.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    }
}
