package com.bujilvxing.lib.okgo.callback;

import android.graphics.Bitmap;


import com.bujilvxing.lib.okgo.convert.BitmapConvert;

import okhttp3.Response;

/**
 * 返回图片的Bitmap，这里没有进行图片的缩放，可能会发生 OOM
 */
public abstract class BitmapCallback extends AbsCallback<Bitmap> {

    @Override
    public Bitmap convertSuccess(Response response) throws Exception {
        Bitmap bitmap = BitmapConvert.create().convertSuccess(response);
        response.close();
        return bitmap;
    }
}