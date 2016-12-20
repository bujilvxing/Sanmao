package com.bujilvxing.constants;

/**
 */
public interface SPKey {

    interface User {
        String SP_FIRST_TIME_USE = "first_time_use";
        String USERID = "userId";
        String ISFIRST2SETTING = "isFirstToSetting";
        String NICKNAME = "nickName";
        String GENDER = "gender";
        String REGSIDENCE = "residence";
        String AVATAR = "avatar";
        String background = "background";
        String birthday = "birthday";
        String sign = "sign";

        String PLATFORM = "platform";

        String isAttention = "isAttention";
        String upUrl = "upUrl";
        String isBind = "isBind" ;
        String TOKEN = "token";
        String RANDOMPWD = "randomPwd";
        String TEMPLATETYPESHOW = "templateTypeShow";
        String TEMPLATETYPEREQUIRE = "templateTypeRequire";
        String HISTORYSEARCH = "historySearch";
        String HOTSEARCH = "hotSearch";
//        String description = "description";
        String SPLASH_INFO = "splash_info";
        String REGISTER_USER = "register_user";
        String LASTGETTRADETIME = "lastGetTradeTime";
        String LASTGETNOTICETIME = "lastGetNoticeTime";
        String LASTGETDYNATIME = "lastGetDynaTime";
    }

    /**
     * 说明引导
     */
    interface Explain {
        // 第一次进入主界面
        String SP_FIRST_TIME_MAIN = "sp_first_time_main";
        // 第一次进入消息界面
        String SP_FIRST_TIME_MESSAGE = "sp_first_time_message";
        // 第一次进入消息界面
        String SP_FIRST_TIME_MY = "sp_first_time_my";
    }
}
