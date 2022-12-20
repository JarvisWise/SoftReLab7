package soft.re.lab7;

public class Customer {

    private String name;
    private String surname;
    private String email;
    private CustomerType customerType;
    private Account account;
    private double companyOverdraftDiscount = 1;

    public Customer(String name, String surname, String email, CustomerType customerType, Account account) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.customerType = customerType;
        this.account = account;
    }

    // use only to create companies
    public Customer(String name, String email, Account account, double companyOverdraftDiscount) {
        this.name = name;
        this.email = email;
        this.customerType = CustomerType.COMPANY;
        this.account = account;
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }

    public void withdraw(double sum, String currency) {
        if (!account.getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }

        /*calculateMoney(sum, customerType == CustomerType.COMPANY,
                customerType == CustomerType.COMPANY && account.getType().isPremium());*/

        if (account.getType().isPremium()) {
            switch (customerType) {
                case COMPANY:
                    // we are in overdraft
                    // 50 percent discount for overdraft for premium account
                    calculateMoney(sum, true, true);
                    break;
                case PERSON:
                    // we are in overdraft
                    calculateMoney(sum, false, false);
                    break;
            }
        } else {
            switch (customerType) {
                case COMPANY:
                    // we are in overdraft
                    // no discount for overdraft for not premium account
                    calculateMoney(sum, true, false);
                    break;
                case PERSON:
                    // we are in overdraft
                    calculateMoney(sum, false, false);
                    break;
            }
        }
    }

    private void calculateMoney(double sum, boolean isCompanyDiscount, boolean isCompanyPremiumDiscount) {
        if (account.getMoney() < 0) {
            account.setMoney(
                    (account.getMoney() - sum)
                    - sum * account.overdraftFee()
                    * (isCompanyDiscount ? companyOverdraftDiscount : 1)
                    / (isCompanyPremiumDiscount ? 2: 1)
            );
        } else {
            account.setMoney(account.getMoney() - sum);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String printCustomerDaysOverdrawn() {
        String accountDescription = "Account: IBAN: " + account.getIban() + ", Days Overdrawn: " + account.getDaysOverdrawn();
        return getFullName() + accountDescription;
    }

    private String getFullName() {
        return name + " " + surname + " ";
    }

    public String printCustomerMoney() {
        String accountDescription = "";
        accountDescription += "Account: IBAN: " + account.getIban() + ", Money: " + account.getMoney();
        return getFullName() + accountDescription;
    }

    public String printCustomerAccount() {
        return "Account: IBAN: " + account.getIban() + ", Money: "
                + account.getMoney() + ", Account type: " + account.getType();
    }
}
