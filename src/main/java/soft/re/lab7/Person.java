package soft.re.lab7;

public class Person extends Customer{

    public Person(String name, String surname, String email, Account account) {
        super(name, surname, email, account);
    }

    public void withdraw(double sum, String currency) {
        if (!getAccount().getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }

        calculateMoney(sum, false, false);
    }
}
