package com.muramatsu.fragmenttest2.com.muramatsu.bizlogic;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.muramatsu.fragmenttest2.R;
import com.muramatsu.fragmenttest2.com.muramatsu.fragment.CreateUserFragment;
import com.muramatsu.fragmenttest2.com.muramatsu.fragment.SelectDeviceFragment;
import com.muramatsu.fragmenttest2.com.muramatsu.fragment.StartFragment;
import com.muramatsu.fragmenttest2.com.muramatsu.fragment.TeachFragment;

/**
 * Created by muramatsu on 2016/06/12.
 */
public enum MainButtonClick {
    Terms{
        @Override
        public void move(Activity activity) {

            // Tearch画面へ遷移
            fragmentManager = activity.getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragment = new TeachFragment();
            fragmentTransaction.replace(R.id.container, fragment);

            // 戻るボタンでreplace前に戻る
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    },
    Teach{
        @Override
        public void move(Activity activity) {
            // Start画面へ遷移
            fragmentManager = activity.getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragment = new StartFragment();
            fragmentTransaction.replace(R.id.container, fragment);

            // 戻るボタンでreplace前に戻る
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    },
    New{
        @Override
        public void move(Activity activity) {
            // ユーザ登録へ
            fragmentManager = activity.getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragment = new CreateUserFragment();
            fragmentTransaction.replace(R.id.container, fragment);

            // 戻るボタンでreplace前に戻る
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
    },
    SelectDevice {
        @Override
        public void move(Activity activity) {

            // 製品選択画面へ
            fragmentManager = activity.getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragment = new SelectDeviceFragment();
            fragmentTransaction.replace(R.id.container, fragment);

            // 戻るボタンでreplace前に戻る
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
    };

    abstract public void move(Activity activity);

    FragmentManager fragmentManager = null;
    FragmentTransaction fragmentTransaction = null;
    Fragment fragment = null;

}
