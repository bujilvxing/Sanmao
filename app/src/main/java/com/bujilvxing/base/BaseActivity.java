package com.bujilvxing.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bujilvxing.R;
import com.bujilvxing.ui.manager.SystemBarTintManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by union365 on 2016/12/15.
 */

public class BaseActivity extends AppCompatActivity {


    @Bind(R.id.title)
    @Nullable
    TextView mTitle;
    @Bind(R.id.toolbar_lefttxt)
    @Nullable
    TextView toolbarLeftTxt;
    @Bind(R.id.toolbar_righttxt)
    @Nullable
    TextView toolbarRightTxt;
    @Bind(R.id.toolbar_leftbtn)
    @Nullable
    ImageButton toolbarLeftbtn;
    @Bind(R.id.toolbar_rightbtn)
    @Nullable
    ImageButton toolbarRightbtn;
    @Bind(R.id.toolbar)
    @Nullable
    public Toolbar mToolBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initSystemBarTint();
        super.onCreate(savedInstanceState);
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        // 通过注解绑定控件
        ButterKnife.bind(this);

        init(savedInstanceState);
        initView();
        initData();
    }

    public void initData() {
    }

    public void initView() {
    }

    protected int getLayoutId() {
        return 0;
    }

    protected void init(Bundle savedInstanceState) {
    }

    @OnClick({R.id.toolbar_leftbtn})
    @Nullable
    public void onCustomClick(View view) {
        switch (view.getId()) {
          /*  case R.id.load_error_panel:
                loadData();
                break;*/
            case R.id.toolbar_leftbtn:
//                leftBtnOnClick();
                onBackPressed();
                this.finish();
                break;
        }
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:// 点击返回图标事件
//                finish();
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    /**
     * 子类可以重写改变状态栏颜色
     */
    protected int setStatusBarColor() {
        return getColorPrimary();
    }

    /**
     * 子类可以重写决定是否使用透明状态栏
     */
    protected boolean translucentStatusBar() {
        return false;
    }

    /**
     * 设置状态栏颜色
     */
    protected void initSystemBarTint() {
        Window window = getWindow();
        if (translucentStatusBar()) {
            // 设置状态栏全透明
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
            return;
        }
        // 沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0以上使用原生方法
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(setStatusBarColor());
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //4.4-5.0使用三方工具类，有些4.4的手机有问题，这里为演示方便，不使用沉浸式
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintColor(setStatusBarColor());
        }
    }

    /**
     * 获取主题色
     */
    public int getColorPrimary() {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        return typedValue.data;
    }

    /**
     * 获取深主题色
     */
    public int getDarkColorPrimary() {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
        return typedValue.data;
    }


    public void setToolbarBackground(int backgroundId) {
        if (null != mToolBar) {
            mToolBar.setBackgroundColor(backgroundId);
        }
    }

    public void setToolbarTextColor(int colorId) {
        if (null != toolbarLeftTxt) {
            toolbarLeftTxt.setTextColor(colorId);
        }
        if (null != mTitle) {
            mTitle.setTextColor(colorId);
        }
        if (null != toolbarRightTxt) {
            toolbarRightTxt.setTextColor(colorId);
        }
    }

    protected void initToolBar() {
        if (mToolBar != null) {
            setSupportActionBar(mToolBar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }


    public void setTitle(String title) {
        if (mTitle != null) {
            mTitle.setText(title);
        }
    }

    public void setTitle(@StringRes int titleResId) {
        if (mTitle != null) {
            mTitle.setText(titleResId);
        }
    }

    public void setLeftTxtStr(int strId) {
        if (toolbarLeftTxt != null) {
            toolbarLeftTxt.setText(strId);
            toolbarLeftTxt.setVisibility(View.VISIBLE);
        }
    }

    public void setRightTxtStr(int strId) {
        if (toolbarRightTxt != null) {
            toolbarRightTxt.setText(strId);
            toolbarRightTxt.setVisibility(View.VISIBLE);
        }
    }

    public void setRightTxtStr(String str) {
        if (toolbarRightTxt != null) {
            toolbarRightTxt.setText(str);
            toolbarRightTxt.setVisibility(View.VISIBLE);
        }
    }

    public void setLeftBtnDrawable(int drawableId) {
        if (toolbarLeftbtn != null) {
            toolbarLeftbtn.setImageResource(drawableId);
            toolbarLeftbtn.setVisibility(View.VISIBLE);
        }
    }

    public void setRightBtnDrawable(int drawableId) {
        if (toolbarRightbtn != null) {
            toolbarRightbtn.setImageResource(drawableId);
            toolbarRightbtn.setVisibility(View.VISIBLE);
        }
    }


}
