package controller;

public class CreditManager {
    public float GenCredit(float money, float percents, int years) {
        float credit = 0.0f;
        if (money > 0) {
            if (percents > 0) {
                if (years == 1) {
                    credit = money + (money * percents * years);
                    return credit;
                }
                if (years == 2) {
                    credit = money + (money * percents * years);
                    return credit;
                }
                if (years == 3) {
                    credit = money + (money * percents * years);
                    return credit;
                }
                if (years == 4) {
                    credit = money + (money * percents * years);
                    return credit;
                }
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
