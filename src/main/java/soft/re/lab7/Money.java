package soft.re.lab7;

public class Money {
    private double money;
    private String currency;

    Money () {

    }

    Money (double money, String currency) {
        this.money = money;
        this.currency = currency;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
