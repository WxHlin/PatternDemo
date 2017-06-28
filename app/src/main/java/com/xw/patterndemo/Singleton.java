package com.xw.patterndemo;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by Administrator on 2017/6/28 0028.
 * 单例模式
 * 1、对于那些比较耗内存的类，只实例化一次可以大大提高性能，尤其是在移动开发中。
 * 2、保持程序运行的时候该中始终只有一个实例存在内存中
 */


//Activity的管理类
public class Singleton {

    /**
     要保证单例，需要做一下几步：
     1、必须防止外部可以调用构造函数进行实例化，因此构造函数必须私有化。
     2、必须定义一个静态函数获得该单例
     3、单例使用volatile修饰
     4、使用synchronized 进行同步处理，并且双重判断是否为null，
        我们看到synchronized (Singleton.class)里面又进行了是否为null的判断，
        这是因为一个线程进入了该代码，如果另一个线程在等待，这时候前一个线程创建
        了一个实例出来完毕后，另一个线程获得锁进入该同步代码，实例已经存在，没必
        要再次创建，因此这个判断是否是null还是必须的。
     */


    private static volatile Singleton instance;
    private Stack<Activity> mActivityStack = new Stack<Activity>();

    private Singleton(){

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


    public void addActicity(Activity act){
        mActivityStack.push(act);
    }

    public void removeActivity(Activity act){
        mActivityStack.remove(act);
    }

    public void killMyProcess(){
        int nCount = mActivityStack.size();
        for (int i = nCount - 1; i >= 0; i--) {
            Activity activity = mActivityStack.get(i);
            activity.finish();
        }

        mActivityStack.clear();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
