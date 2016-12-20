package com.bujilvxing.constants;

import android.os.Environment;

import java.io.File;

/**
 * Created by union365 on 2016/12/20.
 */

public class Constant {
    public static final String APP_TAG = "BuJiLvXing";



    // 默认存放图片的路径
    public final static String DEFAULT_SAVE_IMAGE_PATH = Environment
            .getExternalStorageDirectory()
            + File.separator
            + "BuJiLvXing"
            + File.separator + "bjlx_img" + File.separator;

    // 默认存放文件下载的路径
    public final static String DEFAULT_SAVE_FILE_PATH = Environment
            .getExternalStorageDirectory()
            + File.separator
            + "BuJiLvXing"
            + File.separator + "download" + File.separator;

}
