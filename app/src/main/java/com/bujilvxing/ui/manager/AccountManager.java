package com.bujilvxing.ui.manager;

import android.content.Context;

import com.bujilvxing.constants.SPKey;


/**
 */
public class AccountManager {

    private static AccountManager sInstance;
    private Context mContext;

    private AccountManager(Context context) {
        this.mContext = context;
    }

    public synchronized static AccountManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new AccountManager(context);
        }
        return sInstance;
    }

    /**
     * 判断用户是否登录
     *
     * @return 如果用户id不为0 返回true 表示已登录
     */
    public boolean isLogined() {

        return 0 != PreferenceManager.getInstantce(mContext).getPrefLong(SPKey.User.USERID, 0);
    }


    public long getUserId() {
        return PreferenceManager.getInstantce(mContext).getPrefLong(SPKey.User.USERID, 0);
    }


}
