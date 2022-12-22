package soft.re.lab7;

public class Company extends Customer {
    public Company(String name, String email, Account account, double companyOverdraftDiscount) {
        super(name, email, account, companyOverdraftDiscount);
    }

    public void withdraw(double sum, String currency) {
        if (!getAccount().getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }

        calculateMoney(sum, true, getAccount().getType().isPremium());
    }
}
