package javademo.design.patterns.singleton;

// This pattern ensures tat the singleton won't be destroyed by reflection.
// As enums are jvn singletons.
// The drawback is enum's are not flexible enough. Ex. we can't have lazy initialization.
public enum EnumSingleton {
    INSTANCE;

    public void doSomething(){
        System.out.println("Enum singleton");
    }
}
