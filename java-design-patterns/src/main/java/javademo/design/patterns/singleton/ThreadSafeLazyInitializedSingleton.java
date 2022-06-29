package javademo.design.patterns.singleton;

public class ThreadSafeLazyInitializedSingleton {
    private static ThreadSafeLazyInitializedSingleton instance;

    private ThreadSafeLazyInitializedSingleton(){}

    // this methods using synchronized key word provide access to only one thread at a time. So it resolves the issue of thread safety.
    // But performance reduced - because of the cost associated with the synchronized key word.
    public static synchronized ThreadSafeLazyInitializedSingleton getInstance(){
        if(null == instance){
            instance = new ThreadSafeLazyInitializedSingleton();
        }
        return instance;
    }

    public static ThreadSafeLazyInitializedSingleton getInstanceUsingDoubleLocking(){
        if(null == instance){
            synchronized (ThreadSafeLazyInitializedSingleton.class){
                if(null == instance){
                    instance = new ThreadSafeLazyInitializedSingleton();
                }
            }
        }
        return instance;
    }
}
