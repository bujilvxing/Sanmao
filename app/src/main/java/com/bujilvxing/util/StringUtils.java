package com.bujilvxing.util;

import android.content.Context;
import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class StringUtils {

    /**
     * 是否是有效的手机号码（包含正式的和虚拟的）
     *
     * @param mobile 手机号码
     * @return 是返回true否则返false
     */
    public static boolean isPhoneNumber(String mobile) {
        if (null == mobile || TextUtils.isEmpty(mobile.trim())) {
            return false;
        }
        if (mobile.startsWith("+86")) {
            mobile = mobile.substring(3);
        }
//        Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
        Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9])|(9{3}))\\d{8}$");
        Matcher m = p.matcher(mobile);
        return m.matches() ;
    }


    /***
     * 校验用户输入的昵称是否合法
     */
    public static boolean isNiceName(String nickname) {
        String check = "^[a-zA-Z][a-zA-Z0-9_][\\u4e00-\\u9fa5]{4,12}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(nickname);
        return matcher.matches();
    }

    /**
     * 是否有效邮箱
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        if (null == email || TextUtils.isEmpty(email.trim())) {
            return false;
        }
        String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        return matcher.matches();
    }


    /**
     * 是否是有效的手机号码
     *
     * @param mobile  手机号码
     * @param context 上下文
     * @return 是返回true否则返false
     */
    public static boolean checkPhoneNumber(String mobile, Context context) {
        if (!isPhoneNumber(mobile)) {
            ToastUtils.showShort(context, "手机号码不合法");
            return false;
        }
        return true;
    }


    /**
     * 检查是否是 6~12位数字、字母
     *
     * @param password 密码
     * @return 是返回true否则返false
     */
    public static boolean isRegularPassword(String password) {
        if (null == password || TextUtils.isEmpty(password.trim())) {
            return false;
        }
        Pattern p = Pattern.compile("[a-zA-Z0-9]{6,12}");
        Matcher m = p.matcher(password);
        return m.matches();
    }

    /**
     * 检查是否是 6~12位数字、字母 以及相应的提示
     *
     * @param password 密码
     * @param context  上下文
     * @return 是返回true否则返false
     */
    public static boolean checkPassword(String password, Context context) {
        if (password == null || password.length() < 6 || password.length() > 12) {
            ToastUtils.showShort(context, "请输入6-12位密码");
            return false;
        }
        return true;
    }

    /**
     * 检查是否是6位纯数值验证码
     *
     * @param authCode 验证码
     * @return 符合规则返回 true
     */
    public static boolean isRegularAuthCode(String authCode) {
        if (null == authCode || TextUtils.isEmpty(authCode.trim())) {
            return false;
        }
        Pattern p = Pattern.compile("[0-9]{6}");
        Matcher m = p.matcher(authCode);
        return m.matches();
    }

    /**
     * 检查是否是6位数字
     *
     * @param authCode 验证码
     * @param context  上下文
     * @return 是返回true否则返false
     */
    public static boolean checkAuthCode(String authCode, Context context) {
        if (!isRegularAuthCode(authCode)) {
            ToastUtils.showShort(context, "验证码错误");
            return false;
        }
        return true;
    }


    /**
     * 检查 手机号码和验证码
     *
     * @param phoneNumber 手机号码
     * @param authCode    验证码
     * @param context     上下文
     * @return 是返回true否则返false
     */
    public static boolean checkPhoneNumberAndAuthCode(String phoneNumber, String authCode, Context context) {
        if (!checkPhoneNumber(phoneNumber, context)) {
            return false;
        }
        if (!checkAuthCode(authCode, context)) {
            return false;
        }
        return true;
    }

    /**
     * 检查 手机号码和密码
     *
     * @param phoneNumber 手机号码
     * @param password    密码
     * @param context     上下文
     * @return 是返回true否则返false
     */
    public static boolean checkPhoneNumberAndPassword(String phoneNumber, String password, Context context) {
        if (!checkPhoneNumber(phoneNumber, context)) {
            return false;
        }
        if (!checkPassword(password, context)) {
            return false;
        }
        return true;
    }

    /**
     * 检查昵称和密码
     *
     * @param nickname 昵称
     * @param password 密码
     * @param context  上下文
     * @return 是返回true否则返false
     */
    public static boolean checkNicknameAndPassword(String nickname, String password, Context context) {
        if (!checkNickname(nickname, context)) {
            return false;
        }
        if (!checkPassword(password, context)) {
            return false;
        }
        return true;
    }


    /**
     * 检查昵称以及弹出相应的信息
     *
     * @param nickname 昵称
     * @param context  上下文
     * @return
     */
    public static boolean checkNickname(String nickname, Context context) {
        if (null == nickname || TextUtils.isEmpty(nickname.trim()) || (nickname.length() > 7)) {
            ToastUtils.showShort(context, "昵称长度必须为1-7之间");
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String str){
        if (null == str || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * 检测是否有emoji表情
     *
     * @param source
     * @return
     */
    public static boolean containsEmoji(String source) {
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (!isEmojiCharacter(codePoint)) { //如果不能匹配,则该字符是Emoji表情
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是Emoji
     *
     * @param codePoint 比较的单个字符
     * @return
     */
    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) ||
                (codePoint == 0xD) || ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) || ((codePoint >= 0x10000)
                && (codePoint <= 0x10FFFF));
    }

}