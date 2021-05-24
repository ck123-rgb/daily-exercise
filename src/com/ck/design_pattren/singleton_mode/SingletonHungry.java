package com.ck.design_pattren.singleton_mode;

/**
 * 单例模式
 *
 * 饿汉模式
 */
public class SingletonHungry {

    public static final SingletonHungry SINGLETON_HUNGRY = new SingletonHungry();

    private SingletonHungry() {

    }

    /**
     * 这种方式不用线程安全，因为对象已经提前创建好了
     * 谁来都是这个对象，这种方式解决了线程不安全的问题
     * 但是也会造成内存浪费，不管有没有用到这个对象，在这个类加载的时候，对象就已经创建了
     * @return
     */
    public static SingletonHungry getInstance() {
        return SINGLETON_HUNGRY;
    }


}
