import java.util.Random;
import java.util.UUID;

static class PinKontGen {

    // method to gen account number
    public String GenKontnum() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    // method to generate pins
    public int GenPinS() {
        String pin = "";
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            pin += Integer.toString(rand.nextInt(0, 9));
        }
        return String.valueOf(pin);
    }
}