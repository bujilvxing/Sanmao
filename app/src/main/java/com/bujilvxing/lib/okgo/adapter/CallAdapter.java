package com.bujilvxing.lib.okgo.adapter;

/**
 * 返回值的适配器
 */
public interface CallAdapter<T> {

    /**
     * call执行的代理方法
     */
    <R> T adapt(Call<R> call);
}