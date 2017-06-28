package com.xw.patterndemo.observerModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/28 0028.
 */

public class Observable<T> {
    List<Observer<T>> mObservers = new ArrayList<Observer<T>>();

    //注册
    public void register(Observer<T> observer) {
        if (observer == null) {
            throw new NullPointerException("observer == null");
        }
        synchronized (this) {
            if (!mObservers.contains(observer))
                mObservers.add(observer);
        }
    }

    //取消注册
    public synchronized void unregister(Observer<T> observer) {
        mObservers.remove(observer);
    }

    //发送事件
    public void notifyObservers(T data) {
        for (Observer<T> observer : mObservers) {
            observer.onUpdate(this, data);
        }
    }

}
