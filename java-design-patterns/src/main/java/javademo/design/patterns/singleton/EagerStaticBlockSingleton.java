package javademo.design.patterns.singleton;

public class EagerStaticBlockSingleton {
    private static EagerStaticBlockSingleton instance;

    private int count;

    private EagerStaticBlockSingleton(){}

    // An object is created and if exception occurs, it's handled.
    // But we are creating the object before being used.
    static {
        try{
            instance = new EagerStaticBlockSingleton();
        }catch (Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance.");
        }
    }

    public static EagerStaticBlockSingleton getInstance(){
        return instance;
    }

    public int getCount(){
        return count++;
    }
}
