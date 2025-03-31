package org.example;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Exercise5 {

    public static void main(String[] args){
        String serializedCarFilePath = "serializedCar.ser"; //Fitxer per serialitzar l'objecte

        SerializedCar serializedCar = new SerializedCar("Mercedes" , 80000);

        serializeObject(serializedCar , serializedCarFilePath);

        SerializedCar desserializedCar = deserializeObject(serializedCarFilePath);
        if(desserializedCar != null){
            System.out.println("Desserialized car: " + desserializedCar);
        }
    }

    public static void serializeObject(SerializedCar serializedCar, String serializedCarFilePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serializedCarFilePath))) {
            oos.writeObject(serializedCar);
            System.out.println("Object has been serialized to " + serializedCarFilePath);
        } catch (IOException e) {
            System.out.println("An error occurred during serialization: " + e.getMessage());
        }
    }

    public static SerializedCar deserializeObject(String serializedCarFilePath) {
        SerializedCar serializedCar = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serializedCarFilePath))) {
            serializedCar = (SerializedCar) ois.readObject();
            System.out.println("Object has been deserialized from " + serializedCarFilePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred during deserialization: " + e.getMessage());
        }
        return serializedCar;
    }
}
