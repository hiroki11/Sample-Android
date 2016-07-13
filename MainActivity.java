package com.muramatsu.fragmenttest2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.muramatsu.fragmenttest2.com.muramatsu.bizlogic.MainButtonClick;
import com.muramatsu.fragmenttest2.com.muramatsu.fragment.StartFragment;
import com.muramatsu.fragmenttest2.com.muramatsu.fragment.TeachFragment;
import com.muramatsu.fragmenttest2.com.muramatsu.fragment.TermsFragment;
import com.muramatsu.fragmenttest2.com.muramatsu.listener.OnClickNextButtonListener;

public class MainActivity extends AppCompatActivity implements OnClickNextButtonListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new TermsFragment();
        fragmentTransaction.replace(R.id.container, fragment);

        // 戻るボタンでreplace前に戻る
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    // ボタン押下時の動作
    public void onNextButtonClick(MainButtonClick type){

        type.move(MainActivity.this);

    }
}
