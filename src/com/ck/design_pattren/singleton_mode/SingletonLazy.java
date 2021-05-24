package com.ck.design_pattren.singleton_mode;

/**
 * 单例模式
 * 确保某一个类只有一个实例，并自行实例化向整个系统提供这个实例
 *
 * 懒汉模式
 */
public class SingletonLazy {

    public static SingletonLazy singleton;

    /**
     * 私有化构造函数，防止从外部构建本类实例
     */
    private SingletonLazy() {

    }

    /**
     * 当有人需要使用本类实例时才创建
     * 这样是线程不安全的  不推荐使用
     *
     * 缺点：线程不安全，在高并发情况下回创建多个实例
     * @return
     */
    /*public static SingletonLazy getInstance() {
        if (singleton == null)
            singleton = new SingletonLazy();
        return singleton;
    }*/

    /**
     * 这种方式是线程安全的，不推荐使用
     *
     * 缺点：效率慢，所有人进来都要进行等待，明明只要第一次等待就可以，后面的可以直接return
     * @return
     */
    /*public static synchronized SingletonLazy getInstance() {
        if (singleton == null)
            singleton = new SingletonLazy();
        return singleton;
    }*/

    /**
     * 同步代码块，线程安全 synchronized在静态方法中只能锁类的反射
     *
     * 这种方式同样存在在高并发的情况下会创建多个对象
     * @return
     */
    public static SingletonLazy getInstance() {
        if (singleton == null) {
            synchronized(SingletonHungry.class) {
                singleton = new SingletonLazy();
            }
        }
        return singleton;
    }

}
