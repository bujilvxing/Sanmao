package com.bujilvxing.lib.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;

import com.bujilvxing.lib.pulltorefresh.header.MaterialHeader;
import com.bujilvxing.lib.pulltorefresh.loadmore.DefaultLoadMoreViewFooter;
import com.bujilvxing.lib.pulltorefresh.loadmore.ILoadMoreViewFactory;

public class PtrClassicFrameLayout extends PtrFrameLayout {

//    private PtrClassicDefaultHeader mPtrClassicHeader;
    private MaterialHeader mPtrClassicHeader;

    public PtrClassicFrameLayout(Context context) {
        super(context);
        initViews();
    }

    public PtrClassicFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public PtrClassicFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initViews();
    }

    private void initViews() {
        mPtrClassicHeader = new MaterialHeader(getContext());
        setHeaderView(mPtrClassicHeader);
        addPtrUIHandler(mPtrClassicHeader);

        ILoadMoreViewFactory loadMoreViewFactory = new DefaultLoadMoreViewFooter();
        setFooterView(loadMoreViewFactory);
    }

    public MaterialHeader getHeader() {
        return mPtrClassicHeader;
    }

//    /**
//     * Specify the last update time by this key string
//     *
//     * @param key
//     */
//    public void setLastUpdateTimeKey(String key) {
//        if (mPtrClassicHeader != null) {
//            mPtrClassicHeader.setLastUpdateTimeKey(key);
//        }
//    }
//
//    /**
//     * Using an object to specify the last update time.
//     *
//     * @param object
//     */
//    public void setLastUpdateTimeRelateObject(Object object) {
//        if (mPtrClassicHeader != null) {
//            mPtrClassicHeader.setLastUpdateTimeRelateObject(object);
//        }
//    }
}
