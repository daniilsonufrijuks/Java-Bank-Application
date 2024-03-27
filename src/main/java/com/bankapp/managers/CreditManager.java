package managers;

public class CreditManager {
    public float GenCredit(float money, float percents, int years) {
        float credit = 0.0f;
        if (money > 0) {
            credit = (float) (money * Math.pow(1 + percents / 100, years));
            return credit;
        }
        return credit;
    }
}
