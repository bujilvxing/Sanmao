package com.bujilvxing.lib.okgo.request;


import com.bujilvxing.lib.okgo.utils.HttpUtils;

import okhttp3.Request;
import okhttp3.RequestBody;

/**
 */
public class HeadRequest extends BaseRequest<HeadRequest> {

    public HeadRequest(String url) {
        super(url);
        method = "HEAD";
    }

    @Override
    public RequestBody generateRequestBody() {
        return null;
    }

    @Override
    public Request generateRequest(RequestBody requestBody) {
        Request.Builder requestBuilder = HttpUtils.appendHeaders(headers);
        url = HttpUtils.createUrlFromParams(baseUrl, params.urlParamsMap);
        return requestBuilder.head().url(url).tag(tag).build();
    }
}