package com.bujilvxing;

import com.bujilvxing.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        initToolBar();
        setTitle("Title");
    }

    @Override
    protected boolean translucentStatusBar() {
        return true;
    }

    @Override
    public void initData() {

    }

}
