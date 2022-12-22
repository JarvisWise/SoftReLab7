package soft.re.lab7;

public class Account {

    private String iban;

    private AccountType type;

    private int daysOverdrawn;

    private double money;

    private String currency;

    private Customer customer;

    public static double PREMIUM_COMPANY_DISCOUNT = 2;
    public static double NO_DISCOUNT = 1;

    public Account(AccountType type, int daysOverdrawn) {
        super();
        this.type = type;
        this.daysOverdrawn = daysOverdrawn;
    }

    public double bankcharge() {
        double result = 4.5;

        result += overdraftCharge();

        return result;
    }

    private double overdraftCharge() {
        if (type.isPremium()) {
            double result = 10;
            if (getDaysOverdrawn() > 7)
                result += (getDaysOverdrawn() - 7) * 1.0;
            return result;
        } else
            return getDaysOverdrawn() * 1.75;
    }

    public double overdraftFee() {
        if (type.isPremium()) {
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
                + getMoney() + ", Account type: " + getType();
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
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountType getType() {
        return type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
