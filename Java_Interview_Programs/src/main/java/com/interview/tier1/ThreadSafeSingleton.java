package com.interview.tier1;

import java.io.Serializable;

public final class ThreadSafeSingleton implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    // volatile prevents instruction reordering and guarantees visibility.
    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
        if (instance != null) {
            throw new IllegalStateException("Use getInstance()");
        }
    }

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    // Serialization protection
    private Object readResolve() {
        return getInstance();
    }

    // Cloning protection
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton cannot be cloned");
    }
}
