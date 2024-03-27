package generator;


import java.util.Random;
import java.util.UUID;

public class PinKontGen { // Class for generating account numbers and pins

    // method to gen account number
    public String GenKontnum() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    // method to generate pins
    public int GenPinS() {
        String pin = "";
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            pin += Integer.toString(rand.nextInt(9-0) + 0);
        }
        return Integer.parseInt(pin);
    }
    
    // method to generate random number
    public static float generateRandomNumber(float min, float max) {
        Random rand = new Random();
        return min + rand.nextFloat() * (max - min);
    }
}