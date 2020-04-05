package com.android.fragmentwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.fragmentwork.fragments.BlankFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    FragmentTransaction transaction;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager(); // Connecting manager of Fragment

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() { //onClick Add fragment
            @Override
            public void onClick(View v) {

                /**
                In the object of Fragment we add TAG (is like ID of fragment).
                 And now we can check if this special fragment was opened or not, for not open 2 time same fragment
                 */
                if(manager.findFragmentByTag(BlankFragment.TAG) == null) { //checking, ig fragment was opened before or not

//                BlankFragment fragment = new BlankFragment();
                    fragment = new BlankFragment(); //make new object of fragment new every time new. other to be error

                    transaction = manager.beginTransaction();
                    /**
                     Every time when you making update Fragment, need make new transaction, because after
                     transaction.commit() - activity of this special Transaction finishing.
                     */

                    transaction.add(R.id.fragment_container, fragment, BlankFragment.TAG); // Here connection class+layout fragment
                    transaction.commit(); //This part like say "DO!" and making update of fragment.
                    /**
                     Also, after you using .commit(), you already lost transaction. And if you will need name any new
                     updates, you need name new transaction and make action
                     */
                }else{
                    Toast.makeText(getBaseContext(), "You already opened this fragment", Toast.LENGTH_LONG).show();
                }

            }
        });

        findViewById(R.id.btn_remove).setOnClickListener(new View.OnClickListener() { //onClick Remove fragment
            @Override
            public void onClick(View v) {

                if(manager.findFragmentByTag(BlankFragment.TAG) != null) { //Checking by TAG if fragment was opened or not. If open, so can close this fragment

                    Toast.makeText(getBaseContext(), "Remove Fragment", Toast.LENGTH_LONG).show();
                    transaction = manager.beginTransaction();
                    transaction.remove(fragment);
                    transaction.commit();

                }else{
                    Toast.makeText(getBaseContext(), "Remove Fragment, NOT have what remove", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

//    //--------------------------------------------------------------------------------------
//    //Option 2, using in the Buttons onClick, and enter number of function that will be using after onClick this button
//    public void myOnClick(View view){
//        Toast.makeText(getBaseContext(), "Used" + view.getId(), Toast.LENGTH_LONG).show();
//        manager = getSupportFragmentManager();
//        transaction = manager.beginTransaction();
//
//        switch (view.getId()){
//            case R.id.btn_add_onclick:
//                transaction.add(R.id.fragment_container, fragment);
//                break;
//            case R.id.btn_remove_onclick:
//                transaction.remove(fragment);
//                break;
//        }
//        transaction.commit();
//    }
}
