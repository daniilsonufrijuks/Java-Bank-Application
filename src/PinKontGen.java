import java.util.Random;
import java.util.UUID;

static class PinKontGen {
    public String GenKontnum() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public int GenPinS() {
        String pin = "";
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            pin += Integer.toString(rand.nextInt(0, 9));
        }
        return String.valueOf(pin);
    }
}