package soft.re.lab7;

public class CustomerPrinter {
    private Customer customer;

    public CustomerPrinter(Customer customer) {
        this.customer = customer;
    }

    public String printCustomerDaysOverdrawn() {
        String accountDescription = "Account: IBAN: " + customer.getAccount().getIban() + ", Days Overdrawn: " + customer.getAccount().getDaysOverdrawn();
        return getFullName() + accountDescription;
    }

    private String getFullName() {
        return customer.getName() + " " + customer.getSurname() + " ";
    }

    public String printCustomerMoney() {
        String accountDescription = "";
        accountDescription += "Account: IBAN: " + customer.getAccount().getIban() + ", Money: " + customer.getAccount().getMoney();
        return getFullName() + accountDescription;
    }

    public String printCustomerAccount() {
        return customer.getAccount().printCustomerAccount();
    }
}
