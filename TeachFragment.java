package com.muramatsu.fragmenttest2.com.muramatsu.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.muramatsu.fragmenttest2.R;
import com.muramatsu.fragmenttest2.com.muramatsu.bizlogic.MainButtonClick;
import com.muramatsu.fragmenttest2.com.muramatsu.listener.OnClickNextButtonListener;

/**
 * Created by muramatsu on 2016/05/15.
 */
public class TeachFragment extends Fragment {

    public OnClickNextButtonListener mCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_teach, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button nextButton = (Button) view.findViewById(R.id.next_button_teach);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // クリック時の処理
                // 画面遷移
                mCallback.onNextButtonClick(MainButtonClick.Teach);
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnClickNextButtonListener) {

            // 親Activityとの紐付け
            mCallback = (OnClickNextButtonListener) context;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof OnClickNextButtonListener) {

            // 親Activityとの紐付け
            mCallback = (OnClickNextButtonListener) activity;
        }
    }

}
