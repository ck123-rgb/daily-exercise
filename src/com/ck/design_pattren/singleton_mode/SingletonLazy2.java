package com.ck.design_pattren.singleton_mode;

/**
 * 单例模式
 * 懒汉模式，双重校验锁模式
 */
public class SingletonLazy2 {

    public static SingletonLazy2 singleton;

    private SingletonLazy2() {

    }

    /**
     * 此方式进行了双重校验 推荐使用
     * 第一次判断是否为空，里面使用synchronized进行代码锁，防止创建多个实例
     * 里面再次验证是否为空，所以只要创建一次，后面的不需要排队了
     *
     * 优点：线程安全、延迟加载、效率高
     * @return
     */
    public static SingletonLazy2 getInstance() {

        if (singleton == null) {
            synchronized (SingletonLazy2.class) {
                if (singleton == null)
                    singleton = new SingletonLazy2();
            }
        }
        return singleton;
    }
}
