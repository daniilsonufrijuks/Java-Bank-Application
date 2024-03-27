package managers;

public class CreditManager {
    public float GenCredit(float money, float percents, int years) {
        float credit = 0.0f;
        if (money > 0) {
            credit = money + (money * percents * years);
            return credit;
        }
        return credit;
    }
}
