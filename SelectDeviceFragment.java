package com.muramatsu.fragmenttest2.com.muramatsu.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.muramatsu.fragmenttest2.R;
import com.muramatsu.fragmenttest2.com.muramatsu.bizlogic.MainButtonClick;
import com.muramatsu.fragmenttest2.com.muramatsu.listener.OnClickNextButtonListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muramatsu on 2016/05/15.
 */
public class SelectDeviceFragment extends Fragment {

    public OnClickNextButtonListener mCallback;

    ListView listView;

    List<String> dataList = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_select_device, null);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        listView = (ListView)view.findViewById(R.id.device_list);

        adapter = new ArrayAdapter<String>(
                activity,
                android.R.layout.simple_selectable_list_item,
                dataList);

        adapter.add("Hello!");
        adapter.add("ya!");

        listView.setAdapter(adapter);

        // リストビューのアイテムがクリックされた時に呼び出されるコールバックリスナーを登録します
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                ListView listView = (ListView) parent;

                // クリックされたアイテムを取得します
                String item = (String) listView.getItemAtPosition(position);

                Bundle args = new Bundle();
                args.putString("item", item);

                FragmentManager fragmentManager = null;
                FragmentTransaction fragmentTransaction = null;
                Fragment fragment = null;

                // 登録画面へ
                fragmentManager = activity.getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragment = new ConfirmRegisterFragment();
                fragment.setArguments(args);
                fragmentTransaction.replace(R.id.container, fragment);

                // 戻るボタンでreplace前に戻る
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
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
            this.activity = activity;
        }
    }

}
