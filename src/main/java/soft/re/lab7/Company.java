package soft.re.lab7;

public class Company extends Customer {
    private double companyOverdraftDiscount = 1;

    public Company(String name, String email, Account account, double companyOverdraftDiscount) {
        super(name, email, account);
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }

    public void withdraw(double sum, String currency) {
        if (!getAccount().getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }

        getAccount().calculateMoney(sum, true,
                getAccount().isPremium(), companyOverdraftDiscount);
    }

    @Override
    public String getSurname() {
        return "[NO SURNAME]";
    }
}
