package com.muramatsu.fragmenttest2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.muramatsu.fragmenttest2.com.muramatsu.bizlogic.MainButtonClick;
import com.muramatsu.fragmenttest2.com.muramatsu.fragment.CreateUserFragment;
import com.muramatsu.fragmenttest2.com.muramatsu.fragment.TermsFragment;
import com.muramatsu.fragmenttest2.com.muramatsu.listener.OnClickNextButtonListener;

/**
 * Created by muramatsu on 2016/06/13.
 */
public class NewUserActivity extends AppCompatActivity implements OnClickNextButtonListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new CreateUserFragment();
        fragmentTransaction.replace(R.id.container, fragment);

        // 戻るボタンでreplace前に戻る
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void onNextButtonClick(MainButtonClick type) {
        type.move(NewUserActivity.this);
    }
}
