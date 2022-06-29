package javademo.design.patterns;

import javademo.design.patterns.singleton.EagerInitializedSingleton;
import javademo.design.patterns.singleton.EagerStaticBlockSingleton;
import javademo.design.patterns.singleton.EnumSingleton;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaDesignPatternsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JavaDesignPatternsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        EagerInitializedSingleton instance1 = EagerInitializedSingleton.getInstance();
        System.out.printf("Count: %d\n", instance1.getCount());

        EagerInitializedSingleton instance2 = EagerInitializedSingleton.getInstance();
        System.out.printf("Count: %d\n", instance2.getCount());

        EagerStaticBlockSingleton staticBlockSingleton1 = EagerStaticBlockSingleton.getInstance();
        System.out.printf("Static Singleton count: %d\n", staticBlockSingleton1.getCount());

        EagerStaticBlockSingleton staticBlockSingleton2 = EagerStaticBlockSingleton.getInstance();
        System.out.printf("Static Singleton count: %d\n", staticBlockSingleton2.getCount());

        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        enumSingleton.doSomething();
    }
}
