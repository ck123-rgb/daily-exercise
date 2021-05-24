package com.ck.design_pattren.singleton_mode;

/**
 * 静态内部类写法
 */
public class SingletonStatic {

    private static class SingletonHolder {
        private static final SingletonStatic INSTANCE = new SingletonStatic();
    }

    private SingletonStatic() {

    }

    public static final SingletonStatic getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
