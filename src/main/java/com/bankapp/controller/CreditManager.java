package controller;

public class CreditManager {
    public float GenCredit(float money, float percents, int years) {
        float credit = 0.0f;
        if (money > 0) {
            if (percents == 25) {
                if (years == 1) {
                    credit = money + (money * percents * years);
                    return credit;
                }
            }
            if (percents == 20) {
                if (years == 2) {
                    credit = money + (money * percents * years);
                    return credit;
                }
            }
            if (percents == 15) {
                if (years == 3) {
                    credit = money + (money * percents * years);
                    return credit;
                }
            }
            if (percents == 14) {
                if (years == 4) {
                    credit = money + (money * percents * years);
                    return credit;
                }
            }
            if (percents == 5) {
                if (years == 5) {
                    credit = money + (money * percents * years);
                }
                return credit;
            }
            return credit;
        }
        return credit;
    }
}
