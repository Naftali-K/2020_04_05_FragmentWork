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
import com.android.fragmentwork.fragments.BlankFragment2;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    FragmentTransaction transaction;
    Fragment fragment1, fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager(); // Connecting manager of Fragment
        fragment1 = new BlankFragment(); //make new object of fragment new every time new. other to be error
        fragment2 = new BlankFragment2();


        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() { //onClick Add fragment
            @Override
            public void onClick(View v) {

                /**
                In the object of Fragment we add TAG (is like ID of fragment).
                 And now we can check if this special fragment was opened or not, for not open 2 time same fragment
                 */
                if(manager.findFragmentByTag(BlankFragment.TAG) == null) { //checking, ig fragment was opened before or not

                    transaction = manager.beginTransaction();
                    /**
                     Every time when you making update Fragment, need make new transaction, because after
                     transaction.commit() - activity of this special Transaction finishing.
                     */


                    transaction.add(R.id.fragment_container, fragment1, BlankFragment.TAG); // Here connection class+layout fragment
                    /**
                    Also in connection class+fragment add TAG/ID of fragment, for will can know what already opened
                     */


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

                if(manager.findFragmentByTag(BlankFragment.TAG) != null) { //Checking if fragment 1 was open?
                    Toast.makeText(getBaseContext(), "Remove Fragment", Toast.LENGTH_LONG).show();
                    transaction = manager.beginTransaction();
                    transaction.remove(fragment1);
                }else if(manager.findFragmentByTag(BlankFragment2.TAG) != null){ //or if fragment 2 was open?
                    Toast.makeText(getBaseContext(), "Remove Fragment", Toast.LENGTH_LONG).show();
                    transaction = manager.beginTransaction();
                    transaction.remove(fragment2);
                }else{ //other, no one fragments not was opened
                    Toast.makeText(getBaseContext(), "Remove Fragment, NOT have what remove", Toast.LENGTH_LONG).show();
                }
                transaction.commit(); //again like "DO". after this action destroy transaction
            }
        });

        findViewById(R.id.btn_replace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = manager.beginTransaction();
                if(manager.findFragmentByTag(BlankFragment.TAG) != null){ //checking if was opened fragment 1, so change to 2
                    transaction.remove(fragment1);
                    transaction.replace(R.id.fragment_container, fragment2, BlankFragment2.TAG);
                }else if(manager.findFragmentByTag(BlankFragment2.TAG) != null){ //checking if was opened fragment 2, so change to 1
                    transaction.remove(fragment2);
                    transaction.replace(R.id.fragment_container, fragment1, BlankFragment.TAG);
                }else{ //not have opened fragment, so not have what so switch
                    Toast.makeText(getBaseContext(), "NOT have what Replace", Toast.LENGTH_LONG).show();
                }
                transaction.commit(); //again like "DO". after this action destroy transaction
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
//                if(manager.findFragmentByTag(BlankFragment.TAG) == null){
//                    transaction.add(R.id.fragment_container, fragment);
//                }else{
//                    Toast.makeText(getBaseContext(), "You already opened this fragment", Toast.LENGTH_LONG).show();
//                }
//                break;
//            case R.id.btn_remove_onclick:
//                if(manager.findFragmentByTag(BlankFragment.TAG) != null){
//                    transaction.remove(fragment);
//                }else{
//                    Toast.makeText(getBaseContext(), "Remove Fragment, NOT have what remove", Toast.LENGTH_LONG).show();
//                }
//                break;
//        }
//        transaction.commit();
//    }
}
