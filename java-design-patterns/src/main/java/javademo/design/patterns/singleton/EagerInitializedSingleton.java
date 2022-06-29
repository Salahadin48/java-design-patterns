package javademo.design.patterns.singleton;

public class EagerInitializedSingleton {
    // this creates one and only one private object
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    // But what if an exception occurs during creating the object?
    // this procedure of the pattern won't solve the problem.

    private int count = 0;

    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance(){
        return instance;
    }

    public int getCount(){
        return count++;
    }
}
