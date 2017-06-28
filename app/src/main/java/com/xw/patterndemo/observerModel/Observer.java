package com.xw.patterndemo.observerModel;

/**
 * Created by Administrator on 2017/6/28 0028.
 */

public interface Observer<T> {
    void onUpdate(Observable<T> observable,T data);
}
