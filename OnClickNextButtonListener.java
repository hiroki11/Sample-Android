package com.muramatsu.fragmenttest2.com.muramatsu.listener;

import com.muramatsu.fragmenttest2.com.muramatsu.bizlogic.MainButtonClick;

/**
 * Created by muramatsu on 2016/06/08.
 */
// コールバック用のinterfaceを定義
public interface OnClickNextButtonListener {

    public void onNextButtonClick(MainButtonClick type);
}