package managers;

import java.io.FileWriter;
import java.io.IOException;

public class CreditManager {
    public float GenCredit(float money, float percents, int years) {
        float credit = 0.0f;
        if (money > 0) {
            credit = (float) (money * Math.pow(1 + percents / 100, years));
            return credit;
        }
        return credit;
    }

    public static void WriteCredittoFile(String userpcode, float credit) {
        try {
            FileWriter writer = new FileWriter("resources/credits.csv");
            writer.write(userpcode + ", " + credit);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
