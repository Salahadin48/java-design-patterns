package javademo.design.patterns.singleton;

import java.io.*;

public class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton(){}

    private static class SingletonHelper{
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance(){
        return SingletonHelper.instance;
    }

    // this above implementation won't preserve the singleton pattern.
    // As a result, we get a different object with different hashcode.
    // Hence, the desired singleton pattern is not preserved after serialization.
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        // deserialize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();

        System.out.println("InstanceOne hashcode = "+instanceOne.hashCode());
        System.out.println("InstanceTwo hashcode = "+instanceTwo.hashCode());
        System.out.println(Long.compare(instanceOne.hashCode(), instanceTwo.hashCode())==0);
    }

    // This method resolves the issue.
    protected Object readResolve(){
        return getInstance();
    }
}
