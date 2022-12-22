package soft.re.lab7;

public class Person extends Customer{
    private String surname;

    public Person(String name, String surname, String email, Account account) {
        super(name, email, account);
        this.surname = surname;
    }

    public void withdraw(double sum, String currency) {
        if (!getAccount().getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }

        getAccount().calculateMoney(sum, false,
                false, Account.NO_DISCOUNT);
    }

    @Override
    public String getSurname() {
        return surname;
    }
}
