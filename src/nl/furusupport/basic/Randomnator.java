package nl.furusupport.basic;

import java.util.Random;

public class Randomnator {
    protected Random randomNator;
    protected int randomInteger;

    public Randomnator(){
        randomNator = new Random();
    }

    public int RandomnizerInt(){
        randomInteger = randomNator.nextInt();
        randomInteger = Math.abs(randomInteger);
        return randomInteger;
    }


}
