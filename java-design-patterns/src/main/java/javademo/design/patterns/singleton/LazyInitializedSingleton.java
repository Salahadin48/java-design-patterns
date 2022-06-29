package javademo.design.patterns.singleton;

public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton(){}

    // an object is created only if it's null and on request.
    // But in a multithreaded environment, if two threads are inside the if block at the same time, them multiple objects can be created.
    public static LazyInitializedSingleton getInstance(){
        if(null == instance){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
