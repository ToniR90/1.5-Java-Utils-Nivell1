package org.example;

import java.io.Serial;
import java.io.Serializable;

public class SerializedCar implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String brand;
    private int price;

    public SerializedCar(String brand , int price){
        this.brand = brand;
        this.price = price;
    }
}
