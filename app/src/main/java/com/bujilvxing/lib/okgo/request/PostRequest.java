package com.bujilvxing.lib.okgo.request;


import com.bujilvxing.lib.okgo.model.HttpHeaders;
import com.bujilvxing.lib.okgo.utils.HttpUtils;
import com.bujilvxing.lib.okgo.utils.OkLogger;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Post请求的实现类，注意需要传入本类的泛型
 */
public class PostRequest extends BaseBodyRequest<PostRequest> {

    public PostRequest(String url) {
        super(url);
        method = "POST";
    }

    @Override
    public Request generateRequest(RequestBody requestBody) {
        try {
            headers.put(HttpHeaders.HEAD_KEY_CONTENT_LENGTH, String.valueOf(requestBody.contentLength()));
        } catch (IOException e) {
            OkLogger.e(e);
        }
        Request.Builder requestBuilder = HttpUtils.appendHeaders(headers);
        return requestBuilder.post(requestBody).url(url).tag(tag).build();
    }
}