import org.academiadecodigo.javabank.controller.BalanceController;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.CheckingAccount;
import org.academiadecodigo.javabank.model.account.SavingsAccount;
import org.academiadecodigo.javabank.view.BalanceView;
import org.academiadecodigo.javabank.view.Messages;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class BalanceViewTest {

    private BalanceController balanceController;
    private BalanceView balanceView;
    private Customer customer;
    private PrintStream out;

    @Before
    public void setup() {

        // setup
        balanceController = mock(BalanceController.class);
        balanceView = new BalanceView();
        customer = mock(Customer.class);
        out = mock(PrintStream.class);

        balanceView.setBalanceController(balanceController);
        System.setOut(out);
    }

    @Test
    public void showTest() {

        // setup
        String fakeName = "Edgar";
        customer = new Customer();
        customer.setName(fakeName);
        customer.addAccount(new CheckingAccount());
        customer.addAccount(new SavingsAccount());
        when(balanceController.getCustomer()).thenReturn(customer);

        double fakeBalance = 1000;
        when(balanceController.getCustomerBalance()).thenReturn(fakeBalance);

        // exercise
        balanceView.show();

        // verify
        verify(balanceController).getCustomer();
        verify(balanceController).getCustomerBalance();
        verify(out).println(contains(fakeName + Messages.VIEW_BALANCE_MESSAGE));
    }
}
