package soft.re.lab7;

public class Account {

    private String iban;

    private boolean isPremium;

    private int daysOverdrawn;

    private Money money;

    private Customer customer;

    public static double PREMIUM_COMPANY_DISCOUNT = 2;
    public static double NO_DISCOUNT = 1;

    public Account(boolean isPremium, int daysOverdrawn) {
        super();
        this.money =  new Money();
        this.isPremium = isPremium;
        this.daysOverdrawn = daysOverdrawn;
    }

    public double bankcharge() {
        double result = 4.5;

        result += overdraftCharge();

        return result;
    }

    private double overdraftCharge() {
        if (isPremium) {
            double result = 10;
            if (getDaysOverdrawn() > 7)
                result += (getDaysOverdrawn() - 7) * 1.0;
            return result;
        } else
            return getDaysOverdrawn() * 1.75;
    }

    public double overdraftFee() {
        if (isPremium) {
            return 0.10;
        } else {
            return 0.20;
        }
    }

    public void calculateMoney(double sum, boolean isCompanyDiscount,
                               boolean isCompanyPremiumDiscount, double companyOverdraftDiscount) {
        if (getMoney() < 0) {
            setMoney(
                    (getMoney() - sum)
                            - sum * overdraftFee()
                            * (isCompanyDiscount ? companyOverdraftDiscount : NO_DISCOUNT)
                            / (isCompanyPremiumDiscount ? PREMIUM_COMPANY_DISCOUNT: NO_DISCOUNT)
            );
        } else {
            setMoney(getMoney() - sum);
        }
    }

    public String printCustomerAccount() {
        return "Account: IBAN: " + getIban() + ", Money: "
                + getMoney() + ", Account type: " + (isPremium ? "premium" : "normal");
    }

    public String printCustomerDaysOverdrawn() {
        String accountDescription = "Account: IBAN: " + customer.getAccount().getIban() + ", Days Overdrawn: " + customer.getAccount().getDaysOverdrawn();
        return customer.getFullName() + accountDescription;
    }

    public int getDaysOverdrawn() {
        return daysOverdrawn;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setMoney(double money) {
        this.money.setMoney(money);
    }

    public double getMoney() {
        return money.getMoney();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public String getCurrency() {
        return this.money.getCurrency();
    }

    public void setCurrency(String currency) {
        this.money.setCurrency(currency);
    }
}
